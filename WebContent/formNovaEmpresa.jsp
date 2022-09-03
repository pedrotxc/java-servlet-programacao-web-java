<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${linkServletNovaEmpresa}" method="post">	
		Nome da Empresa: 	<input type="text" name="nome"/> <br>
		Data abertura:		<input type="text" name="data"> <br>
							<input type="submit">
	</form>
</body>
</html>