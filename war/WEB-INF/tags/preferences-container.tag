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
			    <ul class="dropdown-menu pull-right">
			      <c:if test="${userName ne null}">
				      <li><a href="/perfil">${userName}</a></li>
				      <li><a href="${logout}">Sair</a></li>
			      </c:if>
			      <c:if test="${userName eq null}">
				      <li><a href="${login}">Entrar</a></li>
				      <li><a href="/cadastrar">Cadastrar</a></li>
			      </c:if>
			    </ul>
			    
			  </li>
          		</ul>
          </div>
          
        </div>
      </div>
    </div>

	
<div class="container-fluid">
  <div class="row-fluid">
  	<!--
    <div class="span2">
    	 <preferences:menu />
    </div>
     -->
    <div class="span12">
      <jsp:doBody />
    </div>
  </div>
</div>

	</body>
	