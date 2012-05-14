<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<my:preferences-header />
<my:preferences-container>
	<h2>Configuration of Page</h2>
	<div class="row span12">
		<div class="row">
			<div class="span12">
				<form class="form-horizontal" action="/pagina/save" method="post">
					<fieldset>
						<div class="control-group">
							<label class="control-label" for="input01">Title: </label>
							<div class="controls">
								<input type="text" name="t.titulo" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.titulo}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Resumed Title: </label>
							<div class="controls">
								<input type="text" name="t.tituloResumido" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.tituloResumido}">
							</div>
						</div>
						
							
						<div class="control-group">
							<label class="control-label" for="input01">Resumed Content: </label>
							<div class="controls">
								<textarea class="input-xlarge span8" rows="10" cols="200"  name="t.conteudoResumido"  id="input01" value="${item.conteudo}">
								</textarea>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Content: </label>
							<div class="controls">
								<textarea class="input-xlarge span8" rows="20" cols="200"  name="t.conteudo"  id="input01" value="${item.conteudo}">
								</textarea>
							</div>
						</div>
					
						
						
						<div class="control-group">
							<label class="control-label" for="select01">Status</label>
							<div class="controls">
								<select id="select01" name="t.status" class="span8">
									<c:choose>
										<c:when test="${item.status eq 'ATIVO'}">
											<option selected="selected">ATIVO</option>	
										</c:when>
										<c:otherwise>
											<option>ATIVO</option>	
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${item.status eq 'INATIVO'}">
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
								<select id="select01" name="t.tipo" class="span8">
									<c:choose>
										<c:when test="${item.tipo eq 'PRINCIPAL'}">
											<option selected="selected">PRINCIPAL</option>	
										</c:when>
										<c:otherwise>
											<option>PRINCIPAL</option>	
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${item.tipo eq 'SUBPAGINA'}">
											<option selected="selected">SUBPAGINA</option>	
										</c:when>
										<c:otherwise>
											<option>SUBPAGINA</option>	
										</c:otherwise>
									</c:choose>
								</select>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="select01">Parent</label>
							<div class="controls">
								<select id="select01" name="t.pai" class="span8">
									<option selected="selected"></option>
								<c:forEach var="itemParent" items="${itens}">
									<c:choose>
											<c:when test="${item.pai eq itemParent.id}">
												<option selected="selected" value="${itemParent.id}"><c:out value="${itemParent.label}" /></option>	
											</c:when>
											<c:otherwise>
												<option value="${itemParent.id}"><c:out value="${itemParent.label}" /></option>	
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