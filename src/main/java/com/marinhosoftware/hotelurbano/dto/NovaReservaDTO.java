package com.marinhosoftware.hotelurbano.dto;

import java.util.List;

public class NovaReservaDTO {
	
	private int quantDias;
	private int clienteId;
	private List<Integer> quartoId;
	
	public NovaReservaDTO() {
	}
	
	public int getQuantDias() {
		return quantDias;
	}
	
	public void setQuantDias(int quantDias) {
		this.quantDias = quantDias;
	}
	
	public int getClienteId() {
		return clienteId;
	}
	
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public List<Integer> getQuartoId() {
		return quartoId;
	}

	public void setQuartoId(List<Integer> quartoId) {
		this.quartoId = quartoId;
	}
}
