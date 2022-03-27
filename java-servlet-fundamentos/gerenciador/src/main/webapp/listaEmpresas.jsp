<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.caelum.gerenciador.servlet.Empresa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas"); %>
	
	<ul>
		<%
			for (Empresa empresa : empresas) {
		%>
				<li>
					<%= empresa.getNome()%>
				</li>
		<%
			}

		%>
	</ul>

</body>
</html>