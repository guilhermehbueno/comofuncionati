<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<my:preferences-header />
<my:preferences-container>
	<div class="row">
	<div class="span6">
	<h2>Configuration of Pages</h2>
	</div>
	<div class="span4">
		<div class="btn-group">
			<a href="/produto/create" class="btn btn-large"><i class="icon-plus"></i> Criar novo Produto</a>
		</div>
	</div>
	</div>
	<div class="row span10">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Category</th>
					<th>Description</th>
					<th>Preco</th>
					<th>Status</th>
					<th>
						<div class="span2"></div>
					</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${itens}">
				<tr>
					<td><c:out value="${item.idProduto}" /></td>
					<td><c:out value="${item.nome}" /></td>
					<td><c:out value="${item.categoria}" /></td>
					<td><c:out value="${item.descricao}" /></td>
					<td><c:out value="${item.preco}" /></td>
					<td><c:out value="${item.status}" /></td>
						<td>
						<div class="btn-toolbar" style="margin-bottom: 9px">
							<div class="btn-group">
								<a class="btn btn-primary" href="#">
								Action</a> 
								<a style="height: 18px;" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
								<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="/produto/${item.idProduto}/edit"><i class="icon-pencil"></i> Edit</a></li>
									<li><a href="/produto/${item.idProduto}/delete"><i class="icon-trash"></i> Delete</a></li>
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