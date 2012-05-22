package com.bueno.controller;

import java.io.Serializable;

import com.bueno.component.produto.model.Produto;
import com.bueno.component.usuario.model.Usuario;
import com.fastsql.sql.builder.SqlTool;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path("usuario")
public class UsuarioController  extends GenericController<Usuario>  implements Serializable{
	
	private static final long serialVersionUID = 6633825796817030947L;
	private final Result result;

	public UsuarioController(Result result) {
		super(result);
		this.result = result;
	}
	
	@Path("save")
	public void save(Usuario usuario) {
		try {
			System.out.println("Salvando: "+usuario);
			SqlTool.insert(usuario).execute();
			result.redirectTo("list"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
