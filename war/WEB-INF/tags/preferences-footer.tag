<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
<script src="/stylesheets/assets/js/google-code-prettify/prettify.js"></script>
<script src="/stylesheets/assets/js/bootstrap-transition.js"></script>
<script src="/stylesheets/assets/js/bootstrap-alert.js"></script>
<script src="/stylesheets/assets/js/bootstrap-modal.js"></script>
<script src="/stylesheets/assets/js/bootstrap-dropdown.js"></script>
<script src="/stylesheets/assets/js/bootstrap-scrollspy.js"></script>
<script src="/stylesheets/assets/js/bootstrap-tab.js"></script>
<script src="/stylesheets/assets/js/bootstrap-tooltip.js"></script>
<script src="/stylesheets/assets/js/bootstrap-popover.js"></script>
<script src="/stylesheets/assets/js/bootstrap-button.js"></script>
<script src="/stylesheets/assets/js/bootstrap-collapse.js"></script>
<script src="/stylesheets/assets/js/bootstrap-carousel.js"></script>
<script src="/stylesheets/assets/js/bootstrap-typeahead.js"></script>
<script src="/stylesheets/assets/js/application.js"></script>
<script src="/stylesheets/assets/js/buenosscript.js"></script>




<script type="text/javascript" charset="utf-8">
		jQuery(document).ready(function(){
			var urlHostCadastro ='${host}/usuario/salvar';
			console.log(urlHostCadastro);
			$('#loader').hide();
			$('#formCadastroUsuario').submit(function(){
				$('#loader').show();
				jQuery.ajax({
			          url: urlHostCadastro,
			          type: 'POST',
			          data:{nome: 'guilherme', email:'guilhermehbueno@gmail.com', senha:'123'},
			          dataType: 'json',
			          success: function(data) {
			        	    console.log('Load was performed: '+data.usuario.email);
							$('#cadastrar').modal('hide')
							$('#loader').hide();
							$("#menuPerfil")
								.empty()
								.html("<li id='userNameLogado'><a href='#'>"+data.usuario.email+"</a></li>")
								.append("<li><a href='/perfil'>Meus pedidos</a></li>")
								.append("<li><a href='/perfil'>Meus enderešos</a></li>")
								.append("<li><a href='/login/logout'>Sair</a></li>");
			          }
				});
				return false; 
			});
		});
		
		
</script>

<script type="text/javascript" charset="utf-8">
		function viewModalCadastrar(){
			$('#cadastrar').modal('show');
			$('#logar').modal('hide');
		}

		jQuery(document).ready(function(){
			var urlHostLogin ='${host}/login/login';
			console.log(urlHostLogin);
			$('#loaderLogin').hide();
			$('#formLogin').submit(function(){
				$('#loaderLogin').show();
				console.log("executando submit: "+urlHostLogin)
				jQuery.ajax({
			          url: urlHostLogin,
			          type: 'POST',
			          data:{emailUsername:'guilhermehbueno@gmail.com', senha:'123'},
			          dataType: 'json',
			          success: function(data) {
			        	    console.log('Load was performed: '+data.usuario.email);
							$('#logar').modal('hide')
							$('#loaderLogin').hide();
							$("#menuPerfil")
								.empty()
								.html("<li id='userNameLogado'><a href='#'>"+data.usuario.email+"</a></li>")
								.append("<li><a href='/perfil'>Meus pedidos</a></li>")
								.append("<li><a href='/perfil'>Meus enderešos</a></li>")
								.append("<li><a href='/login/logout'>Sair</a></li>");
			          }
				});
				return false; 
			});
		});
</script>

	
	