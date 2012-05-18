package com.bueno.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Resource
@SessionScoped
@Path("/loja")
public class EcommerceController {
	
	@Path("produtos")
	public void loja(){
		
	}

}
