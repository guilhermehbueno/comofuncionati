package com.bueno.component.pedido.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="item")
public class Item {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(name="idItem")
	private String idItem;
	
	@Column(name="idPedido")
	private String idPedido;
	
	@Column(name="idUsuario")
	private String idUsuario;
	
	@Column(name="idProduto")
	private String idProduto;
	
	@Column(name="dataPedido")
	private String dataPedido;
	
	@Enumerated
	@Column(name="status")
	private PedidoStatusEnum status;
	
	@Column(name="preco")
	private String preco;
	
	@Column(name="quantidade")
	private String quantidade;
	
	@Column(name="total")
	private String total;

	public String getIdItem() {
		return idItem;
	}

	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public PedidoStatusEnum getStatus() {
		return status;
	}

	public void setStatus(PedidoStatusEnum status) {
		this.status = status;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
}
