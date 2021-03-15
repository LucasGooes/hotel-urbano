package com.marinhosoftware.hotelurbano.domain;

import java.io.Serializable;

import com.marinhosoftware.hotelurbano.domain.enums.StatusQuarto;
import com.marinhosoftware.hotelurbano.domain.enums.TipoQuarto;

public class Quarto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String numero;
	private String andar;
	private TipoQuarto tipoQuarto;
	private StatusQuarto status;
	
	public Quarto() {
	}

	public Quarto(Integer id, String numero, String andar, TipoQuarto tipoQuarto, StatusQuarto status) {
		super();
		this.id = id;
		this.numero = numero;
		this.andar = andar;
		this.tipoQuarto = tipoQuarto;
		this.status = status;
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

	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public StatusQuarto getStatus() {
		return status;
	}

	public void setStatus(StatusQuarto status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quarto other = (Quarto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
