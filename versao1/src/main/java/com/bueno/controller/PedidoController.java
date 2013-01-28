package com.bueno.controller;

import static com.fastsql.sql.expression.LogicalComparisonExpression.id;

import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.SessionScoped;

import com.bueno.component.pedido.model.Item;
import com.bueno.component.pedido.model.Pedido;
import com.bueno.component.pedido.model.PedidoQueryStringExtract;
import com.bueno.component.pedido.model.PedidoStatusEnum;
import com.bueno.component.pedido.service.PedidoRepository;
import com.bueno.component.produto.model.Produto;
import com.bueno.component.produto.service.ProdutoRepository;
import com.fastsql.sql.builder.SqlTool;
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
	private static final Logger log = Logger.getLogger(PedidoController.class); 
	private final Result result;
	private UsuarioController controller;
	private PedidoRepository pedidoRepository;
	private ProdutoRepository produtoRepository;
	private final String id;

	public PedidoController(Result result,  UsuarioController controller, HttpServletRequest request, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
		super();
		this.id = UUID.randomUUID().toString();
		this.result = result;
		this.controller = controller;
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
	}

	@Path("view")
	public void visualizarPedido()  throws Exception{
		log.info("init");
		Pedido pedido = this.pedidoRepository.getOrCreateLastPedidoDoUsuarioBy(controller.getUsuarioLogado(), PedidoStatusEnum.CURRENT);
		log.info("Recuperando pedido: "+pedido);
		List<Produto> produtos = this.produtoRepository.getProdutosByItemsList(pedido.getItens());
		this.result.include("itensSelecionados", produtos);
		this.result.include("idPedido", pedido.getIdPedido());
		this.result.include("idUsuario", pedido.getIdUsuario());
		log.info("end");
	}
	
	@Path("finaliza")
	public void finalizaPedido(List<Item> itens)  throws Exception{
		log.info("init");
		log.info("Atualizando itens do pedido");
		for (Item item : itens) {
			log.info("Item: "+item);
			this.pedidoRepository.atualizaItemDoPedido(item);
		}
		this.result.redirectTo("confirmacao");
		log.info("end");
	}
	
	@Path("adiciona/{idProduto}")
	public void addProdutoAoCarrinho(String idProduto) throws Exception{
		log.info("init");
		Pedido pedido = this.pedidoRepository.getOrCreateLastPedidoDoUsuarioBy(controller.getUsuarioLogado(), PedidoStatusEnum.CURRENT);
		Produto produto = SqlTool.getInstance().select(Produto.class).where(id(Produto.class).equals(idProduto)).execute(new Produto()).getUniqueResult();
		if(produto!=null){
			pedido.addItem(Item.create(produto, 1));
		}else{
			throw new IllegalArgumentException("Não foi encontrado um produdo com o id: "+idProduto);
		}
		this.pedidoRepository.gravarPedido(pedido);
		this.result.redirectTo("/pedido/identificacao");
		log.info("end");
	}
	
	@Path("remove/{idProduto}")
	public void removeProdutoDoCarrinho(String idProduto) throws Exception{
		log.info("init");
		Pedido pedido = this.pedidoRepository.getOrCreateLastPedidoDoUsuarioBy(controller.getUsuarioLogado(), PedidoStatusEnum.CURRENT);
		List<Item> itens = pedido.getItens();
		log.info("itens do pedido: "+itens.size());
		log.info("idProduto: "+idProduto);
		Item itemDoProduto = null;
		for (Item item : itens) {
			log.info("item: "+item);
			if(item.getIdProduto().equalsIgnoreCase(idProduto)){
				itemDoProduto = item;
			}
		}
		log.info("remover: "+ itemDoProduto);
		pedido = this.pedidoRepository.removerItemDoPedido(itemDoProduto);
		this.result.redirectTo("/pedido/view");
		log.info("end");
	}
	
	@Path("identificacao")
	public void identificacao(){
		log.info("init");
		log.info("end");
	}
	
	/*
	 Pedido pedido = this.pedidoRepository.getOrCreateLastPedidoDoUsuarioBy(controller.getUsuarioLogado(), PedidoStatusEnum.CURRENT);
			pedido = this.pedidoRepository.encerrarPedido(pedido);
			String queryString = PedidoQueryStringExtract.toQueryString(pedido);
			log.info("QueryString: "+queryString);
			String CHECKOUT_CODE = "https://pagseguro.uol.com.br/v2/checkout/payment.html?code=";
			String IKAI_TWITTER_RSS = "https://ws.pagseguro.uol.com.br/v2/checkout?"+queryString;
			URLFetchService fetcher = URLFetchServiceFactory.getURLFetchService();
			URL url = new URL(IKAI_TWITTER_RSS.replaceAll(" ", ""));
			HTTPRequest request = new HTTPRequest(url, HTTPMethod.POST);
			HTTPResponse response = fetcher.fetch(request);
			log.info("Response: " + new String(response.getContent()));
			String code = extractCode(new String(response.getContent()));
			result.include("contentRetornado",	CHECKOUT_CODE+code);
			log.info("conteudo: "+CHECKOUT_CODE+code);
			this.result.redirectTo(CHECKOUT_CODE+code);
	 */
	
	
	@Path("confirmacao")
	public void confirmacao()  throws Exception{
		log.info("init");
		try{
			Pedido pedido = this.pedidoRepository.getOrCreateLastPedidoDoUsuarioBy(controller.getUsuarioLogado(), PedidoStatusEnum.CURRENT);
			pedido = this.pedidoRepository.encerrarPedido(pedido);
			String queryString = PedidoQueryStringExtract.toQueryString(pedido);
			log.info("QueryString: "+queryString);
			String CHECKOUT_CODE = "https://pagseguro.uol.com.br/v2/checkout/payment.html?code=";
			String IKAI_TWITTER_RSS = "https://ws.pagseguro.uol.com.br/v2/checkout?"+queryString;
			URLFetchService fetcher = URLFetchServiceFactory.getURLFetchService();
			URL url = new URL(IKAI_TWITTER_RSS.replaceAll(" ", ""));
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(queryString);
			wr.flush();
			HTTPRequest request = new HTTPRequest(url, HTTPMethod.POST);
			HTTPResponse response = fetcher.fetch(request);
			log.info("Response: " + new String(response.getContent()));
			String code = extractCode(new String(response.getContent()));
			result.include("contentRetornado",	CHECKOUT_CODE+code);
			log.info("conteudo: "+CHECKOUT_CODE+code);
			this.result.redirectTo(CHECKOUT_CODE+code);
		}catch (Exception e) {
			e.printStackTrace();
		}
		log.info("end");
	}
	
	private String extractCode(String response)  throws Exception{
		log.info("init");
		String result = response.replaceAll("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"yes\"?><checkout><code>", "");
		int indice = result.indexOf("</code>");
		result =  result.substring(0,indice);
		
		indice = result.indexOf("<code>");
		result = result.substring(indice);
		result = result.replaceAll("<code>", "");
		System.out.println("result extraido: "+result);
		log.info("end");
		return result;
	}

}
