<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<my:preferences-header />
<my:preferences-container>
		<div class="row">
			<div class="page-header" >
				  <h3>Endereço cadastrados</h3>
			</div>
			
			<div id="enderecoStatus" class="alert alert-success">
			  Best check yo self, you're not...
			</div>
		<div id="enderecos">
			<div><!-- NAO REMOVER ESTA DIV, E UTILIZADA PELO CARREGAMENTO DINAMICO DOS ENDERECOS, VER: javascript --></div>
		</div>
		</div>
		
		<div class="row">
			<div class="page-header">
				  <h3><a href="#" onclick="showFormEndereco()">Cadastrar novo endereço</a></h3>
			</div>
			
			<form id="formEndereco" class="form-horizontal"  method="post">
					<input type="hidden" id="idEndereco">
					<input type="hidden" id="idUsuario">
					<fieldset>
					<table class="table table-condensed">
					 	<tr>
					 		<td class="span2"><label class="control-label" for="input01">CEP: </label></td>
					 		<td><input id="cep" type="text" class="input-xlarge" ><a href="#" class="btn btn-primary"><i class="icon-white icon-refresh"></i> Processar</a></td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="span2"><label class="control-label" for="input01">Tipo de Endereço:</label></td>
					 		<td>
					 		<input id="tipoEndereco" type="text"  class="input-xlarge">
					 		</td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="span2">
					 			<label class="control-label" for="input01">Identifique o Endereço de Entrega: </label>
					 		</td>
					 		<td>
					 			<input  id="identificacao"  type="text" name="t.nome" class="input-xlarge">
					 		</td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="span2">
					 			<label class="control-label" for="input01">Nome: </label>
					 		</td>
					 		<td>
					 			<input id="nome"  type="text" class="input-xlarge">
					 		</td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="span2">
					 			<label class="control-label" for="input01">Sobrenome: </label>
					 		</td>
					 		<td>
					 			<input type="text" id="sobreNome"class="input-xlarge">
					 		</td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="span2">
					 			<label class="control-label" for="input01">Endereço: </label>
					 		</td>
					 		<td>
					 			<input type="text" id="endereco" class="input-xlarge">
					 		</td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="span2">
					 			<label class="control-label" for="input01">Complemento: </label>
					 		</td>
					 		<td>
					 			<input type="text" id="complemento" class="input-xlarge" >
					 		</td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="span2">
					 			<label class="control-label" for="input01">Bairro: </label>
					 		</td>
					 		<td>
					 			<input type="text"  id="bairro" class="input-xlarge" >
					 		</td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="span2">
					 			<label class="control-label" for="input01">Cidade: </label>
					 		</td>
					 		<td>
					 			<input type="text"  id="cidade"  style="height: 28px;" class="input-xlarge" >
					 		</td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="span2">
					 			<label class="control-label" for="input01">Estado: </label>
					 		</td>
					 		<td>
					 			<input type="text"  id="estado" class="input-xlarge" >
					 		</td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="span2">
					 			<label class="control-label" for="input01">País: </label>
					 		</td>
					 		<td>
					 			<input type="text"  id="pais" class="input-xlarge">
					 		</td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="span2">
					 			<label class="control-label" for="input01">Telefone: </label>
					 		</td>
					 		<td>
					 			<input type="text" id="telefone" class="input-xlarge">
					 		</td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="span2">
					 			<label class="control-label" for="input01">Referência para entrega: </label>
					 		</td>
					 		<td>
					 			<input type="text" id="referencia" class="input-xlarge" >
					 		</td>
					 	</tr>
					</table>
						
						<div class="form-actions">
							<button type="submit" class="btn btn-primary">
								Cadastrar
							</button>
						</div>
					</fieldset>
				</form>
		</div>
	<script type="text/javascript" charset="utf-8">
		jQuery(document).ready(
			function(){
				init();
				if(${userName eq null}){
					preparaExibicaoModalLoginCadastro();
				}else{
					loadEnderecosDoUsuario();
				}
		});
		
		function clean(){
			$('#idEndereco').val(null);
			$('#idUsuario').val(null);
			$('#cep').val(null);
			$('#tipoEndereco').val(null);
			$('#identificacao').val(null);
			$('#nome').val(null);
			$('#sobreNome').val(null);
			$('#endereco').val(null);
			$('#complemento').val(null);
			$('#bairro').val(null);
			$('#cidade').val(null);
			$('#estado').val(null);
			$('#pais').val(null);
			$('#telefone').val(null);
			$('#referencia').val(null);
		}
		
		function deleteEndereco(idEnderecoParam){
			var urlHostEnderecoForm ='${host}/endereco/remove';
			console.log("Url de remocao de endereço: "+urlHostEnderecoForm);
			console.log("idEndereco a ser removido: "+idEnderecoParam);
			jQuery.ajax({
		          url: urlHostEnderecoForm,
		          type: 'POST',
		          data:{
		        	  idEndereco: idEnderecoParam
		          },
		          dataType: 'json',
		          success: function(data) {
		        	$('#enderecoStatus').text(data.resultMessage.message);
		        	$('#enderecoStatus').fadeIn(1200);
		        	$('#enderecoStatus').fadeOut(1000);
		        	loadEnderecosDoUsuario();
		          }
			});
		}
		
		function edit(idEnderecoParam){
			clean();
			hideFormEndereco();
			var urlHostEnderecoForm ='${host}/endereco/editar';
			console.log("Url de edição de endereço: "+urlHostEnderecoForm);
			console.log("idEndereco a ser editado: "+idEnderecoParam);
			jQuery.ajax({
		          url: urlHostEnderecoForm,
		          type: 'POST',
		          data:{
		        	  idEndereco: idEnderecoParam
		          },
		          dataType: 'json',
		          success: function(data) {
		        	console.log("Retornado endereço: "+data.endereco.idEndereco);
					$('#idEndereco').val(data.endereco.idEndereco);
					$('#idUsuario').val(data.endereco.idUsuario);
		            $('#cep').val(data.endereco.cep);
		  			$('#tipoEndereco').val(data.endereco.tipoEndereco);
		  			$('#identificacao').val(data.endereco.identificacao);
		  			$('#nome').val(data.endereco.nome);
		  			$('#sobreNome').val(data.endereco.sobreNome);
		  			$('#endereco').val(data.endereco.endereco);
		  			$('#complemento').val(data.endereco.complemento);
		  			$('#bairro').val(data.endereco.bairro);
		  			$('#cidade').val(data.endereco.cidade);
		  			$('#estado').val(data.endereco.estado);
		  			$('#pais').val(data.endereco.pais);
		  			$('#telefone').val(data.endereco.telefone);
		  			$('#referencia').val(data.endereco.referencia);
		          }
			});
			
			showFormEndereco();
		}
		
		function init(){
			hideFormEndereco();
			$('#enderecoStatus').hide();
			$('#formEndereco input').css('height','28px');
			$('#formEndereco').submit(function(){
				$('#loader').show();
				var urlHostEnderecoForm ='${host}/endereco/salvar';
				jQuery.ajax({
			          url: urlHostEnderecoForm,
			          type: 'POST',
			          data:{
			        	  idEndereco: $('#idEndereco').val(),
			        	  idUsuario: $('#idUsuario').val(),
			        	  cep: $('#cep').val(), 
			        	  tipoEndereco: $('#tipoEndereco').val(), 
			        	  identificacao: $('#identificacao').val(),
			        	  nome: $('#nome').val(),
			        	  sobreNome: $('#sobreNome').val(),
			        	  endereco: $('#endereco').val(),
			        	  complemento: $('#complemento').val(),
			        	  bairro: $('#bairro').val(),
			        	  cidade: $('#cidade').val(),
			        	  estado: $('#estado').val(),
			        	  pais: $('#pais').val(),
			        	  telefone: $('#telefone').val(),
			        	  referencia: $('#referencia').val()
			          },
			          dataType: 'json',
			          success: function(data) {
			        	  loadEnderecosDoUsuario();
			        	  clean();
			        	  hideFormEndereco();
			          }
				});
				return false; 
			});
		}
		
		function preparaExibicaoModalLoginCadastro(){
			$('#closeLogin').hide();
			$('#closeLoginBtn').hide();
			$('#closeCadastro').hide();
			$('#closeCadastroBtn').hide();
			$('#logar').modal({
				  keyboard: false,
				  show: true,
				  backdrop:true
			});
			$('#cadastrar').modal({
				  keyboard: false,
				  show: false,
				  backdrop:true
			});
		}
		
		function showFormEndereco(){
			$('#formEndereco').show('slow');
		}
		
		function hideFormEndereco(){
			$('#formEndereco').hide('slow');
		}
		
		function loadEnderecosDoUsuario(){
			var urlHostEndereco ='${host}/endereco/list';
			jQuery.ajax({
		          url: urlHostEndereco,
		          type: 'GET',
		          dataType: 'json',
		          success: function(data) {
		        	  console.log('Removendo divs');
		        	  $('#enderecos').empty();
		        	  $.each(data.list, function(i,item)
		        			{
				        		var idEndereco = item.idEndereco;
				        		var tipoEndereco = item.tipoEndereco;
				        		var nome = item.nome;
				        		var sobreNome = item.sobreNome;
				        		var endereco = item.endereco;
				        		var complemento = item.complemento;
				        		var bairro = item.bairro;
				        		var cep = item.cep;
				        		var cidade = item.cidade;
				        		var estado = item.estado;
				        		var pais = item.pais;
		
				        		var conteudoEnderecos = null;
				        		
				        		var functionEndereco = "onclick=edit('"+idEndereco+"')";
				        		var functionRemoveEndereco = "onclick=deleteEndereco('"+idEndereco+"')";
				        		 
				        		conteudoEnderecos = "<div id='"+idEndereco+"'> <button class='close' "+functionRemoveEndereco+">×</button>"+
				        		"<i class='icon icon-home'></i> "+tipoEndereco+"<br/>"+
				        		nome+" <br/>"+
				        		endereco+" "+complemento+" "+bairro+"<br/>"+
				        		"CEP: "+cep+"  - "+cidade+" - "+estado+"  - "+pais+"<br/>"+
				        		"<button  class='btn btn-warning btn-mini' "+functionEndereco+"><i class='icon-white icon-pencil'></i> Editar</button>"+
								"<a href='/pedido/view' class='btn btn-success btn-mini'><i class='icon-white icon-ok'></i> Entregar neste endereço</a>"+
								"</div>";
								
								console.log('Endereco: '+conteudoEnderecos);
				        		$('#enderecos').append(conteudoEnderecos);
			        		  	$('#enderecos div').addClass('span3 alert alert-success').css('margin','10px');
			        	    }
		        	  );
		        	    console.log('Load was performed: '+data.list);
		          }
			});
		}
	</script>
</my:preferences-container>
<my:preferences-footer />