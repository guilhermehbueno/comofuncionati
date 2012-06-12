package com.bueno.component.pedido.model;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.log4j.Logger;

import com.bueno.component.usuario.model.Usuario;
import com.bueno.controller.PedidoController;
import com.fastsql.sql.builder.SqlTool;
import static com.fastsql.sql.expression.LogicalComparisonExpression.*;

public class PedidoQueryStringExtract {
	
	private static final Logger log = Logger.getLogger(PedidoQueryStringExtract.class);
		
	String IKAI_TWITTER_RSS = "https://ws.pagseguro.uol.com.br/v2/checkout?email=guilhermehbueno@gmail.com&token=BCD18B1A0213471CB59937E013F064FF&currency=BRL&itemId1=0001&itemDescription1=Notebook Prata&itemAmount1=24300.00&itemQuantity1=1&itemWeight1=1000&reference=REF1234&shippingType=1&shippingAddressStreet=Av. Brig. Faria Lima&shippingAddressNumber=1384&shippingAddressComplement=5o andar&shippingAddressDistrict=Jardim Paulistano&shippingAddressPostalCode=01452002&shippingAddressCity=Sao Paulo&shippingAddressState=SP&shippingAddressCountry=BRA";
	
	public static String toQueryString(Pedido pedido) throws Exception{
		log.info("init");
		String produtoQueryString = toQueryString(pedido.getItens());
		String queryString = 
				attribute("email").equals("guilhermehbueno@gmail.com")
					.and("token").equals("BCD18B1A0213471CB59937E013F064FF")
					.and("currency").equals("BRL")
					.and(produtoQueryString)
					.and("reference").equals("REF1234")
					.and("shippingType").equals("1")
					.and("shippingAddressStreet").equals("Av. Brig. Faria Lima")
					.and("shippingAddressNumber").equals("1384")
					.and("shippingAddressComplement").equals("5o andar")
					.and("shippingAddressDistrict").equals("Jardim Paulistano")
					.and("shippingAddressPostalCode").equals("01452002")
					.and("shippingAddressCity").equals("Sao Paulo")
					.and("shippingAddressState").equals("SP")
					.and("shippingAddressCountry").equals("BRA").build();
		
		queryString = queryString
							.replaceAll("AND", "&")
							.replaceAll("'", "")
							.replaceAll(" = ", "=")
							.replaceAll(" & ", "&")
							.trim();
		log.info("end: "+queryString);
		return queryString;
	}
	
	private static String toQueryString(List<Item> itens){
		log.info("init");
		String itemId = "itemId";
		String itemDescription = "itemDescription";
		String itemAmount = "itemAmount";
		String itemQuantity = "itemQuantity";
		String itemWeight = "itemWeight";
		
		String query = "";
		for (int i = 0; i < itens.size(); i++) {
			Item item = itens.get(i);
			log.info("percorrendo item: "+item);
			int indiceAtual = i+1;
			Double preco = new Double(item.getPreco());
			query += 
					attribute(itemId+indiceAtual).equals(item.getIdItem())
						.and(itemDescription+indiceAtual).equals(item.getProduto().getNome())
						.and(itemAmount+indiceAtual).equals(converteMoeda(preco))
						.and(itemQuantity+indiceAtual).equals(item.getQuantidade())
						.and(itemWeight+indiceAtual).equals("1").and("")
						.build();
		}
		log.info("end: "+query);
		return query;
	}
	
	private static String converteMoeda(Double origem){
		log.info("init: "+origem);
		DecimalFormat formato = new DecimalFormat("##0.00");  
		String result = formato.format(origem).replace(",", ".");
		log.info("end: "+result);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(converteMoeda(new Double("35.0")));
	}

}
