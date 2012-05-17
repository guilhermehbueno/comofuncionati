package com.bueno.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.bueno.component.produto.model.Pedido;

@Resource
@Path("pedido")
public class PedidoController  extends GenericController<Pedido> {

	public PedidoController(Result result) {
		super(result);
	}
	
	@Path("{idProduto}")
	public void visualizarPedido(String idProduto){
		
	}
	
	@Path("finaliza")
	public void finalizaPedido(Pedido pedido){
		
	}

}
