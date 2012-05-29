<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %> 
<my:preferences-header />
<my:preferences-container>
<div class="row span12">
<div class="row-fluid">
<ul class="breadcrumb">
  <li>
    <a href="#">Home</a> <span class="divider">/</span>
  </li>
  <li>
    <a href="#">Produtos</a> <span class="divider">/</span>
  </li>
  <li >
  	 <a href="#">${produto.categoria}</a><span class="divider">/</span>
  </li>
  <li class="active">
    ${produto.nome}
  </li>
</ul>
</div>
<div class="row-fluid">			
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
			<h1>${produto.nome}</h1>
		</div>
		<div>
			<p>
				${produto.descricao}
			</p>
			<p>
				<h3>R$ ${produto.preco}</h3>
			</p>
		</div>
		<hr class="soften">
	</div>
	
		<div class="page-header">
			<h1>Formas de Pagamento</h1>
		</div>
	<div class="row-fluid">
		<div class="span8">
			<p>
				O PagSeguro  da empresa UOL é atualmente uma das formas de pagamento mais seguros que existem no comércio eletrônico. Com ele você não precisa informar oo número de seu cartão de crédito diretamente à loja que você está comprando. 
Caso você tenha problema com a entrega do produto o mesmo permite a você bloquear o pagamento realizado em até 14 dias.
Além disto o PagSeguro oferece como forma de pagamento os príncipais MMMMMMMMM MMMMMMM MMMMMMM MMMMM MMMM.

 
			</p>
		</div>
		<div class="span4">
			<a href="/pedido/adiciona/${produto.idProduto}">
   			 <img  class="thumbnail" src="http://placehold.it/250x150&text=COMPRAR >>" alt="Pague com PagSeguro" />
    		</a>
		</div>
	</div>
</div>



</div>
			<div class="row-fluid">
				<div class="page-header">
				  <h2>Veja também</h2>
				</div>
			</div>
			<div class="row">
			
			<!-- TORNAR DINAMICO -->
			<div class="span3">
				<ul class="thumbnails">
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
						</li>
				</ul>
			</div>
			
			<div class="span3">
				<ul class="thumbnails">
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
					</li>
				</ul>
			</div>
			
			<div class="span3">
				<ul class="thumbnails">
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
					</li>
				</ul>
			</div>
			
			<div class="span3">
				<ul class="thumbnails">
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
					</li>
				</ul>
			</div>
			<!-- TORNAR DINAMICO -->
			
			
		</div>
	</div>
</my:preferences-container>
<my:preferences-footer />