<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %> 
<my:preferences-header />
<my:preferences-container>
	
<div class="marketing span12">
  <h1>Como Funciona TI?</h1>
  <p class="marketing-byline">Tudo o que você precisa saber ao atuar na área de TI.</p>
   <div class="row">
   		
   </div>
   
   <div class="row">
   <div class="span12">
      <img class="bs-icon" src="/stylesheets/assets/img/glyphicons/glyphicons_042_group.png">
      <h2>Nosso objetivo</h2>
    <p>
		O Como Funciona TI tem como objetivo auxiliar todos as pessoas que se interessam e estão ingressando no mundo de tecnologia da informação.
		Esta idéia surgiu da dificuldades de pessoas iniciantes que fui encontrando ao longo de alguns anos de trabalho.
		Na área de TI com toda a certeza você irá encontrar mais dúvidas do que certezas. É uma área instável, em constante transformação. O conteúdo que encontrará aqui é apenas uma micro-introdução de tudo o que irá encontrar em seu dia-a-dia.
		
		E lembre-se:
		
			
	</p>
	
	<br />
	<div class="span6">
      <blockquote>
        <p>Paciência e perseverança tem o efeito mágico de fazer as dificuldades desaparecerem e os obstáculos sumirem</p>
        <small><cite title="">John Quincy Adams</cite></small>
      </blockquote>
    </div>
	
    </div>
   </div>
  <div class="row">
    <div class="span4">
      <img class="bs-icon" src="/stylesheets/assets/img/glyphicons/glyphicons_042_group.png">
      <h2>Cargos - O que faz?</h2>
      <p>Like you, we love building awesome products on the web. We love it so much, we decided to help people just like us do it easier, better, and faster. Bootstrap is built for you.</p>
    </div>
    <div class="span4">
      <img class="bs-icon" src="/stylesheets/assets/img/glyphicons/glyphicons_079_podium.png">
      <h2>Métodologias de desenvolvimento de software</h2>
      <p>Bootstrap is designed to help people of all skill levels&mdash;designer or developer, huge nerd or early beginner. Use it as a complete kit or use to start something more complex.</p>
    </div>
    <div class="span4">
      <img class="bs-icon" src="/stylesheets/assets/img/glyphicons/glyphicons_163_iphone.png">
      <h2>Linguagens de Programação</h2>
      <p>Originally built with only modern browsers in mind, Bootstrap has evolved to include support for all major browsers (even IE7!) and, with Bootstrap 2, tablets and smartphones, too.</p>
    </div>
  </div><!--/row-->

<hr class="soften">
	<div class="row">
	<c:forEach var="menu" items="${menus}">
		<div class="page-header">
		  <h1><c:out value="${menu.label}" /></h1>
		</div>
		<br />
			<div class="span12">
				<ul class="thumbnails">
					<c:forEach var="submenu" items="${menu.menu}">
						<li class="span3">
							<div class="thumbnail">
								<img src="http://placehold.it/260x180" alt="">
								<div class="caption">
									<h5>
										<c:out value="${submenu.label}" />
										<br />
									</h5>
									<p>Cras justo odio, dapibus ac facilisis in, egestas eget
										quam. Donec id elit non mi porta gravida at eget metus. Nullam
										id dolor id nibh ultricies vehicula ut id elit.</p>
									<p>
										<a href="#" class="btn btn-primary">Saiba Mais...</a>
									</p>
								</div>
							</div>
					</c:forEach>
					</li>
				</ul>
			</div>
	</c:forEach>
		</div>
</my:preferences-container>
<my:preferences-footer />