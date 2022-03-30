<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkEntradaServlet}" method="POST">
		Nome: </br><input type="text" name="nome" /></br>
		Data abertura: </br><input type="text" name="data" /></br>
		<input type="hidden" name=acao value="NovaEmpresa" />
		<input type="submit" />
	</form>
</body>
</html>