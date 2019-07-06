package com.br.avaliacao.socioTorcedorApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.avaliacao.socioTorcedorApi.model.SocioTorcedor;

public interface SocioTorcedorRepository extends JpaRepository<SocioTorcedor, Integer> {

	public Boolean existsByEmail(String email);
	
	public SocioTorcedor findByEmail(String email);
}
