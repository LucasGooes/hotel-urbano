package com.marinhosoftware.hotelurbano.dto;

import java.io.Serializable;

import com.marinhosoftware.hotelurbano.domain.Quarto;
import com.marinhosoftware.hotelurbano.domain.enums.StatusQuarto;
import com.marinhosoftware.hotelurbano.domain.enums.TipoQuarto;

public class QuartoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String numero;
	private String andar;
	private Integer tipoDoQuarto;
	private Integer status;
	
	public QuartoDTO() {
	}

	public QuartoDTO(Quarto obj) {
		super();
		this.numero = obj.getNumero();
		this.andar = obj.getAndar();
		this.tipoDoQuarto = obj.getTipoQuarto().getCod();
		this.status = obj.getStatus().getCod();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoQuarto getTipoDoQuarto() {
		return TipoQuarto.toEnum(tipoDoQuarto);
	}

	public void setTipoDoQuarto(TipoQuarto tipoDoQuarto) {
		this.tipoDoQuarto = tipoDoQuarto.getCod();
	}

	public StatusQuarto getStatus() {
		return StatusQuarto.toEnum(status);
	}

	public void setStatus(StatusQuarto status) {
		this.status = status.getCod();
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}
	
}
