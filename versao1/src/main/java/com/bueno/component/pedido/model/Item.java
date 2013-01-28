package com.bueno.component.pedido.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.bueno.component.produto.model.Produto;

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
	
	@OneToOne
	@JoinColumn(table="produto", referencedColumnName="idProduto")
	private Produto produto;
	
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
	
	public static Item create(Produto produto, int quantidade){
		Item item = new Item();
		item.setDataPedido(new Date().toString());
		item.setIdProduto(produto.getIdProduto());
		item.setStatus(PedidoStatusEnum.CURRENT);
		item.setPreco(produto.getPreco()+"");
		item.setQuantidade(quantidade+"");
		item.setTotal((produto.getPreco()*quantidade)+"");
		return item;
	}

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
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", idPedido=" + idPedido
				+ ", idUsuario=" + idUsuario + ", idProduto=" + idProduto
				+ ", produto=" + produto + ", dataPedido=" + dataPedido
				+ ", status=" + status + ", preco=" + preco + ", quantidade="
				+ quantidade + ", total=" + total + "]";
	}
}
