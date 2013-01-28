package com.bueno.component.produto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="produto")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = -8481006838545868043L;

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
	
	@Enumerated
	@Column(name="status")
	private ProdutoStatusEnum status;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="descricaoResumida")
	private String descricaoResumida;
	
	public String getDescricaoResumida() {
		return descricaoResumida;
	}

	public void setDescricaoResumida(String descricaoResumida) {
		this.descricaoResumida = descricaoResumida;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ProdutoStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ProdutoStatusEnum status) {
		this.status = status;
	}

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

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome
				+ ", categoria=" + categoria + ", preco=" + preco + ", status="
				+ status + ", descricao=" + descricao + ", descricaoResumida="
				+ descricaoResumida + "]";
	} 
}
