package com.bueno.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;

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

	public void login(String emailUsername, String senha){
		this.session.setAttribute("userName", emailUsername);
	}
	
	public void logout(){
		this.session.invalidate();
		UserService userService = UserServiceFactory.getUserService();
		if(userService.isUserLoggedIn()){
			this.result.redirectTo(userService.createLogoutURL("/"));
		}
		this.result.redirectTo("/");
	}

}
