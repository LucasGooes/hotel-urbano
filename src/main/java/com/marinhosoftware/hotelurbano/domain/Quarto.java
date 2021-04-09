package com.marinhosoftware.hotelurbano.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marinhosoftware.hotelurbano.domain.enums.StatusQuarto;
import com.marinhosoftware.hotelurbano.domain.enums.TipoQuarto;

@Entity
public class Quarto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numero;
	private String andar;
	private Integer tipoQuarto;
	private Integer status;
	
	@OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL)
	private List<Manutencao> manutencoes = new ArrayList<>();
	
	@ManyToMany(mappedBy = "quartos")
	private List<Reserva> reservas = new ArrayList<>();
	
	public Quarto() {
	}

	public Quarto(Integer id, String numero, String andar, TipoQuarto tipoQuarto, StatusQuarto status) {
		super();
		this.id = id;
		this.numero = numero;
		this.andar = andar;
		this.tipoQuarto = (tipoQuarto==null) ? null : tipoQuarto.getCod();
		this.status = (status==null) ? null : status.getCod();
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
		return TipoQuarto.toEnum(tipoQuarto);
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto.getCod();
	}

	public StatusQuarto getStatus() {
		return StatusQuarto.toEnum(status);
	}

	public void setStatus(StatusQuarto status) {
		this.status = status.getCod();
	}
	
	@JsonIgnore
	public List<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(List<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}
	
	@JsonIgnore
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
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
