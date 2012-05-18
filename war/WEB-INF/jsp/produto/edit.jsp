<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<my:preferences-header />
<my:preferences-container>
	<h2>Configuration of Page</h2>
	<div class="row span12">
		<div class="row">
			<div class="span12">
				<form class="form-horizontal" action="/produto/update" method="post">
					<fieldset>
						<div class="control-group">
							<label class="control-label" for="input01">Name: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
								<input type="hidden" name="t.idProduto" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.idProduto}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Category: </label>
							<div class="controls">
								<input type="text" name="t.categoria" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.categoria}">
							</div>
						</div>
						
								
						<div class="control-group">
							<label class="control-label" for="input01">Price: </label>
							<div class="controls">
								<input type="text" name="t.preco" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.preco}">
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