package com.bueno.component.pedido.service.impl;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

import com.bueno.component.pedido.model.Item;
import com.bueno.component.pedido.model.Pedido;
import com.bueno.component.pedido.model.PedidoStatusEnum;
import com.bueno.component.pedido.service.PedidoRepository;
import com.bueno.component.usuario.model.Usuario;
import com.fastsql.sql.builder.SqlTool;
import static com.fastsql.sql.expression.LogicalComparisonExpression.*;

@RequestScoped
@Component
public class PedidoRepositoryImpl implements PedidoRepository{

	@Override
	public List<Pedido> getPedidosDoUsuario(Usuario usuario) throws Exception {
		List<Pedido> pedidos = SqlTool
									.getInstance()
									.select(Pedido.class)
									.where(attribute("idUsuario").equals(usuario.getIdUsuario()))
									.execute(new Pedido())
									.getResult();
		return pedidos;
	}

	@Override
	public Pedido getOrCreateLastPedidoDoUsuarioBy(Usuario usuario, PedidoStatusEnum statusPedido) throws Exception {
		Pedido pedido= SqlTool
							.getInstance()
							.select(Pedido.class)
							.where(
								attribute("idUsuario").equals(usuario.getIdUsuario())
								.and("status").equals(statusPedido.name())
							  )
							.execute(new Pedido())
							.getUniqueResult();
		
		if(pedido==null){
			pedido = createPedidoBy(usuario);
		}
		return pedido;
	}

	@Override
	public Pedido gravarPedido(Pedido pedido) throws Exception {
		if(pedido.getIdPedido()==null){
			pedido = (Pedido) SqlTool.getInstance().insert(pedido).execute();
			List<Item> itens = pedido.getItens();
			for (Item item : itens) {
				item.setIdPedido(pedido.getIdPedido());
				item.setIdUsuario(pedido.getIdUsuario());
			}
			
			for (Item item : itens) {
				SqlTool.getInstance().insert(item).execute();
			}
		}else{
			pedido = (Pedido) SqlTool.getInstance().update(pedido).where(id(Pedido.class).equals(pedido.getIdPedido())).execute();
			List<Item> itens = pedido.getItens();
			for (Item item : itens) {
				if(item.getIdItem()!=null){
					SqlTool.getInstance().update(item).where(id(Item.class).equals(item.getIdPedido())).execute();
				}else{
					SqlTool.getInstance().insert(item).execute();
				}
			}
		}
		return pedido;
	}

	@Override
	public Pedido encerrarPedido(Pedido pedido) throws Exception {
		pedido.setStatus(PedidoStatusEnum.FECHADO);
		pedido = (Pedido) SqlTool.getInstance().update(pedido).where(id(Pedido.class).equals(pedido.getIdPedido())).execute();
		return pedido;
	}

	@Override
	public Pedido createPedidoBy(Usuario usuario) {
		Pedido pedido = new Pedido();
		pedido.setIdUsuario(usuario.getIdUsuario());
		pedido.setStatus(PedidoStatusEnum.CURRENT);
		return pedido;
	}

	@Override
	public Pedido removerItemDoPedido(Item item) throws Exception {
		String idPedido = item.getIdPedido();
		SqlTool.getInstance().delete(item).where(id(Item.class).equals(item.getIdItem())).execute();
		Pedido pedido = SqlTool.getInstance().select(Pedido.class).where(id(Pedido.class).equals(idPedido)).execute(new Pedido()).getUniqueResult();
		return pedido;
	}

	@Override
	public Pedido atualizaItemDoPedido(Item item) throws Exception {
		SqlTool.getInstance().update(item).where(id(Item.class).equals(item.getIdItem()).and("")).execute();
		Pedido pedido = SqlTool.getInstance().select(Pedido.class).where(id(Pedido.class).equals(item.getIdPedido())).execute(new Pedido()).getUniqueResult();
		return pedido;
	}

}
