<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %> 
<my:preferences-header />
<my:preferences-container>
<div class="row span12">
<div class="row">
<ul class="breadcrumb">
  <li>
    <a href="#">Home</a> <span class="divider">/</span>
  </li>
  <li>
    <a href="#">Produtos</a> <span class="divider">/</span>
  </li>
  <li >
  	 <a href="#">Chinelo</a><span class="divider">/</span>
  </li>
  <li class="active">
    Chinelo Azul 
  </li>
</ul>
</div>
<div class="row">			
<div class="span3">
      <ul class="thumbnails">
        <li class="span3">
          <a href="#" class="thumbnail">
            <img src="http://placehold.it/280x280" alt="">
          </a>
        </li>
        <li class="span1">
          <a href="#" class="thumbnail">
            <img src="http://placehold.it/60x60" alt="">
          </a>
        </li>
        <li class="span1">
          <a href="#" class="thumbnail">
            <img src="http://placehold.it/60x60" alt="">
          </a>
        </li>
        <li class="span1">
          <a href="#" class="thumbnail">
            <img src="http://placehold.it/60x60" alt="">
          </a>
        </li>
        <li class="span1">
          <a href="#" class="thumbnail">
            <img src="http://placehold.it/60x60" alt="">
          </a>
        </li>
        <li class="span1">
          <a href="#" class="thumbnail">
            <img src="http://placehold.it/60x60" alt="">
          </a>
        </li>
        <li class="span1">
          <a href="#" class="thumbnail">
            <img src="http://placehold.it/60x60" alt="">
          </a>
        </li>
      </ul>
</div>
<div class="span7">
	<div>
		<div class="page-header">
			<h1>${item.titulo} Nome do produto</h1>
		</div>
		<div>
			<p>${item.conteudo} Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum pharetra consectetur aliquet. Ut odio lectus, iaculis vitae ornare ac, rhoncus et velit. Quisque blandit blandit augue quis ultrices. Aliquam quis mi non ipsum fermentum vehicula eu at purus. In blandit auctor nulla id vestibulum. Integer ullamcorper, justo ut pretium sodales, diam sapien sagittis purus, nec dignissim augue nisi vitae ligula. Cras sit amet orci malesuada massa ultricies mattis.</p>
		</div>
		<hr class="soften">
	</div>
	
	<div>
		<div class="page-header">
			<h1>${item.titulo} Formas de Pagamento</h1>
		</div>
		<div>
			<p>${item.conteudo} Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum pharetra consectetur aliquet. Ut odio lectus, iaculis vitae ornare ac, rhoncus et velit. Quisque blandit blandit augue quis ultrices. Aliquam quis mi non ipsum fermentum vehicula eu at purus. In blandit auctor nulla id vestibulum. Integer ullamcorper, justo ut pretium sodales, diam sapien sagittis purus, nec dignissim augue nisi vitae ligula. Cras sit amet orci malesuada massa ultricies mattis.</p>
		</div>
		<hr class="soften">
	</div>
</div>
<div class="span2">
<div  style="padding-top: 200px;">
</div>

<!-- FORM DE PEDIDO -->
<!-- Declaração do formulário -->  
<form target="_parent" method="post"   action="https://pagseguro.uol.com.br/v2/checkout/payment.html">  
      
    <!-- Campos obrigatórios -->  
    <input type="hidden" name="receiverEmail" value="suporte@lojamodelo.com.br">  
    <input type="hidden" name="currency" value="BRL">  
      
    <!-- Itens do pagamento (ao menos um item é obrigatório) -->  
    <input type="hidden" name="itemId1" value="0001">  
    <input type="hidden" name="itemDescription1" value="Notebook Prata">  
    <input type="hidden" name="itemAmount1" value="24300.00">  
    <input type="hidden" name="itemQuantity1" value="1">  
    <input type="hidden" name="itemWeight1" value="1000">  
      
    <input type="hidden" name="itemId2" value="0002">  
    <input type="hidden" name="itemDescription2" value="Notebook Rosa">  
    <input type="hidden" name="itemAmount2" value="25600.00">  
    <input type="hidden" name="itemQuantity2" value="2">  
    <input type="hidden" name="itemWeight2" value="750">  
      
    <!-- Código de referência do pagamento no seu sistema (opcional) -->  
    <input type="hidden" name="reference" value="REF1234">  
      
    <!-- Informações de frete (opcionais) -->  
    <input type="hidden" name="shippingType" value="1">  
    <input type="hidden" name="shippingAddressPostalCode" value="01452002">  
    <input type="hidden" name="shippingAddressStreet" value="Av. Brig. Faria Lima">  
    <input type="hidden" name="shippingAddressNumber" value="1384">  
    <input type="hidden" name="shippingAddressComplement" value="5o andar">  
    <input type="hidden" name="shippingAddressDistrict" value="Jardim Paulistano">  
    <input type="hidden" name="shippingAddressCity" value="Sao Paulo">  
    <input type="hidden" name="shippingAddressState" value="SP">  
    <input type="hidden" name="shippingAddressCountry" value="BRA">  
      
    <!-- Dados do comprador (opcionais) -->  
    <input type="hidden" name="senderName" value="José Comprador">  
    <input type="hidden" name="senderAreaCode" value="11">  
    <input type="hidden" name="senderPhone" value="56273440">  
    <input type="hidden" name="senderEmail" value="comprador@uol.com.br">  
      
    <!-- submit do form (obrigatório) -->  
    <input type="image" class="thumbnail" name="submit" src="http://placehold.it/250x150&text=COMPRAR >>" alt="Pague com PagSeguro">  
      
