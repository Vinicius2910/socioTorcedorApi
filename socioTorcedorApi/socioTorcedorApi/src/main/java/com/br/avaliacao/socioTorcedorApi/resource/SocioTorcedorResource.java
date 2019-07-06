/**
 * 
 */
package com.br.avaliacao.socioTorcedorApi.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.avaliacao.socioTorcedorApi.model.SocioTorcedor;
import com.br.avaliacao.socioTorcedorApi.repository.SocioTorcedorRepository;
import com.br.avaliacao.socioTorcedorApi.service.SocioTorcedorService;

/**
 * @author Vinicius
 *
 */

@RestController
@RequestMapping("/socio-torcedor")
public class SocioTorcedorResource {
	
	@Autowired
	private SocioTorcedorRepository socioTorcedores;
	
	@Autowired
	private SocioTorcedorService socioTorcedoreService;
	
	@PostMapping
	public ResponseEntity<?> adicionar(@Valid @RequestBody SocioTorcedor socio){
		return socioTorcedoreService.adicionar(socio);
	}
	
	@GetMapping
	public List<SocioTorcedor> buscarTodos(){
		return socioTorcedores.findAll();
	}
	
	
}
