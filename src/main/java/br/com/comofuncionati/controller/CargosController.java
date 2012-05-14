package br.com.comofuncionati.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.comofuncionati.domain.model.Cargo;

import com.bueno.component.pagina.model.Pagina;
import com.bueno.controller.GenericController;
import com.fastsql.sql.builder.SqlTool;
import static com.fastsql.sql.command.expression.LogicalComparisonExpression.*;

@Resource
@Path("/cargo")
public class CargosController extends GenericController<Cargo>{
	
	private final Result result;
	
	public CargosController(Result result) {
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
			result.include("item", entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
