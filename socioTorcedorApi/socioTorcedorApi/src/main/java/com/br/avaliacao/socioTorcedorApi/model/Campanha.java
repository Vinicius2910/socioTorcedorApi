/**
 * 
 */
package com.br.avaliacao.socioTorcedorApi.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Vinicius
 *
 */

@Entity
public class Campanha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Nome da campanha é obrigatória")
	private String nomeCampanha;
	
	@NotNull(message = "Data de vigencia é obrigatória")
	private LocalDate dataInicioVigencia;
	
	@NotNull(message = "Data de vigencia é obrigatória")
	private LocalDate dataFimVigencia;
/*
	@ManyToOne
    @JoinColumn(name = "time_id", nullable = true)
    private Time time;
	*/
	
	@NotNull
	private String time;
	
	@ManyToOne
    @JoinColumn(name = "socio_id", nullable = true)
    private SocioTorcedor socioTorcedor;
	
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
	 * @return the nomeCampanha
	 */
	public String getNomeCampanha() {
		return nomeCampanha;
	}
	/**
	 * @param nomeCampanha the nomeCampanha to set
	 */
	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}
	
	/**
	 * @return the dataInicioVigencia
	 */
	public LocalDate getDataInicioVigencia() {
		return dataInicioVigencia;
	}
	/**
	 * @param dataInicioVigencia the dataInicioVigencia to set
	 */
	public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}
	/**
	 * @return the dataFimVigencia
	 */
	public LocalDate getDataFimVigencia() {
		return dataFimVigencia;
	}
	/**
	 * @param dataFimVigencia the dataFimVigencia to set
	 */
	public void setDataFimVigencia(LocalDate dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}
	
	/**
	 * @return the timeId
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * @param timeId the timeId to set
	 */
	public void setTime(String time) {
		this.time= time;
	}
	/**
	 * @return the socioTorcedor
	 */
	public SocioTorcedor getSocioTorcedor() {
		return socioTorcedor;
	}
	/**
	 * @param socioTorcedor the socioTorcedor to set
	 */
	public void setSocioTorcedor(SocioTorcedor socioTorcedor) {
		this.socioTorcedor = socioTorcedor;
	}
	
	

}
