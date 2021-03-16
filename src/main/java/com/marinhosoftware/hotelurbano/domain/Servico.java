package com.marinhosoftware.hotelurbano.domain;

import java.io.Serializable;

public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String tipo;
	private String descricao;
	private double valor;
	
	private Reserva reserva;
	
	public Servico() {
	}

	public Servico(Integer id, String tipo, String descricao, double valor, Reserva reserva) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
		this.reserva = reserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
	
}
