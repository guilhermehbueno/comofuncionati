<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script type="text/javascript"
	src="http://platform.twitter.com/widgets.js"></script>
<script src="/stylesheets/assets/js/jquery.js"></script>
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


<script type="text/javascript" charset="utf-8">
		jQuery(document).ready(function(){
			$('#formCadastroUsuario').submit(function(){
				jQuery.ajax({
			          url: 'http://localhost:8888/usuario/salvar',
			          type: 'POST',
			          data:{nome: 'guilherme', email:'guilhermehbueno@gmail.com', senha:'123'},
			          dataType: 'json',
			          success: function(data) {
			        	    console.log('Load was performed: '+data);
			          }
				});
				$('#cadastrar').modal('hide')
				return false; 
			});
		});
</script>


