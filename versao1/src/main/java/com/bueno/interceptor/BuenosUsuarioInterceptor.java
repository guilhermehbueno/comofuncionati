package com.bueno.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

import com.bueno.controller.UsuarioController;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Intercepts
@RequestScoped
public class BuenosUsuarioInterceptor implements Interceptor {
	
	private final HttpServletRequest request;
	private final HttpSession session;
	private final UsuarioController usuarioController;

	public BuenosUsuarioInterceptor(HttpServletRequest request, UsuarioController usuarioController) {
		super();
		this.request = request;
		this.session = this.request.getSession(true);
		this.usuarioController = usuarioController;
		System.out.println("Session id: "+this.session.getId());
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
		try {
			System.out.println("Interceptando " + request.getRequestURI());
			isLoggedInGoogle();
			isLoggedInFacebook();
			isLoggedInTwitter();
			isLoggedInThisSystem();
	        stack.next(method, resourceInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean isLoggedInGoogle() throws Exception{
		UserService userService = UserServiceFactory.getUserService();
		if(!userService.isUserLoggedIn()){
			this.session.setAttribute("login", userService.createLoginURL(request.getRequestURI()));
			return false;
		}else{
			User user = userService.getCurrentUser();
			associateGoogleUserWithSystemUser(user);
			this.session.setAttribute("userName", user.getEmail());
			this.session.setAttribute("logout", userService.createLogoutURL("/"));
			return true;
		}
	}
	
	private void associateGoogleUserWithSystemUser(User user) throws Exception{
		boolean was = getWasAssociateGoogleUserWithSystemUser();
		if(was){
			this.session.setAttribute("wasAssociateGoogleUserWithSystemUser",true);
		}else{
			this.usuarioController.associateGoogleUserWithSystemUser(user);
			this.session.setAttribute("wasAssociateGoogleUserWithSystemUser",true);
		}
	}
	
	private boolean getWasAssociateGoogleUserWithSystemUser(){
		Boolean was = (Boolean) this.session.getAttribute("wasAssociateGoogleUserWithSystemUser");
		if(was==null){
			this.session.setAttribute("wasAssociateGoogleUserWithSystemUser",false);
			return false;
		}
		
		return was.booleanValue();
	}
	
	private boolean isLoggedInFacebook(){
		return false;
	}
	
	private boolean isLoggedInTwitter(){
		return false;
	}
	
	private boolean isLoggedInThisSystem(){
		return false;
	}
	
	
	
	
	

}
