package com.bueno.controller;

import static com.fastsql.sql.command.expression.LogicalComparisonExpression.attribute;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.view.Results;

import com.bueno.component.usuario.model.Endereco;
import com.bueno.component.usuario.model.Usuario;
import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.command.expression.LogicalComparisonExpression;

@Resource
@RequestScoped
@Path("endereco")
public class EnderecoController implements Serializable{
	
	private static final long serialVersionUID = 6332085777433859681L;
	private final Result result;
	private final HttpServletRequest request;
	private final HttpSession session;
	
	
	
	public EnderecoController(Result result, HttpServletRequest request) {
		super();
		this.result = result;
		this.request = request;
		this.session = request.getSession();
	}

	@Path("list")
	public void getEnderecosByUsuario(){
		Endereco endereco = new Endereco();
		Usuario usuario = (Usuario) this.session.getAttribute("user");
		//if(usuario!=null){
			List<Endereco> enderecos = SqlTool.getInstance().select(Endereco.class).build(endereco).getResult();
			this.result.include("enderecos",enderecos);
			this.result.use(Results.json()).from(enderecos).serialize();
		//}
	}
	
	@Path("editar")
	public void editar(String idEndereco){
		Endereco obj = new Endereco();
		obj = SqlTool.getInstance().select(obj.getClass()).build(obj).getUniqueResult();
		this.result.include("endereco", obj);
	}
	
	@Path("salvar")
	public void salvarEndereco(String cep , String  tipoEndereco  , String  identificacao  , String  nome , String  sobrenome , String  endereco , String  complemento , String  bairro , String  cidade , String  estado , String  pais , String  telefone , String  referencia){
		try {
			Endereco obj = new Endereco();
			obj.setIdentificacao(identificacao);
			obj.setBairro(bairro);
			obj.setCep(cep);
			obj.setTipoEndereco(tipoEndereco);
			obj.setNome(nome);
			obj.setSobreNome(sobrenome);
			obj.setEndereco(endereco);
			obj.setComplemento(complemento);
			obj.setCidade(cidade);
			obj.setEstado(estado);
			obj.setPais(pais);
			obj.setTelefone(telefone);
			obj.setReferencia(referencia);
			
			System.out.println("salvarEndereco: "+obj);
			SqlTool.insert(obj).execute();
			
			
			Usuario usuario = (Usuario) this.session.getAttribute("user");
			if(usuario!=null){
				List<Endereco> enderecos = SqlTool.getInstance().select(Endereco.class).where(attribute("idUsuario").equals(usuario.getIdUsuario())).build(obj).getResult();
				this.result.include("enderecos",enderecos);
				this.result.use(Results.json()).from(enderecos).serialize();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
