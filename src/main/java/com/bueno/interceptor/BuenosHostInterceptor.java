package com.bueno.interceptor;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
@RequestScoped
public class BuenosHostInterceptor implements Interceptor{
	
	private final HttpServletRequest request;
	
	public BuenosHostInterceptor(HttpServletRequest request) {
		super();
		this.request = request;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
		String url = this.request.getHeader("Host");
		this.request.setAttribute("host", "http://"+url);
		stack.next(method, resourceInstance);
	}

}
