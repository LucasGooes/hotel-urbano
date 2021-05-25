package com.marinhosoftware.hotelurbano.dto;

import java.io.Serializable;

import com.marinhosoftware.hotelurbano.domain.Quarto;

public class QuartoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String numero;
	private String andar;
	private Integer tipoQuarto;
	private Integer status;
	private Double valorDiaria;
	
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

	public Integer getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(Integer tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	
}
