<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />

	<c:if test="${not empty empresa }">
		Empresa ${empresa } foi adicionada com sucesso!
	</c:if>
	<c:if test="${empty empresa }">
        Nenhuma empresa cadastrada!
	</c:if>
</body>
</html>