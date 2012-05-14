<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<my:preferences-header />
<my:preferences-container>
	<h2>Configuration of Menu</h2>
	<div class="row span12">
		<div class="row">
			<div class="span8">
				<form class="form-horizontal" action="/menu/save" method="post">
					<fieldset>
						<div class="control-group">
							<label class="control-label" for="input01">Name: </label>
							<div class="controls">
								<input type="text" name="menu.label" style="height: 28px;" class="input-xlarge" id="input01" value="${menuEdit.label}">
								<input type="hidden" name="menu.id" value="${menuEdit.id}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Link: </label>
							<div class="controls">
								<input type="text" name="menu.link" style="height: 28px;" class="input-xlarge" id="input01" value="${menuEdit.link}">
								<p class="help-block">Digite valores como: /cargo/gerente/view o resultado ao usu�rio clicar ser�: http://DOMINIO_DO_SISTEMA/cargo/gerente/view</p>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="select01">Status</label>
							<div class="controls">
								<select id="select01" name="menu.status">
									<c:choose>
										<c:when test="${menuEdit.status eq 'ATIVO'}">
											<option selected="selected">ATIVO</option>	
										</c:when>
										<c:otherwise>
											<option>ATIVO</option>	
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${menuEdit.status eq 'INATIVO'}">
											<option selected="selected">INATIVO</option>	
										</c:when>
										<c:otherwise>
											<option>INATIVO</option>	
										</c:otherwise>
									</c:choose>
								</select>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="select01">Type</label>
							<div class="controls">
								<select id="select01" name="menu.tipo">
									<c:choose>
										<c:when test="${menuEdit.tipo eq 'SUPERIOR'}">
											<option selected="selected">SUPERIOR</option>	
										</c:when>
										<c:otherwise>
											<option>SUPERIOR</option>	
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${menuEdit.tipo eq 'SUPERIOR_SUBMENU'}">
											<option selected="selected">SUPERIOR_SUBMENU</option>	
										</c:when>
										<c:otherwise>
											<option>SUPERIOR_SUBMENU</option>	
										</c:otherwise>
									</c:choose>
								</select>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="select01">Parent</label>
							<div class="controls">
								<select id="select01" name="menu.pai">
									<option selected="selected"></option>
								<c:forEach var="menu" items="${menusAll}">
									<c:choose>
											<c:when test="${menuEdit.pai eq menu.id}">
												<option selected="selected" value="${menu.id}"><c:out value="${menu.label}" /></option>	
											</c:when>
											<c:otherwise>
												<option value="${menu.id}"><c:out value="${menu.label}" /></option>	
											</c:otherwise>
									</c:choose>
								</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-actions">
							<button type="submit" class="btn btn-primary">
								Save changes
							</button>
							<button class="btn">
								Cancel
							</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</my:preferences-container>
<my:preferences-footer />