package com.bueno.interceptor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bueno.component.produto.model.Cache;
import com.bueno.component.produto.model.Produto;
import com.fastsql.sql.builder.SqlTool;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
@RequestScoped
public class AppStatusInterceptor  implements Interceptor {
	
	private final HttpServletRequest request;
	private final HttpSession session;
	
	public AppStatusInterceptor(HttpServletRequest request) {
		super();
		this.request = request;
		this.session = this.request.getSession(true);
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
		 viewStatus();
		 stack.next(method, resourceInstance);
	}
	
	public void viewStatus(){
		List<Status> status = new ArrayList<Status>();
		Status id = new Status("ID", this.session.getId(), "Id da sessao");
		status.add(id);
		
		Enumeration<String> enumeration = this.session.getAttributeNames();
		while(enumeration.hasMoreElements()){
			String nome = enumeration.nextElement();
			if(!"status".equalsIgnoreCase(nome)){
				Object valor = this.session.getAttribute(nome);
				status.add(new Status(nome, valor, null));
			}
		}
		this.session.setAttribute("status", status);
	}
	
	
	public static class Status{
		private final String atributo;
		private final Object valor;
		private final String descricao;
		public Status(String atributo, Object valor, String descricao) {
			super();
			this.atributo = atributo;
			this.valor = valor;
			this.descricao = descricao;
		}
		
		public String getAtributo() {
			return atributo;
		}
		public Object getValor() {
			return valor;
		}
		public String getDescricao() {
			return descricao;
		}
	}
}
