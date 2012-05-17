package com.bueno.component.produto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(name="idProduto")
	private String idProduto;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="preco")
	private double preco;

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	} 
}
