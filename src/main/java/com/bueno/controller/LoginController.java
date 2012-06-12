package com.bueno.controller;

import static com.fastsql.sql.expression.LogicalComparisonExpression.attribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.view.Results;

import com.bueno.component.usuario.model.Usuario;
import com.bueno.component.usuario.model.UsuarioWrapper;
import com.fastsql.sql.builder.SqlTool;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Resource
@RequestScoped
public class LoginController {
	
	private final HttpServletRequest request;
	private final HttpSession session;
	private final Result result;
	
	public LoginController(HttpServletRequest request, Result result) {
		super();
		this.request = request;
		this.result = result;
		this.session = this.request.getSession();
	}

	public void login(String emailUsername, String senha) throws Exception{
		boolean isValid = isUserPasswordValid(emailUsername, senha);
		if(isValid){
			System.out.println("emailUsername: "+emailUsername+" senha:"+senha);
			this.session.setAttribute("userName", emailUsername);
			Usuario usuario = new Usuario();
			usuario.setEmail(emailUsername);
			this.session.setAttribute("user", usuario);
			this.result.use(Results.json()).from(UsuarioWrapper.create(usuario, true)).serialize();
		}else{
			this.result.use(Results.json()).from(UsuarioWrapper.create(new Usuario(), false)).serialize();
		}
	}
	
	private boolean isUserPasswordValid(String email, String senha) throws Exception{
		Usuario user = new Usuario();
		user = SqlTool.getInstance().select(user.getClass()).where(attribute("email").equals(email).and("senha").equals(senha)).execute(user).getUniqueResult();
		if(user == null){
			System.out.println("Usuário não é válido");
			return false;
		}else{
			System.out.println("Usuário é válido");
			return true;
		}
	}
	
	public void logout(){
		this.session.removeAttribute("userName");
		this.session.invalidate();
		UserService userService = UserServiceFactory.getUserService();
		if(userService.isUserLoggedIn()){
			this.result.redirectTo(userService.createLogoutURL("/"));
		}
		this.result.redirectTo("/");
	}

}
