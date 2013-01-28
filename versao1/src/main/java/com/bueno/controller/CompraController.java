package com.bueno.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Currency;
import br.com.uol.pagseguro.domain.PaymentRequest;
import br.com.uol.pagseguro.domain.ShippingType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;

import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;

@Resource
@Path("compra")
public class CompraController implements Serializable{

	private final Logger logger = LoggerFactory
			.getLogger(CompraController.class);
	private final Result result;

	public CompraController(Result result) {
		super();
		this.result = result;
	}

	@Path("teste1")
	public void teste1() {
		try {
			String message = URLEncoder.encode("my message", "UTF-8");
			URL url = new URL(
					"https://ws.pagseguro.uol.com.br/v2/checkout?email=guilhermehbueno@gmail.com&token=B703995C5D7C4B4DABA47B62C6387635");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write("message=" + message);
			writer.close();

			System.out.println(connection.getURL());

			URLFetchService service = URLFetchServiceFactory
					.getURLFetchService();
			HTTPResponse response = service.fetch(connection.getURL());
			System.out.println("Final: " + response.getFinalUrl());
			System.out.println("Response: " + response);
			System.out.println("Content: " + response.getContent());

			URL ur2l = new URL("http://www.google.com");
			URLFetchService urlFetchService = URLFetchServiceFactory
					.getURLFetchService();
			HTTPRequest httpRequest = new HTTPRequest(ur2l, HTTPMethod.GET);
			HTTPResponse resp = urlFetchService.fetch(httpRequest);
			System.out.println("resp:" + resp.toString());
			result.include("Final: " + resp.getFinalUrl());
			result.include("Final: " + response.getFinalUrl());
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				System.out.println(connection.getResponseCode());
			} else {
				System.out.println(connection.getResponseCode());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Path("teste")
	public void teste() throws Exception {
		// URL url = new
		// URL("https://ws.pagseguro.uol.com.br/v2/checkout?email=guilhermehbueno@gmail.com&token=B703995C5D7C4B4DABA47B62C6387635");
		URLFetchService fetcher = URLFetchServiceFactory.getURLFetchService();
		try {
			URL url = new URL(
					"https://ws.pagseguro.uol.com.br/v2/checkout?email=guilhermehbueno@gmail.com&token=B703995C5D7C4B4DABA47B62C6387635");
			HTTPResponse response = fetcher.fetch(url);

			byte[] content = response.getContent();
			URL finalUrl = response.getFinalUrl();
			int responseCode = response.getResponseCode();
			System.out.println("responseCode: " + responseCode);
			List<HTTPHeader> headers = response.getHeaders();
			System.out.println("finalUrl: " + finalUrl);
			for (HTTPHeader header : headers) {
				String headerName = header.getName();
				String headerValue = header.getValue();
				System.out.println("headerName:" + headerName);
				System.out.println("headerValue:" + headerValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Path("twitter")
	public void twitter() throws Exception {
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
	
	@Path("comprar")
	public void comprar() {
		logger.info("Executando comprar");
		// Instantiate a new payment request
		PaymentRequest paymentRequest = new PaymentRequest();
		// Sets the currency
		paymentRequest.setCurrency(Currency.BRL);
		// Add an item for this payment request
		paymentRequest.addItem("0001", "Notebook Prata", new Integer(1),
				new BigDecimal("24.00"), new Long(1000), null);
		// Add another item for this payment request
		paymentRequest.addItem("0002", "Notebook Rosa", new Integer(2),
				new BigDecimal("25.00"), new Long(750), null);
		// Sets a reference code for this payment request, it's useful to
		// identify this payment in future notifications.
		paymentRequest.setReference("REF1234");

		// Sets shipping information for this payment request
		paymentRequest.setShippingType(ShippingType.SEDEX);
		paymentRequest.setShippingAddress("BRA", "SP", "São Paulo",
				"Jardim Paulistano", "01452002", "Av. Brig. Faria Lima",
				"1384", "5o andar");

		// Sets your customer information.
		paymentRequest.setSender("João Comprador", "comprador@uol.com.br",
				"11", "56273440");

		try {
			// Register this payment request in PagSeguro, to obtain the payment
			// URL for redirect your customer.
			URL paymentURL = paymentRequest.register(new AccountCredentials(
					"guilhermehbueno@gmail.com",
					"5EB47B114078477BA761698C47A2C892"));
			logger.info("URL retornada: " + paymentURL);
			this.result.redirectTo(paymentURL.toString());
		} catch (PagSeguroServiceException e) {
			System.err.println(e.toString());
		}
	}

}
