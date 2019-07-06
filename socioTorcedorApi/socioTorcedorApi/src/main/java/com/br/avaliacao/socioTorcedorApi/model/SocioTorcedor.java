/**
 * 
 */
package com.br.avaliacao.socioTorcedorApi.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author Vinicius
 *
 */
@Entity
public class SocioTorcedor {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "NOME é obrigatório")
	private String nome;
	
	@NotNull(message = "EMAIL é obrigatório")
	private String email;
	
	@NotNull(message = "Data de Nascimento é obrigatório")
	private LocalDate dataNascimento;
	
	@NotNull(message = "Time do Coração é obrigatório")
	private String timeCoracao;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dataNascimento
	 */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the timeCoracao
	 */
	public String getTimeCoracao() {
		return timeCoracao;
	}

	/**
	 * @param timeCoracao the timeCoracao to set
	 */
	public void setTimeCoracao(String timeCoracao) {
		this.timeCoracao = timeCoracao;
	}
	
	
}
