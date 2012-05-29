package com.bueno.controller;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.caelum.vraptor.view.Results;

import com.bueno.component.produto.model.Pedido;
import com.bueno.component.produto.model.Produto;
import com.bueno.component.usuario.model.Endereco;
import com.bueno.component.usuario.model.Usuario;
import com.fastsql.sql.builder.SqlTool;
import static com.fastsql.sql.command.expression.LogicalComparisonExpression.*;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;

@Resource
@SessionScoped
@Path("pedido")
public class PedidoController implements Serializable{
	
	private static final long serialVersionUID = 4434308005983946310L;
	private final Result result;
	private List<Produto> produtosAdicionados;
	private Pedido pedido;

	public PedidoController(Result result) {
		super();
		this.result = result;
		this.produtosAdicionados = new ArrayList<Produto>();
	}

	@Path("view")
	public void visualizarPedido()  throws Exception{
		for (Produto produto : this.produtosAdicionados) {
			System.out.println(produto.getIdProduto()+" - "+produto.getNome());
		}
		this.result.include("produtosSelecionados", this.produtosAdicionados);
	}
	
	@Path("finaliza")
	public void finalizaPedido(Pedido pedido)  throws Exception{
		
	}
	
	@Path("adiciona/{idProduto}")
	public void addProdutoAoCarrinho(String idProduto) throws Exception{
		Produto produto = SqlTool.getInstance().select(Produto.class).where(id(Produto.class).equals(idProduto)).execute(new Produto()).getUniqueResult();
		if(produto!=null){
			this.produtosAdicionados.add(produto);
		}
		this.result.redirectTo("/pedido/identificacao");
	}
	
	@Path("identificacao")
	public void identificacao(){
	}
	
	@Path("confirmacao")
	public void confirmacao()  throws Exception{
		try{
			String CHECKOUT_CODE = "https://pagseguro.uol.com.br/v2/checkout/payment.html?code=";
			String IKAI_TWITTER_RSS = "https://ws.pagseguro.uol.com.br/v2/checkout?email=guilhermehbueno@gmail.com&token=BCD18B1A0213471CB59937E013F064FF&currency=BRL&itemId1=0001&itemDescription1=Notebook Prata&itemAmount1=24300.00&itemQuantity1=1&itemWeight1=1000&reference=REF1234&shippingType=1&shippingAddressStreet=Av. Brig. Faria Lima&shippingAddressNumber=1384&shippingAddressComplement=5o andar&shippingAddressDistrict=Jardim Paulistano&shippingAddressPostalCode=01452002&shippingAddressCity=Sao Paulo&shippingAddressState=SP&shippingAddressCountry=BRA";
			URLFetchService fetcher = URLFetchServiceFactory.getURLFetchService();
			URL url = new URL(IKAI_TWITTER_RSS.replaceAll(" ", ""));
			HTTPRequest request = new HTTPRequest(url, HTTPMethod.POST);
			HTTPResponse response = fetcher.fetch(request);
			System.out.println("Response: " + new String(response.getContent()));
			String code = extractCode(new String(response.getContent()));
			result.include("contentRetornado",	CHECKOUT_CODE+code);
			System.out.println("conteudo: "+CHECKOUT_CODE+code);
			this.result.redirectTo(CHECKOUT_CODE+code);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String extractCode(String response)  throws Exception{
		String result = response.replaceAll("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"yes\"?><checkout><code>", "");
		int indice = result.indexOf("</code>");
		result =  result.substring(0,indice);
		
		indice = result.indexOf("<code>");
		result = result.substring(indice);
		result = result.replaceAll("<code>", "");
		System.out.println("result extraido: "+result);
		return result;
	}

}
