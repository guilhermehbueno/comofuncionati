package com.bueno.interceptor;

import javax.servlet.http.HttpServletRequest;

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
public class BuenosUserInterceptor  implements Interceptor {
	
	private final HttpServletRequest request;
	private final Result result;

	public BuenosUserInterceptor(HttpServletRequest request, Result result) {
		super();
		this.request = request;
		this.result = result;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
		  System.out.println("Interceptando " + request.getRequestURI());
			UserService userService = UserServiceFactory.getUserService();
			if(!userService.isUserLoggedIn()){
				result.include("login", userService.createLoginURL(request.getRequestURI()));
				result.include("userName", null);
			}else{
				User user = userService.getCurrentUser();
				result.include("userName", user.getEmail());
				result.include("logout", userService.createLogoutURL("/"));
			}
		  
	        stack.next(method, resourceInstance);
	}

}
