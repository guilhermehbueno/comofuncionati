<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag body-content="scriptless" %>
	<body>
  <!-- Navbar  ================================================== -->
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="./index.html">ComoFuncionaTI</a>
          <div class="nav-collapse">
            <ul class="nav">
	          <li class="">
	                <a href="/">Home</a>
	          </li>
	          
	          	<c:forEach var="menu" items="${menus}">
	          		<li class="dropdown" id="menu1">
	          		   <a class="dropdown-toggle" data-toggle="dropdown" href="${submenu.link}">
					       <c:out value="${menu.label}" />
					       <b class="caret"></b>
	          		   </a>
	          		   <ul class="dropdown-menu">
						<c:forEach var="submenu" items="${menu.menu}">
							<li><a href="${submenu.link}"><c:out value="${submenu.label}" /></a></li>
						</c:forEach>
					   </ul>
					</li>
				</c:forEach>
               
            </ul>
			    <ul class="nav pull-right">
		           <li class="dropdown" id="menu4">
			    <a class="dropdown-toggle" data-toggle="dropdown" href="#menu4">
			      Perfil
			      <b class="caret"></b>
			    </a>
			    <ul class="dropdown-menu pull-right" id="menuPerfil">
			      <c:if test="${userName ne null}">
			       	   <li id="userNameLogado"><a href="#">${userName}</a></li>
				       <li><a href="/perfil">Meus pedidos</a></li>
				       <li><a href="/perfil">Meus endereços</a></li>
				       <li><a href="/login/logout">Sair</a></li>
			      </c:if>
			      <c:if test="${userName eq null}">			       	  
				      <li><a data-toggle="modal" href="#logar">Entrar</a></li>
				      <li><a data-toggle="modal" href="#cadastrar" >Cadastrar</a></li>
			      </c:if>
			    </ul>
			    
			  </li>
          		</ul>
          </div>
        </div>
      </div>
    </div>

	
<div class="container">
  <div class="row-fluid">
      <jsp:doBody />
  </div>
</div>

<!-- MODAL -->
    <div id="cadastrar" class="modal hide fade">
            <div class="modal-header">
              <button id="closeCadastro" class="close" data-dismiss="modal">&times;</button>
              <h3>Inscreva-se</h3>
            </div>
			<form id="formCadastroUsuario" class="well form-inline" method="post">
            <div class="modal-body">
           				<div id="modalMessageErrorCadastro" class="alert alert-error">
						  <h4 class="alert-heading">Warning!</h4>
						  <span id="errorMessageSpanCadastro"></span>
						</div>
			<br/>
						<div class="row-fluid">
							<div class="span10">
								<input type="text" id="nomeLoginCadastro" name="t.nome"  style="height: 28px;" placeholder="Nome completo" class="text-input email-input" id="input01" >
							</div>
						</div>
						
						<div class="row-fluid">
							<div class="span10">
								<input type="text" id="emailLoginCadastro" name="t.email" style="height: 28px;" placeholder="E-mail" class="text-input email-input" id="input01" >
							</div>
						</div>
						
						<div class="row-fluid">
								<div class="span8">
									<input type="text" id="passwordLoginCadastro" name="t.senha" style="height: 28px;" placeholder="Senha" class="text-input" id="input02" >
								</div>
						</div>
            </div>
            <div class="modal-footer">
            	<div class="row">
            		<div class="span2">
		              <input type="submit" class="btn btn-warning" value="Inscreva-se"/>
		              <a href="#"  id="closeCadastroBtn" class="btn" data-dismiss="modal" >Close</a>
            		</div>
            		<div class="span3">
            			<img id="loader" src="/stylesheets/assets/load.gif"></img>
            		</div>
            	</div>
            </div>
			</form>
          </div>
          
          
           <div id="logar" class="modal hide fade">
              <form id="formLogin" class="well form-inline  method="post">
            <div class="modal-header">
              <button id="closeLogin" class="close" data-dismiss="modal">&times;</button>
              <h3>Entrar</h3>
            </div>
            <div class="modal-body">
            
            			<div id="modalMessageError" class="alert alert-error">
						  <h4 class="alert-heading">Warning!</h4>
						  <span id="errorMessageSpan"></span>
						</div>
            			
						<div class="row-fluid">
							<div class="span10">
								<input type="text" id="usuarioLogin" style="height: 28px;" placeholder="Usuário ou E-mail" class="text-input email-input">
							</div>
						</div>
						
						<div class="row-fluid">
								<div class="span8">
									<input type="text" id="passwordLogin" style="height: 28px;" placeholder="Senha" class="text-input" id="input02" >
								</div>
							</div>
							<div class="row-fluid">
							 	<br/>
								<label class="checkbox">
							    	<input type="checkbox"> Lembrar-me
   							    </label>
   							    <br/>
   							    <label class="control-label" style="padding-top: 3px;">
   							    	<a href="#">Esqueceu sua senha?</a>
   							    </label>
   							    <br/>
   							    <label class="control-label" style="padding-top: 3px;">
   							    	<a href="#" onclick="viewModalCadastrar()" >Não tem cadastro?</a>
   							    </label>
							</div>
			<br/>
            </div>
            <div class="modal-footer">
            	<div class="row">
            		<div class="span3">
		               <img alt="Twitter" src="/stylesheets/assets/img/social-icons/Twitter.png">
					   <a href="${login}"><img alt="Twitter" src="/stylesheets/assets/img/social-icons/Google+.png"></a>
					   <img alt="Twitter" src="/stylesheets/assets/img/social-icons/Facebook.png">
			           <button class="btn btn-info">Entrar</button>
			           <a href="#" id="closeLoginBtn" class="btn" data-dismiss="modal" >Close</a>
            		</div>
            		<div class="span2">
            			<img id="loaderLogin" src="/stylesheets/assets/load.gif"></img>
            		</div>
            	</div>
            </div>
			</form>
          </div>
<!-- MODAL -->

</body>
