<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<my:preferences-header />
<my:preferences-container>
	<div class="row">
	<div class="span6">
	<h2>Configuration of Pages</h2>
	</div>
	<div class="span4">
		<div class="btn-group">
			<a href="/pagina/create" class="btn btn-large"><i class="icon-plus"></i> Criar nova página</a>
		</div>
	</div>
	</div>
	<div class="row span10">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Resumed Title</th>
					<th>Content</th>
					<th>Type</th>
					<th>Status</th>
					<th>Parent</th>
					<th><div class="span2"></div></th>
				</tr>
			</thead>
			<c:forEach var="item" items="${itens}">
				<tr>
					<td><c:out value="${item.idPagina}" /></td>
					<td><c:out value="${item.titulo}" /></td>
					<td><c:out value="${item.tituloResumido}" /></td>
					<td><c:out value="${fn:substring(item.conteudoResumido, 0, 50)} (...)" /></td>
					<td><c:out value="${item.tipo}" /></td>
					<td><c:out value="${item.status}" /></td>
					<td><c:out value="${item.pai}" /></td>
						<td>
						<div class="btn-toolbar" style="margin-bottom: 9px">
							<div class="btn-group">
								<a class="btn btn-primary" href="#">
								Action</a> 
								<a style="height: 18px;" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
								<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="/pagina/${item.idPagina}/edit"><i class="icon-pencil"></i> Edit</a></li>
									<li><a href="/pagina/${item.idPagina}/delete"><i class="icon-trash"></i> Delete</a></li>
									<c:if test="${item.status eq 'ATIVO'}">
										<li><a href="/pagina/${item.idPagina}/status/inativo"><i class="icon-ban-circle"></i> Inactivate</a></li>
									</c:if>
									<c:if test="${item.status eq 'INATIVO'}">
										<li><a href="/pagina/${item.idPagina}/status/inativo"><i class="icon-ban-circle"></i> Activate</a></li>
									</c:if>
								</ul>
								</div>
						</div>
						</td>
					</tr>
				</c:forEach>
		</table>
	</div>
</my:preferences-container>
<my:preferences-footer />