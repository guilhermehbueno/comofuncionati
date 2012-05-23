package com.bueno.controller;

import java.io.Serializable;
import java.util.UUID;

import com.bueno.component.produto.model.Produto;
import com.bueno.component.usuario.model.Usuario;
import com.fastsql.sql.builder.SqlTool;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
@Path("usuario")
public class UsuarioController  extends GenericController<Usuario>  implements Serializable{
	
	private static final long serialVersionUID = 6633825796817030947L;
	private final Result result;

	public UsuarioController(Result result) {
		super(result);
		this.result = result;
	}
	
	@Path("salvar")
	public void save(String nome, String email, String senha) {
		try {
			System.out.println("Salvando: "+nome+" email:"+email+" senha:"+senha);
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			SqlTool.insert(usuario).execute();
			result.redirectTo("/"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Path("exibir")
	public void exibir() {
		try {
			Usuario usuario = new Usuario();
			usuario.setEmail("hhh@hhh.com");
			usuario.setIdUsuario(UUID.randomUUID().toString());
			usuario.setNome("MMMMM MMMMM");
			usuario.setObservacao("TESTE");
			usuario.setSenha("MMMMmm");
			usuario.setStatus("ATIVO");
			usuario.setTipo("USUARIO");
			this.result.use(Results.json()).from(usuario).serialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			
}
