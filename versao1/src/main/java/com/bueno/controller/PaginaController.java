package com.bueno.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;

import com.bueno.component.pagina.model.Pagina;
import com.fastsql.sql.builder.SqlTool;

@Resource
@RequestScoped
@Path("/pagina")
public class PaginaController extends GenericController<Pagina>{
	
	private final Result result;

	public PaginaController(Result result) {
		super(result);
		this.result = result;
	}
	
	@Path("{id}/edit")
	public void edit(String id) throws Exception {
		super.edit(id);
		Pagina pagina = new Pagina();
		try {
		List<Pagina> paginas = SqlTool.getInstance()
					.select(pagina.getClass())
					.execute(pagina)
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
						.execute(pagina)
						.getResult();
				result.include("itens", paginas);
			} catch (Exception e) {
				e.printStackTrace();
			}
	} 

}
