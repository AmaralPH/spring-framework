<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada?" var="linkParaEditaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />

	<form action="${linkParaEditaEmpresa}" method="POST">
		Nome: </br><input type="text" name="nome" value="${empresa.nome }" /></br>
		Data abertura: </br><input name="data" value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" />" /></br>
		<input type="hidden" name ="id" value=${empresa.id } />
		<input type="hidden" name ="acao" value="AlteraEmpresa" />
		<input type="submit" />
	</form>
</body>
</html>