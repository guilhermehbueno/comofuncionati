<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<my:preferences-header />
<my:preferences-container>
		<div class="row">
			<div class="page-header" >
				  <h3>Endereço cadastrados</h3>
			</div>
			
			<div class="span3">
				<i class="icon icon-home"></i> Residencial<br/>
				Guilherme  Bueno<br/>
				Roberto Simonsen  278 apto 43 JD. Bela Vista<br/>
				CEP: 13076416  - CAMPINAS - SP  - BR
				<a href="#" class="btn btn-warning btn-mini"><i class="icon-white icon-pencil"></i> Editar</a>
				<a href="/pedido/1/view" class="btn btn-success btn-mini"><i class="icon-white icon-ok"></i> Entregar neste endereço</a>
			</div>
			
			<div class="span3">
				<i class="icon icon-home"></i> Residencial<br/>
				Guilherme  Bueno<br/>
				Roberto Simonsen  278 apto 43 JD. Bela Vista<br/>
				CEP: 13076416  - CAMPINAS - SP  - BR
				<a href="#" class="btn btn-warning btn-mini"><i class="icon-white icon-pencil"></i> Editar</a>
				<a href="/pedido/1/view" class="btn btn-success btn-mini"><i class="icon-white icon-ok"></i> Entregar neste endereço</a>
			</div>
			
			<div class="span3">
				<i class="icon icon-home"></i> Residencial<br/>
				Guilherme  Bueno<br/>
				Roberto Simonsen  278 apto 43 JD. Bela Vista<br/>
				CEP: 13076416  - CAMPINAS - SP  - BR
				<a href="#" class="btn btn-warning btn-mini"><i class="icon-white icon-pencil"></i> Editar</a>
				<a href="/pedido/1/view" class="btn btn-success btn-mini"><i class="icon-white icon-ok"></i> Entregar neste endereço</a>
			</div>
		</div>
		
		<div class="row">
			<div class="page-header">
				  <h3>Cadastrar novo endereço</h3>
			</div>
			
			<form class="form-horizontal" action="/produto/save" method="post">
					<fieldset>
						<div class="control-group">
							<label class="control-label" for="input01">CEP: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Tipo de Endereço: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Identifique o Endereço de Entrega: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Nome: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Sobrenome: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Endereço: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Complemento: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Bairro: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Cidade: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Estado: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">País: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Telefone: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Referência para entrega: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="input01">Endereço de e-mail para entrega: </label>
							<div class="controls">
								<input type="text" name="t.nome" style="height: 28px;" class="input-xlarge span8" id="input01" value="${item.nome}">
							</div>
						</div>
						
						
						
						<div class="form-actions">
							<button type="submit" class="btn btn-primary">
								Cadastrar
							</button>
						</div>
					</fieldset>
				</form>
		</div>
</my:preferences-container>
<my:preferences-footer />