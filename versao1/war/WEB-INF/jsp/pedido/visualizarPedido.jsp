<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<form id="formItens" class="form-horizontal" method="post"  action="/pedido/finaliza">
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
						
						<c:forEach var="item" items="${itensSelecionados}" varStatus="s">
							<tr>
								<td><img src="http://placehold.it/100x100" alt=""></td>
								<td>
									<div style="height: 40px;"></div>
									<h4>${item.nome}</h4>
									<input type="hidden" name="itens[${s.index}].idPedido" value="${idPedido}"/>
									<input type="hidden" name="itens[${s.index}].idUsuario" value="${idUsuario}"/>
									<input type="hidden" name="itens[${s.index}].idProduto" value="${item.idProduto}"/>
									<input type="hidden" name="itens[${s.index}].preco" value="${item.preco}"/>
									
								</td>
								<td>
									<div style="height: 40px;"></div>
									<input type="text"  name="itens[${s.index}].quantidade" id="precoProduto_${item.idProduto}" onblur="calculaTotal('precoProduto_${item.idProduto}', ${item.preco}, 'totalPrecoProduto_${item.idProduto}')"  class="span1" style="height: 28px;" value="1"/>
								</td>
								<td>
									<div style="height: 40px;"></div>
									<a href="remove/${item.idProduto}"	class="btn btn-danger btn-mini" >
									<i class="icon-white icon-remove"></i></a>
								</td>
								<td>
									<div style="height: 40px;"></div>R$ ${item.preco}
								</td>
								<td>
									<div style="height: 40px;"></div>
									<span><h3>R$ </h3></span>
									<h3  id="totalPrecoProduto_${item.idProduto}" class="calculo totalItem">${item.preco}</h3>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>
								<h3 id="total"></h3>
							</td>
						
						</tr>
					</table>
				</form>
				<hr class="soften">
			</div>
		</div>
		<div class="row">
			<div class="span6 offset4">
				<p>Lorem ipsum dolor sit amet, consectetur
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
				<a onclick="finalizaPedido();">
				<img class="thumbnail"
					src="http://placehold.it/250x150&text=COMPRAR >>"
					alt="Pague com PagSeguro" style="cursor: pointer;">
				</a>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" charset="utf-8">
	jQuery(document).ready(
	);
	
	function finalizaPedido(){
		console.log('finalizando pedido');
		$('#formItens').submit();
	}
	
	function calculaTotal(input, preco, saida){
		console.log('input'+input);
		console.log('preco'+preco);
		console.log('saida'+saida);
		if($('#'+input).val()<=0){
			$('#'+input).val(1);
		}
		
		var quantidade = $('#'+input).val();
		var precoTotal = quantidade * preco;
		$('#'+saida).text(precoTotal);
		
		total();
	}
	
	function total(){
		var total = 0;
		$(".totalItem").each(function() {
			total += parseFloat($(this).text());
		});
		$('#total').text('Total: R$ '+total);
	}
	</script>
</my:preferences-container>
<my:preferences-footer />