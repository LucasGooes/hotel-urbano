package com.marinhosoftware.hotelurbano.dto;

import com.marinhosoftware.hotelurbano.domain.Quarto;

public class QuartoDTO {
	
	private Integer id;
	private String numero;
	private String andar;
	private Integer tipoDoQuarto;
	private Integer status;
	
	public QuartoDTO() {
	}

	
	
	public QuartoDTO(Quarto obj) {
		super();
		this.id = obj.getId();
		this.numero = obj.getNumero();
		this.andar = obj.getAndar();
		/*
		this.tipoDoQuarto = obj.getTipoQuarto();
		this.status = obj.getStatus();*/
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
