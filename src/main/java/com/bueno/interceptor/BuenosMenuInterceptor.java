package com.bueno.interceptor;

import static com.fastsql.sql.command.expression.LogicalComparisonExpression.attribute;

import java.util.List;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

import com.bueno.component.menu.model.Menu;
import com.fastsql.sql.builder.SqlTool;

@Intercepts
@SessionScoped
public class BuenosMenuInterceptor implements Interceptor{
	
	private final ServletContext context;

	public BuenosMenuInterceptor(ServletContext request) {
		super();
		this.context = request;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
		if(canRefreshMenu()){
			System.out.println("Atualizando menus...");
			List<Menu> menus = SqlTool
					.getInstance()
					.select(Menu.class)
					.where(attribute("pai").isNull().or("pai").equals(""))
					.build(new Menu())
					.getResult();
			context.setAttribute("menus", menus);
			context.setAttribute("updateMenu", false);
		}
		stack.next(method, resourceInstance);
	}
	
	public boolean canRefreshMenu(){
		Object updateMenu = context.getAttribute("updateMenu");
		List<Menu> menus = (List<Menu>) context.getAttribute("menus");
		if(menus==null || menus.size()<=0){
			return true;
		}
		
		if(updateMenu==null){
			return false;
		}
		return Boolean.parseBoolean(updateMenu.toString());
	}

}
