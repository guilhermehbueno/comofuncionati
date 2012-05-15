package com.bueno.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Currency;
import br.com.uol.pagseguro.domain.PaymentRequest;
import br.com.uol.pagseguro.domain.ShippingType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;

@Resource
@Path("compra")
public class CompraController {
	
	private final Result result;
	
	public CompraController(Result result) {
		super();
		this.result = result;
	}

	@Path("comprar")
	public void comprar(){
		 // Instantiate a new payment request
        PaymentRequest paymentRequest = new PaymentRequest();

        // Sets the currency
        paymentRequest.setCurrency(Currency.BRL);

        // Add an item for this payment request
        paymentRequest.addItem("0001", "Notebook Prata", new Integer(1), new BigDecimal("2430.00"),
                new Long(1000), null);

        // Add another item for this payment request
        paymentRequest.addItem("0002", "Notebook Rosa", new Integer(2), new BigDecimal("2560.00"),
                new Long(750), null);
       
        // Sets a reference code for this payment request, it's useful to identify this payment in future notifications.
        paymentRequest.setReference("REF1234");

        // Sets shipping information for this payment request
        paymentRequest.setShippingType(ShippingType.SEDEX);
        paymentRequest.setShippingAddress("BRA", "SP", "São Paulo", "Jardim Paulistano", "01452002",
                "Av. Brig. Faria Lima", "1384", "5o andar");

        // Sets your customer information.
        paymentRequest.setSender("João Comprador", "comprador@uol.com.br", "11", "56273440");

        try {
            // Register this payment request in PagSeguro, to obtain the payment URL for redirect your customer.
            URL paymentURL = paymentRequest.register(new AccountCredentials("guilhermehbueno@gmail.com", "0B6026BC3D7D4963A6849BBB2C98C629"));
            System.out.println(paymentURL);
            this.result.redirectTo(paymentURL.toString());
        } catch (PagSeguroServiceException e) {
            System.err.println(e.toString());
        }
	}
	
}
