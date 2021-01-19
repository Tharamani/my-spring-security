<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Learning - Systems page</title>
</head>
<body>
	<h2>Systems page</h2>
	<hr>
	<b>Hey, <security:authentication property="principal.username" /> </b>
	<p>We have our annual Caribbean cruise coming now.Registe now!</p>
	<br>
	Keep this trip a secret, don't tell the regular employee :-)
	<hr>
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>
</html> 