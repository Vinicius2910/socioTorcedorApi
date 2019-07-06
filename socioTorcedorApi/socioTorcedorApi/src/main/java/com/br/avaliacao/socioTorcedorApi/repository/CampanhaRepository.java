/**
 * 
 */
package com.br.avaliacao.socioTorcedorApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.avaliacao.socioTorcedorApi.model.Campanha;
import com.br.avaliacao.socioTorcedorApi.model.SocioTorcedor;

/**
 * @author Vinicius
 *
 */
public interface CampanhaRepository extends JpaRepository<Campanha, Integer>{
	
	public List<Campanha> findBySocioTorcedor(SocioTorcedor socio);

	public Campanha findBySocioTorcedorAndNomeCampanha(SocioTorcedor socio, String nome);
}
