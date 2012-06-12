package com.bueno.controller;

import static com.fastsql.sql.expression.LogicalComparisonExpression.attribute;

import java.io.Serializable;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.bueno.component.usuario.model.Usuario;
import com.bueno.component.usuario.model.UsuarioWrapper;
import com.fastsql.sql.builder.SqlTool;
import com.google.appengine.api.users.User;

@Resource
@Path("usuario")
public class UsuarioController  extends GenericController<Usuario>  implements Serializable{
	
	private static final long serialVersionUID = 6633825796817030947L;
	private final Result result;
	private final HttpServletRequest request;
	private final HttpSession session;
	private final LoginController loginController;
	

	public UsuarioController(Result result, HttpServletRequest request, LoginController loginController) {
		super(result);
		this.result = result;
		this.request = request;
		this.session = this.request.getSession();
		this.loginController = loginController;
		System.out.println("Session id: "+this.session.getId());
		System.out.println("Username: "+ this.session.getAttribute("userName"));
		
	}
	
	@Path("salvar")
	public void save(String nome, String email, String senha) {
		try {
			System.out.println("Salvando: "+nome+" email:"+email+" senha:"+senha);
			boolean existWithEmail = userExists(email);
			if(existWithEmail){
				this.result.use(Results.json()).from(UsuarioWrapper.create(new Usuario(), false)).serialize();
				return;
			}
			
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			SqlTool.getInstance().insert(usuario).execute();
			
			//TODO: REFATORAR E SEPARAR RESPONSABILIDADE
			usuario = SqlTool.getInstance().select(Usuario.class).where(attribute("nome").equals(nome).and("email").equals(email).and("senha").equals(senha)).execute(usuario).getUniqueResult();
			this.loginController.login(email, senha);
			this.result.use(Results.json()).from(UsuarioWrapper.create(usuario, true)).serialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean userExists(String email) throws Exception{
		Usuario usuario = new Usuario();
		usuario = SqlTool.getInstance().select(usuario.getClass()).where(attribute("email").equals(email)).execute(usuario).getUniqueResult();
		if(usuario!=null){
			return true;
		}
		
		return false;
	}
	
	public Usuario getUsuarioLogado() throws Exception{
		System.out.println("Executando getUsuarioLogado");
		String userName = (String) this.session.getAttribute("userName");
		System.out.println("userName: "+userName);
		if(userName == null){
			return null;
		}
		
		Usuario usuario = SqlTool.getInstance().select(Usuario.class).where(attribute("email").equals(userName)).execute(new Usuario()).getUniqueResult();
		System.out.println("Recuperando: "+usuario);
		return usuario;
	}
	
	public void associateGoogleUserWithSystemUser(User user) throws Exception{
		Usuario usuario = new Usuario();
		System.out.println("user: "+user);
		System.out.println("(user.getUserId(): "+user.getUserId());
		usuario = SqlTool.getInstance().select(usuario.getClass()).where(attribute("origem").equals("GOOGLE").and("id_origem").equals(user.getUserId())).execute(usuario).getUniqueResult();
		if(usuario!=null){
			return; 
		}
		
		usuario = new Usuario();
		usuario.setEmail(user.getEmail());
		usuario.setNome(user.getNickname());
		usuario.setOrigemNome("GOOGLE");
		usuario.setOrigemId(user.getUserId());
		
		try {
			SqlTool.getInstance().insert(usuario).execute();
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
