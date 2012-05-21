<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %> 
<my:preferences-header />
<my:preferences-container>
	
<div class="marketing span12">
<div class="row-fluid">
<ul class="breadcrumb">
  <li>
    <a href="#">Home</a> <span class="divider">/</span>
  </li>
  <li>
    <a href="#">Produtos</a> <span class="divider">/</span>
  </li>
  <li class="active">
  	 <a href="#">Chinelo</a><span class="divider">/</span>
  </li>
</ul>
</div>
   <div class="row-fluid">
   	  <div class="span10 offset2">
	  <img src="http://placehold.it/1280x200" alt="">
	  </div>
   </div>
   
   <div class="row">
   <div class="span12">
      <img class="bs-icon" src="/stylesheets/assets/img/glyphicons/glyphicons_042_group.png">
      <h2>Novidades</h2>
    <p>
		O Como Funciona TI tem como objetivo auxiliar todos as pessoas que se interessam e estão ingressando no mundo de tecnologia da informação.
		Esta idéia surgiu da dificuldades de pessoas iniciantes que fui encontrando ao longo de alguns anos de trabalho.
		Na área de TI com toda a certeza você irá encontrar mais dúvidas do que certezas. É uma área instável, em constante transformação. O conteúdo que encontrará aqui é apenas uma micro-introdução de tudo o que irá encontrar em seu dia-a-dia.
	</p>
    </div>
   </div>

	<div class="row">
		<div class="page-header">
		  <h1>Chinelos</h1>
		</div>
		<br />
			<div class="span12">
				<ul class="thumbnails">
					<c:forEach var="produto" items="${produtos}">
						<li class="span3">
							<div class="thumbnail">
								<img src="http://placehold.it/260x180" alt="">
								<div class="caption">
									<h5>
										<c:out value="${produto.nome}" />
										<br />
									</h5>
									<p>
										<c:out value="${produto.descricaoResumida}" />
									</p>
									<p>
									<p>R$ ${produto.preco} </p>
									<p>
										<a href="/produto/${produto.idProduto}/view" class="btn btn-success"><i class="icon-white icon-shopping-cart"></i> Comprar</a>
									</p>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		</div>
</my:preferences-container>
<my:preferences-footer />