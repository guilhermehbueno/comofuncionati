package com.bueno.controller;

import static com.fastsql.sql.command.expression.LogicalComparisonExpression.id;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.bueno.component.pagina.model.Pagina;
import com.fastsql.sql.builder.SqlTool;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Resource
@SessionScoped
@Path("/pagina")
public class PaginaController extends GenericController<Pagina>{
	
	private final Result result;

	public PaginaController(Result result) {
		super(result);
		this.result = result;
	}
	
	@Path("{id}/edit")
	public void edit(String id) {
		super.edit(id);
		Pagina pagina = new Pagina();
		try {
		List<Pagina> paginas = SqlTool.getInstance()
					.select(pagina.getClass())
					.build(pagina)
					.getResult();
			result.include("itens", paginas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	
	@Path("create")
	public void create() {
		super.create();
		Pagina pagina = new Pagina();
		try {
			List<Pagina> paginas = SqlTool.getInstance()
						.select(pagina.getClass())
						.build(pagina)
						.getResult();
				result.include("itens", paginas);
			} catch (Exception e) {
				e.printStackTrace();
			}
	} 

}
