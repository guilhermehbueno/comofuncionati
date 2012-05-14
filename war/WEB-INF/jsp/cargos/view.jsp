<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %> 
<my:preferences-header />
<my:preferences-container>
	<div class="row span12">
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
					<p>${item.conteudo}</p>
				</div>

				<div class="row">
					<ul class="pager">
						<li><a href="#">Prev</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
		<hr class="soften">
		
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