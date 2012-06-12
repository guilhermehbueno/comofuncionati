package com.bueno.component.pedido.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.bueno.component.usuario.model.Usuario;

@Entity(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(name="idPedido")
	private String idPedido;
	
	@Column(name="idUsuario")
	private String idUsuario;
	
	@Column(name="dataPedido")
	private String dataPedido;
	
	@Column(name="dataFinalizado")
	private String dataFinalizado;
	
	@Column(name="total")
	private String total;
	
	@Enumerated
	@Column(name="status")
	private PedidoStatusEnum status;
	
	@OneToMany
	@JoinColumn(table="item", referencedColumnName="idPedido")
	private List<Item> itens = new ArrayList<Item>();

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

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getDataFinalizado() {
		return dataFinalizado;
	}

	public void setDataFinalizado(String dataFinalizado) {
		this.dataFinalizado = dataFinalizado;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public PedidoStatusEnum getStatus() {
		return status;
	}

	public void setStatus(PedidoStatusEnum status) {
		this.status = status;
	}

	public List<Item> getItens() {
		return itens;
	}
	
	public boolean addItem(Item item){
		item.setIdPedido(this.idPedido);
		item.setIdUsuario(this.idUsuario);
		this.itens.add(item);
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", idUsuario=" + idUsuario
				+ ", dataPedido=" + dataPedido + ", dataFinalizado="
				+ dataFinalizado + ", total=" + total + ", status=" + status
				+ ", itens=" + itens + "]";
	}
}
