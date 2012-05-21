<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<my:preferences-header />
<my:preferences-container>
	<div class="row span12">
		<div class="row">
			<ul class="breadcrumb">
				<li  class="active"><a href="#">Meu carrinho </a> <span class="divider">=></span></li>
				<li><a href="#">Identificação</a> <span class="divider">=></span></li>
				<li><a href="#">Endereço</a><span class="divider">=></span></li>
				<li><a href="#">Pagamento</a><span class="divider">=></span></li>
			</ul>
		</div>
		<div class="row">
			<div class="span12">
				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th>Descrição</th>
							<th>Quantidade</th>
							<th>Remover Item</th>
							<th>Preço unitário</th>
							<th>Preço total</th>
						</tr>
					</thead>
					<tr>
						<td><img src="http://placehold.it/100x100" alt=""></td>
						<td>
							<div style="height: 40px;"></div>
							<h4>${item.titulo} Nome do produto</h4>
						</td>
						<td>
							<div style="height: 40px;"></div> <input type="text"
							class="span1" style="height: 28px;" />
						</td>
						<td>
							<div style="height: 40px;"></div> <a href="#"
							class="btn btn-danger btn-mini"><i
								class="icon-white icon-remove"></i></a>
						</td>
						<td><div style="height: 40px;"></div>R$35,00</td>
						<td><div style="height: 40px;"></div>R$35,00</td>
					</tr>
					<tr>
						<td><img src="http://placehold.it/100x100" alt=""></td>
						<td>
							<div style="height: 40px;"></div>
							<h4>${item.titulo} Nome do produto</h4>
						</td>
						<td>
							<div style="height: 40px;"></div> <input type="text"
							class="span1" style="height: 28px;" />
						</td>
						<td>
							<div style="height: 40px;"></div> <a href="#"
							class="btn btn-danger btn-mini"><i
								class="icon-white icon-remove"></i></a>
						</td>
						<td><div style="height: 40px;"></div>R$35,00</td>
						<td><div style="height: 40px;"></div>R$35,00</td>
					</tr>
				</table>
				<hr class="soften">
			</div>
		</div>
		<div class="row">
			<div class="span6 offset4">
				<p>${item.conteudo} Lorem ipsum dolor sit amet, consectetur
					adipiscing elit. Vestibulum pharetra consectetur aliquet. Ut odio
					lectus, iaculis vitae ornare ac, rhoncus et velit. Quisque blandit
					blandit augue quis ultrices. Aliquam quis mi non ipsum fermentum
					vehicula eu at purus. In blandit auctor nulla id vestibulum.
					Integer ullamcorper, justo ut pretium sodales, diam sapien sagittis
					purus, nec dignissim augue nisi vitae ligula. Cras sit amet orci
					malesuada massa ultricies mattis.</p>
			</div>

			<div class="span2">
				<!-- submit do form (obrigatório) -->
				<a href="/pedido/confirmacao">
				<img class="thumbnail"
					src="http://placehold.it/250x150&text=COMPRAR >>"
					alt="Pague com PagSeguro">
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