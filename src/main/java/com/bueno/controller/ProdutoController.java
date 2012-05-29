package com.bueno.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.bueno.component.produto.model.Produto;
import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.command.expression.LogicalComparisonExpression;

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
			produto = SqlTool.getInstance()
							.select(Produto.class)
							.where(LogicalComparisonExpression.id(Produto.class).equals(id))
							.execute(produto)
							.getUniqueResult();
			result.include("produto", produto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Path("categoria/{nome}")
	public void categoria(String nome) throws Exception{
		Produto example = new Produto();
		List<Produto> produtos = 
					SqlTool.getInstance()
					.select(example.getClass())
					.where(LogicalComparisonExpression.attribute("categoria").equals(nome)).execute(example).getResult();
		result.include("produtos", produtos);
	}
	
	@Path("/loja/produtos")
	public void produtos(){
		
	}

}
