<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag body-content="scriptless" %>

<!-- STATUS -->
<div class ="row-fluid">
<div class="span8 offset2">
	<ol>
		<c:forEach var="status" items="${status}" varStatus="s">
			<li><span class="label label-info">${status.atributo}</span> : ${status.valor}  ${status.descricao}</li>
		</c:forEach>
	</ol>
</div>
</div>