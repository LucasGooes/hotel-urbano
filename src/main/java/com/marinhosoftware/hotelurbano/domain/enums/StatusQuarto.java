package com.marinhosoftware.hotelurbano.domain.enums;

public enum StatusQuarto {
	
	DISPONIVEL(1, "Disponível"),
	OCUPADO(2, "Ocupado"),
	MANUTENCAO(3, "Manutenção");
	
	private int cod;
	private String descricao;

	private StatusQuarto(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusQuarto toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (StatusQuarto x: StatusQuarto.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("id inválido: " + cod);
	}
	
}
