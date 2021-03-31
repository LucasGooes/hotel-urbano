package com.marinhosoftware.hotelurbano.dto;

import java.io.Serializable;

import com.marinhosoftware.hotelurbano.domain.Quarto;

public class QuartoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String numero;
	private String andar;
	private Integer tipoQuarto;
	private Integer status;
	
	public QuartoDTO() {
	}

	public QuartoDTO(Quarto obj) {
		super();
		this.numero = obj.getNumero();
		this.andar = obj.getAndar();
		this.status= obj.getTipoQuarto().getCod();
		this.tipoQuarto = obj.getStatus().getCod();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTipoDoQuarto() {
		return tipoQuarto;
	}

	public void setTipoDoQuarto(Integer tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
