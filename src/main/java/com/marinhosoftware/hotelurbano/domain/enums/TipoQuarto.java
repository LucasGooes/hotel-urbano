package com.marinhosoftware.hotelurbano.domain.enums;

public enum TipoQuarto {

	STANDARD(1, "Suíte Standard"), MASTER(2, "Suíte Master"), DELUXE(3, "Suíte Deluxe");

	private int cod;
	private String descricao;

	private TipoQuarto(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoQuarto toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoQuarto x : TipoQuarto.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("id inválido: " + cod);
	}
	
}
