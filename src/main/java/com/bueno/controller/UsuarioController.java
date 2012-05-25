package com.bueno.controller;

import static com.fastsql.sql.command.expression.LogicalComparisonExpression.attribute;

import java.io.Serializable;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.bueno.component.usuario.model.Usuario;
import com.fastsql.sql.builder.SqlTool;

@Resource
@Path("usuario")
public class UsuarioController  extends GenericController<Usuario>  implements Serializable{
	
	private static final long serialVersionUID = 6633825796817030947L;
	private final Result result;
	private final HttpServletRequest request;
	private final HttpSession session;

	public UsuarioController(Result result, HttpServletRequest request) {
		super(result);
		this.result = result;
		this.request = request;
		this.session = this.request.getSession();
		System.out.println("Session id: "+this.session.getId());
		System.out.println("Username: "+ this.session.getAttribute("userName"));
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
			usuario = SqlTool.getInstance().select(Usuario.class).where(attribute("nome").equals(nome).and("email").equals(email).and("senha").equals(senha)).build(usuario).getUniqueResult();
			this.session.setAttribute("userName", usuario.getEmail());
			this.session.setAttribute("user", usuario);
			this.result.use(Results.json()).from(usuario).exclude("senha").serialize();
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
