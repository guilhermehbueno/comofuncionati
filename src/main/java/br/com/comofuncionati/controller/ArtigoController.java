package br.com.comofuncionati.controller;

import static com.fastsql.sql.command.expression.LogicalComparisonExpression.attribute;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;

import com.bueno.component.pagina.model.Pagina;
import com.bueno.controller.GenericController;
import com.fastsql.sql.builder.SqlTool;

@Resource
@RequestScoped
@Path("/artigo")
public class ArtigoController extends GenericController<Pagina>{
	
	private final Result result;

	public ArtigoController(Result result) {
		super(result);
		this.result = result;
	}
	
	@Override
	@Path("{id}/view")
	public void view(String id) {
		try {
			Pagina entidade = new Pagina();
			entidade = SqlTool.getInstance().select(Pagina.class)
							.where(attribute("tituloResumido").equals(id))
							.build(entidade)
							.getUniqueResult();
			this.result.include("item", entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
