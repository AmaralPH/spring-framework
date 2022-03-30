<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkToNewCompany" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkToNewCompany}" method="POST">
		Nome: </br><input type="text" name="nome" /></br>
		Data abertura: </br><input type="text" name="data" /></br>
		<input type="submit" />
	</form>
</body>
</html>