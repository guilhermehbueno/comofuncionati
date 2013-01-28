package com.bueno.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;

import com.bueno.component.menu.model.Menu;
import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.expression.LogicalComparisonExpression;

@Resource
@RequestScoped
@Path("/menu")
public class MenuController extends GenericController<Menu>{
	
	private final ServletContext context;
	private final Result result;
	private List<Menu> allMenus;
	
	public MenuController(Result result, ServletContext context) throws Exception {
		super(result);
		this.result = result;
		this.context = context;
		init();
	}
	
	private void init() throws Exception{
		Menu example = new Menu();
		allMenus = SqlTool.getInstance().select(example.getClass()).execute(example).getResult();
	}

	@Path("list")
	public void list(){
		result.include("menusAll", allMenus);
	}
	
	@Path("{id}/edit")
	public void edit(String id) throws Exception{
		Menu example = new Menu();
		Menu menuSelecionaroParaEdicao = 
				SqlTool.getInstance()
						.select(example.getClass())
						.where(LogicalComparisonExpression.id(example.getClass()).equals(id))
						.execute(example)
						.getUniqueResult();
		result.include("menusAll", allMenus);
		result.include("menuEdit", menuSelecionaroParaEdicao);
	}
	
	@Path("save")
	public void save(Menu menu){
		System.out.println("Salvando o menu: "+menu);
		try {
			menu.setId(UUID.randomUUID().toString());
			String pai = menu.getPai();
			if(org.apache.commons.lang3.StringUtils.isEmpty(pai)){
				menu.setPai(null);
			}
			SqlTool
				.getInstance()
				.insert(menu)
				.execute();
			context.setAttribute("updateMenu", true);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}

		result.redirectTo("/menu/list"); 
	}

	
	@Path("update")
	public void update(Menu menu){
		System.out.println("Salvando o menu: "+menu);
		try {
			SqlTool.getInstance()
				.update(menu)
				.where(LogicalComparisonExpression.id(menu.getClass()).equals(menu.getId()))
				.execute();
			context.setAttribute("updateMenu", true);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}

		result.redirectTo("/menu/list"); 
	}

}
