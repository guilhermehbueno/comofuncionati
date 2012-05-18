package com.bueno.controller;

import static com.fastsql.sql.command.expression.LogicalComparisonExpression.attribute;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;

import com.bueno.component.pagina.model.Pagina;
import com.bueno.component.pagina.model.PaginaTipoEnum;
import com.bueno.component.pagina.model.Paginacao;
import com.bueno.component.pagina.model.PaginacaoUtil;
import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.command.expression.Expression;
import com.fastsql.sql.command.expression.LogicalComparisonExpression;

@Resource
@RequestScoped
@Path("/artigo")
public class ArtigoController extends GenericController<Pagina>{
	
	private final Result result;
	private final HttpServletRequest request;

	public ArtigoController(Result result, HttpServletRequest request) {
		super(result);
		this.result = result;
		this.request = request;
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
			System.out.println("Buscando Paginas associadas");
			initPaginacao(entidade, 1);
			this.result.include("item", entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Path("{id}/view/page/{page}")
	public void view(String id, int page) {
		try {
			Pagina entidade = new Pagina();
			entidade = SqlTool.getInstance().select(Pagina.class)
							.where(attribute("tituloResumido").equals(id))
							.build(entidade)
							.getUniqueResult();
			initPaginacao(entidade, page);
			this.result.include("item", entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initPaginacao(Pagina entidade, int page){
		HttpSession session = this.request.getSession(true);
		if(PaginaTipoEnum.SUBPAGINA.equals(entidade.getTipo())){
			List<Paginacao> paginacao = (List<Paginacao>) session.getAttribute("paginacao");
			PaginacaoUtil.active(paginacao, page);
			session.setAttribute("paginacaoPrev", PaginacaoUtil.getPrev(paginacao));
			session.setAttribute("paginacaoNext", PaginacaoUtil.getNext(paginacao));
			return;
		}
		
		List<Pagina> paginasAssociadas = SqlTool.getInstance().select(Pagina.class).where(LogicalComparisonExpression.attribute("pai").equals(entidade.getIdPagina())).build(entidade).getResult();
		List<Paginacao> paginacao = Paginacao.factory(entidade, paginasAssociadas);
		PaginacaoUtil.order(paginacao);
		PaginacaoUtil.active(paginacao, page);
		if(paginacao.size()<=0){
			paginacao = null;
		}
		
		session.setAttribute("paginacaoPrev", PaginacaoUtil.getPrev(paginacao));
		session.setAttribute("paginacaoNext", PaginacaoUtil.getNext(paginacao));
		session.setAttribute("paginacao", paginacao);
	}

}
