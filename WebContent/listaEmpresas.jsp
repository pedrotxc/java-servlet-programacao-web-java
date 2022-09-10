<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.estudo.gerenciador.modelo.Empresa" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Java Standard Taglib</title>
	</head>
	
	<body>
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>
					${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
					<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">edita</a>
					<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>