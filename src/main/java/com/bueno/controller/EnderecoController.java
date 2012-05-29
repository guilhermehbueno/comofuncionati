package com.bueno.controller;

import static com.fastsql.sql.command.expression.LogicalComparisonExpression.attribute;
import static com.fastsql.sql.command.expression.LogicalComparisonExpression.id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.view.Results;

import com.bueno.component.json.result.ResultMessage;
import com.bueno.component.usuario.model.Endereco;
import com.bueno.component.usuario.model.Usuario;
import com.fastsql.sql.builder.SqlTool;

@Resource
@RequestScoped
@Path("endereco")
public class EnderecoController implements Serializable{
	
	private static final long serialVersionUID = 6332085777433859681L;
	private final Result result;
	private final HttpServletRequest request;
	private final HttpSession session;
	private final UsuarioController usuarioController;
	
	public EnderecoController(Result result, HttpServletRequest request,  UsuarioController usuarioController) {
		super();
		this.result = result;
		this.request = request;
		this.session = request.getSession();
		this.usuarioController = usuarioController;
	}

	@Path("list")
	public void getEnderecosByUsuario() throws Exception{
		Endereco endereco = new Endereco();
		Usuario usuario =  this.usuarioController.getUsuarioLogado();
		if(usuario!=null){
			List<Endereco> enderecos = SqlTool.getInstance().select(Endereco.class).where(attribute("idUsuario").equals(usuario.getIdUsuario())).execute(endereco).getResult();
			this.result.include("enderecos",enderecos);
			this.result.use(Results.json()).from(enderecos).serialize();
		}else{
			this.result.use(Results.json()).from(new ArrayList<Endereco>()).serialize();
		}
	}
	
	@Path("editar")
	public void editar(String idEndereco) throws Exception{
		Endereco obj = new Endereco();
		obj = SqlTool.getInstance().select(obj.getClass()).where(id(Endereco.class).equals(idEndereco)).execute(obj).getUniqueResult();
		this.result.use(Results.json()).from(obj).serialize();
	}
	
	@Path("remove")
	public void remover(String idEndereco){
		try {
			SqlTool.getInstance().delete(new Endereco()).where(id(Endereco.class).equals(idEndereco)).execute();
			this.result.use(Results.json()).from(new ResultMessage("INFO", "Endereço removido com sucesso")).serialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Path("salvar")
	public void salvarEndereco(String idEndereco, String idUsuario, String cep , String  tipoEndereco  , String  identificacao  , String  nome , String  sobrenome , String  endereco , String  complemento , String  bairro , String  cidade , String  estado , String  pais , String  telefone , String  referencia){
		try {
			System.out.println("salvarEndereco id: "+idEndereco);
			Usuario usuarioLogado = this.usuarioController.getUsuarioLogado();
			Endereco obj = new Endereco();
			obj.setIdUsuario(idUsuario);
			obj.setIdUsuario(usuarioLogado.getIdUsuario());
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
			if(StringUtils.isEmpty(idEndereco)){
				SqlTool.getInstance().insert(obj).execute();
			}else{
				obj.setIdEndereco(idEndereco);
				SqlTool.update(obj).where(id(Endereco.class).equals(idEndereco)).execute();
			}
			
			Usuario usuario = (Usuario) this.usuarioController.getUsuarioLogado();
			if(usuario!=null){
				List<Endereco> enderecos = SqlTool.getInstance().select(Endereco.class).where(attribute("idUsuario").equals(usuario.getIdUsuario())).execute(obj).getResult();
				this.result.use(Results.json()).from(enderecos).serialize();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
