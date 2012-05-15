<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<my:preferences-header />
<my:preferences-container>
	<div class="row">
	<div class="span6">
	<h2>Configuration of Menus</h2>
	</div>
	<div class="span4">
		<div class="btn-group">
			<a href="/menu/create" class="btn btn-large"><i class="icon-plus"></i> Criar novo menu</a>
		</div>
	</div>
	</div>
	
	
	
	<div class="row span10">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Link</th>
					<th>Status</th>
					<th>Type</th>
					<th>Parent</th>
					<th><div class="span2"></div></th>
				</tr>
			</thead>
			<c:forEach var="menu" items="${menusAll}">
				<tr>
					<td><c:out value="${menu.id}" /></td>
					<td><c:out value="${menu.label}" /></td>
					<td><c:out value="${menu.link}" /></td>
					<td><c:out value="${menu.status}" /></td>
					<td><c:out value="${menu.tipo}" /></td>
					<td><c:out value="${menu.pai}" /></td>
						<td>
						<div class="btn-toolbar" style="margin-bottom: 9px">
							<div class="btn-group">
								<a class="btn btn-primary" href="#">
								Action</a> 
								<a style="height: 18px;" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
								<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="/menu/${menu.id}/edit"><i class="icon-pencil"></i> Edit</a></li>
									<li><a href="/menu/${menu.id}/delete"><i class="icon-trash"></i> Delete</a></li>
									<c:if test="${menu.status eq 'ATIVO'}">
										<li><a href="/menu/${menu.id}/status/inativo"><i class="icon-ban-circle"></i> Inactivate</a></li>
									</c:if>
									<c:if test="${menu.status eq 'INATIVO'}">
										<li><a href="/menu/${menu.id}/status/inativo"><i class="icon-ban-circle"></i> Activate</a></li>
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