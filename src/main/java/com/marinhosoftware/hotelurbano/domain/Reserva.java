package com.marinhosoftware.hotelurbano.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFim;
	private double valorTotal;
	private int quantDias;
	private double valordiaria;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(name = "RESERVA_QUARTO",
				joinColumns = @JoinColumn(name = "reserva_id"),
				inverseJoinColumns = @JoinColumn(name = "quarto_id")
			)
	private List<Quarto> quartos = new ArrayList<>();
	
	@OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
	private List<Servico> servicos = new ArrayList<>();
	
	public Reserva() {
	}

	public Reserva(Integer id, LocalDate dataInicio, LocalDate dataFim, double valorTotal, int quantDias, double valordiaria,
			Cliente cliente) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = (dataFim==null) ? null : dataFim;
		this.valorTotal = valorTotal;
		this.quantDias = quantDias;
		this.valordiaria = valordiaria;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getQuantDias() {
		return quantDias;
	}

	public void setQuantDias(int quantDias) {
		this.quantDias = quantDias;
	}

	public double getValordiaria() {
		return valordiaria;
	}

	public void setValordiaria(double valordiaria) {
		this.valordiaria = valordiaria;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
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
		Reserva other = (Reserva) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
