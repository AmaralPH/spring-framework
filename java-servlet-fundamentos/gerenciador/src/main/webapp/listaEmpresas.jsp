<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,br.com.caelum.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresas</title>
</head>
<body>
	<c:if test="${not empty empresa }">
		Empresa ${empresa } foi adicionada com sucesso!
	</c:if>
	
	<p>Lista de empresas:</p>
	<ul>
		<c:forEach items="${empresas }" var="empresa">
			<li>
				${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" />
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id }">editar </a>
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id }">remover </a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>