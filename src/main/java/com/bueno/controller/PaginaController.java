package com.bueno.controller;

import com.bueno.component.pagina.model.Pagina;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Resource
@SessionScoped
@Path("/pagina")
public class PaginaController extends GenericController<Pagina>{

	public PaginaController(Result result) {
		super(result);
	}

}
