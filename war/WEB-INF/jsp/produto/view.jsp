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
<div  style="padding-top: 200px;"></div>
		<a href="#" class="thumbnail">
            <img src="http://placehold.it/250x150&text=COMPRAR >>" alt="">
        </a>
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