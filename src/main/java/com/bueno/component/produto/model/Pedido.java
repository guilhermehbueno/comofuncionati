package com.bueno.component.produto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="pedido")
public class Pedido {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(name="idPedido")
	private String idPedido;
	
	@OneToOne
	@JoinColumn(table="produto", referencedColumnName="produto")
	private Produto produto;
	
	@Column(name="quantidade")
	private int quantidade;
	
	@Column(name="total")
	private double total;
	
	@Column(name="dataPedido")
	private Date dataPedido;
	
	@Column(name="usuario")
	private String usuario;

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
