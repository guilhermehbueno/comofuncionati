package com.bueno.component.produto.model;

import java.io.Serializable;

public class Cache implements Serializable{

	private static final long serialVersionUID = -417637304520216539L;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Cache [nome=" + nome + "]";
	}
}
