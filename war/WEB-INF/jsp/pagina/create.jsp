<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<my:preferences-header />
<my:preferences-container>

<!-- EDITOR -->
<link rel="stylesheet" type="text/css" href="http://jhollingworth.github.com/bootstrap-wysihtml5/src/bootstrap-wysihtml5.css"></link>

<style type="text/css" media="screen">
	.btn.jumbo {
		font-size: 20px;
		font-weight: normal;
		padding: 14px 24px;
		margin-right: 10px;
		-webkit-border-radius: 6px;
		-moz-border-radius: 6px;
		border-radius: 6px;
	}
</style>

<!-- EDITOR -->

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
								<a data-toggle="modal" href="#conteudoPagina">Conteudo</a>
							</div>
								<input type="hidden" id="conteudoPaginaInput" name="t.conteudo">
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
											<c:when test="${item.pai eq itemParent.idPagina}">
												<option selected="selected" value="${itemParent.idPagina}"><c:out value="${itemParent.titulo}" /></option>	
											</c:when>
											<c:otherwise>
												<option value="${itemParent.idPagina}"><c:out value="${itemParent.titulo}" /></option>	
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
	
	
	<!-- MODAL -->
    <div id="conteudoPagina" class="modal hide fade" style="width: 1024px; left: 30%; top: 40%;">
            <div class="modal-header">
              <button id="closeCadastro" class="close" data-dismiss="modal">&times;</button>
              <h3>Inscreva-se</h3>
            </div>
			<form id="formConteudoPagina" class="well form-inline" method="post">
            <div class="modal-body" style="max-height: 500px;">
			<br/>
				<div class="hero-unit" style="margin-top:40px">
					<textarea id="textareaConteudoPagina" placeholder="Enter text ..." style="width: 810px; height: 200px">${itemParent.conteudo}</textarea>
				</div>
            </div>
            <div class="modal-footer">
            	<div class="row">
            		<div class="span1">
		              <input type="button" id="btnOK" class="btn btn-success btn-large" value="OK"/>
            		</div>
            		<div class="span3">
            			<img id="loader" src="/stylesheets/assets/load.gif"></img>
            		</div>
            	</div>
            </div>
			</form>
	</div>
	<!-- MODAL -->
	
	
	
	
	<!-- EDITOR -->
	
<script src="http://jhollingworth.github.com/bootstrap-wysihtml5/lib/js/wysihtml5-0.3.0_rc3.js"></script>
<script src="http://jhollingworth.github.com/bootstrap-wysihtml5/lib/js/prettify.js"></script>
<script src="http://jhollingworth.github.com/bootstrap-wysihtml5/src/bootstrap-wysihtml5.js"></script>

<script>
	$('#textareaConteudoPagina').wysihtml5({
		"font-styles": true, //Font styling, e.g. h1, h2, etc. Default true
		"emphasis": true, //Italics, bold, etc. Default true
		"lists": true, //(Un)ordered lists, e.g. Bullets, Numbers. Default true
		"html": true, //Button which allows you to edit the generated HTML. Default false
		"link": true, //Button to insert a link. Default true
		"image": true //Button to insert an image. Default true
	});
</script>

<script type="text/javascript" charset="utf-8">
	$(prettyPrint);
</script>

<script type="text/javascript" charset="utf-8">
	jQuery(document).ready(function(){
		alert('Ready')
		$('#btnOK').click(
			function(){
				var texto = $('#textareaConteudoPagina').val();
				console.log('conteudo inserido: '+texto);
				$('#conteudoPaginaInput').val(texto);
				console.log('conteudo inserido: '+texto);
				$('#conteudoPagina').modal('hide');
				return false; 
			}
		);
	});
</script>
<!-- EDITOR -->
	
</my:preferences-container>
<my:preferences-footer />