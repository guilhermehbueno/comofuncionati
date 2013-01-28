package com.bueno.component.pedido.service;

import java.util.List;

import com.bueno.component.pedido.model.Item;
import com.bueno.component.pedido.model.Pedido;
import com.bueno.component.pedido.model.PedidoStatusEnum;
import com.bueno.component.usuario.model.Usuario;

public interface PedidoRepository {
	
	public Pedido createPedidoBy(Usuario usuario);
	
	public List<Pedido> getPedidosDoUsuario(Usuario usuario)  throws Exception;
	public Pedido getOrCreateLastPedidoDoUsuarioBy(Usuario usuario, PedidoStatusEnum statusPedido)  throws Exception;
	
	public Pedido gravarPedido(Pedido pedido)  throws Exception;
	public Pedido encerrarPedido(Pedido pedido)  throws Exception;
	public Pedido removerItemDoPedido(Item item)  throws Exception;
	public Pedido atualizaItemDoPedido(Item item)  throws Exception;

}
