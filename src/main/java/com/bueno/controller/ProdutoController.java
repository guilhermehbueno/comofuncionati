package com.bueno.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.bueno.component.produto.model.Produto;

@Resource
@Path("produto")
public class ProdutoController extends GenericController<Produto> {
	
	private final Result result;
	
	public ProdutoController(Result result) {
		super(result);
		this.result = result;
	}


	@Path("{id}/view")
	public void view(String id) {
		Produto produto = new Produto();
		try {
			/*
			produto = SqlTool.getInstance()
							.select(Produto.class)
							.where(id(Produto.class).equals(id))
							.build(produto)
							.getUniqueResult();
			*/
			result.include("produto", produto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
