package com.bueno.component.produto.service;

import java.util.List;

import com.bueno.component.pedido.model.Item;
import com.bueno.component.produto.model.Produto;

public interface ProdutoRepository {
	
	public List<Produto> getProdutosByItemsList(List<Item> itens) throws Exception;
	public Produto getProdutoByItem(Item item) throws Exception;

}
