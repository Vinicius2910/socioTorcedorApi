/**
 * 
 */
package com.br.avaliacao.socioTorcedorApi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.avaliacao.socioTorcedorApi.client.CampanhaClient;
import com.br.avaliacao.socioTorcedorApi.client.valueobject.CampanhaVO;
import com.br.avaliacao.socioTorcedorApi.model.Campanha;
import com.br.avaliacao.socioTorcedorApi.model.SocioTorcedor;
import com.br.avaliacao.socioTorcedorApi.repository.CampanhaRepository;
import com.br.avaliacao.socioTorcedorApi.repository.SocioTorcedorRepository;

/**
 * @author Vinicius
 *
 */

@Service
public class SocioTorcedorService {

	@Autowired
	private SocioTorcedorRepository socioTorcedores;

	@Autowired
	private CampanhaRepository campanhaAtivaRepository;

	@Autowired
	private CampanhaClient campanhaClient;

	public ResponseEntity<?> adicionar(SocioTorcedor socio){
		SocioTorcedor socioExistente = socioTorcedores.findByEmail(socio.getEmail());
		
		if(socioExistente == null){
			socioTorcedores.save(socio);
			List<CampanhaVO> campanhas = campanhaClient.listar();
			campanhas = filtro(campanhas, socio.getTimeCoracao());
			for(CampanhaVO campanhaVO : campanhas){
				Campanha campanha = montarCampanha(campanhaVO, socio);
				campanhaAtivaRepository.save(campanha);
			}
			return ResponseEntity.ok(socio);
		}
		else{
			List<CampanhaVO> campanhas = campanhaClient.listar();
			verificarAtualização(campanhas, socio);
			return ResponseEntity.ok(campanhas);
		}
	}

	public Campanha montarCampanha(CampanhaVO campanha, SocioTorcedor socio) {
		Campanha campanhaRelacionada = new Campanha();
		campanhaRelacionada.setNomeCampanha(campanha.getNomeCampanha());
		campanhaRelacionada.setDataInicioVigencia(campanha
				.getDataInicioVigencia());
		campanhaRelacionada.setDataFimVigencia(campanha.getDataFimVigencia());
		campanhaRelacionada.setTime(campanha.getTime().getNome());
		campanhaRelacionada.setSocioTorcedor(socio);

		return campanhaRelacionada;
	}

	public void verificarAtualização(List<CampanhaVO> campanhas,
			SocioTorcedor socio) {
		for (CampanhaVO campanhaVO : campanhas) {
			Campanha campanha = campanhaAtivaRepository
					.findBySocioTorcedorAndNomeCampanha(socio,
							campanhaVO.getNomeCampanha());
			if (campanha == null) {
				campanha = montarCampanha(campanhaVO, socio);
				campanhaAtivaRepository.save(campanha);
			}
		}
	}

	public List<CampanhaVO> filtro( List<CampanhaVO> campanhas, String time){
		return campanhas.stream().filter(i-> i.getTime().getNome().equalsIgnoreCase(time)).collect(Collectors.toList());
		
	}
}
