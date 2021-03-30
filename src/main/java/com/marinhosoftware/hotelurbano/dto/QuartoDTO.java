package com.marinhosoftware.hotelurbano.dto;

import java.io.Serializable;

import com.marinhosoftware.hotelurbano.domain.Quarto;

public class QuartoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String numero;
	private Integer tipoDoQuarto;
	private Integer status;
	
	public QuartoDTO() {
	}

	public QuartoDTO(Quarto obj) {
		super();
		this.numero = obj.getNumero();
		this.tipoDoQuarto = obj.getTipoQuarto().getCod();
		this.status = obj.getStatus().getCod();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getTipoDoQuarto() {
		return tipoDoQuarto;
	}

	public void setTipoDoQuarto(Integer tipoDoQuarto) {
		this.tipoDoQuarto = tipoDoQuarto;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
