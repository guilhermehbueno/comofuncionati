package com.bueno.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
@RequestScoped
public class BuenosUsuarioInterceptor implements Interceptor {
	
	private final HttpServletRequest request;
	private final HttpSession session;

	public BuenosUsuarioInterceptor(HttpServletRequest request) {
		super();
		this.request = request;
		this.session = this.request.getSession(true);
		System.out.println("Session id: "+this.session.getId());
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
		  System.out.println("Interceptando " + request.getRequestURI());
			isLoggedInGoogle();
			isLoggedInFacebook();
			isLoggedInTwitter();
			isLoggedInThisSystem();
	        stack.next(method, resourceInstance);
	}
	
	private boolean isLoggedInGoogle(){
		UserService userService = UserServiceFactory.getUserService();
		if(!userService.isUserLoggedIn()){
			this.session.setAttribute("login", userService.createLoginURL(request.getRequestURI()));
			//this.session.setAttribute("userName", null);
			return false;
		}else{
			User user = userService.getCurrentUser();
			this.session.setAttribute("userName", user.getEmail());
			this.session.setAttribute("logout", userService.createLogoutURL("/"));
			return true;
		}
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
