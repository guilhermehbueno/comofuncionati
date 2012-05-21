package com.bueno.controller;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.bueno.component.produto.model.Pedido;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;

@Resource
@Path("pedido")
public class PedidoController implements Serializable{
	
	private static final long serialVersionUID = 4434308005983946310L;
	private final Result result;

	public PedidoController(Result result) {
		this.result = result;
	}
	
	@Path("{idProduto}/view")
	public void visualizarPedido(String idProduto){
		
	}
	
	@Path("finaliza")
	public void finalizaPedido(Pedido pedido){
		
	}
	
	@Path("identificacao")
	public void identificacao(){
		
	}
	
	@Path("confirmacao")
	public void confirmacao(){
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
	
	private String extractCode(String response){
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
