package com.marinhosoftware.hotelurbano.dto;

import java.io.Serializable;

import com.marinhosoftware.hotelurbano.domain.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String rg;
	private String cpf;
	private String email;
	private Integer sexo;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(Cliente obj) {
		nome = obj.getNome();
		rg = obj.getRg();
		cpf = obj.getCpf();
		email = obj.getEmail();
		sexo = obj.getSexo().getCod();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

}
