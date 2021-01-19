<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Java Learning Home page</title>
</head>
<body>
	<h2>Java Learning Home page - Hooooohoooo!!!!!!!</h2>
	Welcome to the java Learning Home page!!!!!
	<p>
		<!-- Add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POSt">
			<input type="Submit" value="Logout" />
		</form:form>
	</p>
</body>
</html>