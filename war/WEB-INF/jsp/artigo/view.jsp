<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<my:preferences-header />
<my:preferences-container>
	<div class="row-fluid">
			<div class="row">
				<div class=" span4">
					<img src="http://placehold.it/370x298" alt="">
				</div>
	
				<div class="span8">
					<div class="page-header">
						<h1>${item.titulo}</h1>
					</div>
					
					<br />
					<div>
						<p>
						<c:out value="${item.conteudo}" escapeXml="false"/>
						 </p>
					</div>
	
					<div class="row"> 
					<c:if test="${paginacao ne null}">
						<ul class="pager">
							<li><a href="/artigo/${paginacaoPrev.identificador}/view/page/${paginacaoPrev.label}">Prev</a></li>
							<c:forEach var="paginacao" items="${paginacao}">
								<li class="${paginacao.estado}"><a href="/artigo/${paginacao.identificador}/view/page/${paginacao.label}">${paginacao.label}</a></li>
							</c:forEach>
							<li><a href="/artigo/${paginacaoNext.identificador}/view/page/${paginacaoNext.label}">Next</a></li>
						</ul>
					</c:if>
					</div>
				</div>
			</div>
	</div>
		
	<div class="row-fluid">
		<div class="page-header">
		  <h2>Veja também</h2>
		</div>
			
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
</my:preferences-container>
<my:preferences-footer />