</form>  

<!-- FORM DE PEDIDO -->
</div>


</div>
		
		
		<div class="row">
			<div class="page-header">
			  <h2>Veja também</h2>
			</div>
			
			<!-- TORNAR DINAMICO -->
			<div class="span3">
				<ul class="thumbnails">
					<c:forEach var="submenu" items="${menu.menu}">
						<li class="span3">
							<div class="thumbnail">
								<img src="http://placehold.it/260x180" alt="">
								<div class="caption">
									<h5>
										<c:out value="${submenu.label}" />
										<br />
									</h5>
									<p>Cras justo odio, dapibus ac facilisis in, egestas eget
										quam. Donec id elit non mi porta gravida at eget metus. Nullam
										id dolor id nibh ultricies vehicula ut id elit.</p>
									<p>
										<a href="#" class="btn btn-primary">Saiba Mais...</a>
									</p>
								</div>
							</div>
					</c:forEach>
					</li>
				</ul>
			</div>
			
			<div class="span3">
				<ul class="thumbnails">
					<c:forEach var="submenu" items="${menu.menu}">
						<li class="span3">
							<div class="thumbnail">
								<img src="http://placehold.it/260x180" alt="">
								<div class="caption">
									<h5>
										<c:out value="${submenu.label}" />
										<br />
									</h5>
									<p>Cras justo odio, dapibus ac facilisis in, egestas eget
										quam. Donec id elit non mi porta gravida at eget metus. Nullam
										id dolor id nibh ultricies vehicula ut id elit.</p>
									<p>
										<a href="#" class="btn btn-primary">Saiba Mais...</a>
									</p>
								</div>
							</div>
					</c:forEach>
					</li>
				</ul>
			</div>
			
			<div class="span3">
				<ul class="thumbnails">
					<c:forEach var="submenu" items="${menu.menu}">
						<li class="span3">
							<div class="thumbnail">
								<img src="http://placehold.it/260x180" alt="">
								<div class="caption">
									<h5>
										<c:out value="${submenu.label}" />
										<br />
									</h5>
									<p>Cras justo odio, dapibus ac facilisis in, egestas eget
										quam. Donec id elit non mi porta gravida at eget metus. Nullam
										id dolor id nibh ultricies vehicula ut id elit.</p>
									<p>
										<a href="#" class="btn btn-primary">Saiba Mais...</a>
									</p>
								</div>
							</div>
					</c:forEach>
					</li>
				</ul>
			</div>
			
			<div class="span3">
				<ul class="thumbnails">
					<c:forEach var="submenu" items="${menu.menu}">
						<li class="span3">
							<div class="thumbnail">
								<img src="http://placehold.it/260x180" alt="">
								<div class="caption">
									<h5>
										<c:out value="${submenu.label}" />
										<br />
									</h5>
									<p>Cras justo odio, dapibus ac facilisis in, egestas eget
										quam. Donec id elit non mi porta gravida at eget metus. Nullam
										id dolor id nibh ultricies vehicula ut id elit.</p>
									<p>
										<a href="#" class="btn btn-primary">Saiba Mais...</a>
									</p>
								</div>
							</div>
					</c:forEach>
					</li>
				</ul>
			</div>
			<!-- TORNAR DINAMICO -->
			
			
		</div>
	</div>
</my:preferences-container>
<my:preferences-footer />