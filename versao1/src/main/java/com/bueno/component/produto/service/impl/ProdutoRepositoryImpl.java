package com.bueno.component.produto.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

import com.bueno.component.pedido.model.Item;
import com.bueno.component.produto.model.Produto;
import com.bueno.component.produto.service.ProdutoRepository;
import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.expression.LogicalComparisonExpression;

@RequestScoped
@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {

	@Override
	public List<Produto> getProdutosByItemsList(List<Item> itens) throws Exception {
		List<Produto> produtos = new ArrayList<Produto>();
		for (Item item : itens) {
			produtos.add(getProdutoByItem(item));
		}
		return produtos;
	}

	@Override
	public Produto getProdutoByItem(Item item) throws Exception {
		String idProduto = item.getIdProduto();
		Produto produto = SqlTool.getInstance().select(Produto.class).where(LogicalComparisonExpression.id(Produto.class).equals(idProduto)).execute(new Produto()).getUniqueResult();
		return produto;
	}
}
