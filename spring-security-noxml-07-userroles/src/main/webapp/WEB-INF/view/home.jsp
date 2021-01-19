<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Java Learning Home page</title>
</head>
<body>
	
	<h2>Java Learning Home page</h2>
	<p>
	Welcome to the java Learning Home page!!!!!
	</p>
	<hr>
	
	<!-- Display user name and role -->
	<security:authorize access="hasRole('EMPLOYEE')">
		<p>
			User :
			<security:authentication property="principal.username" />
			<br> <br>
			Role(s) :
			<security:authentication property="principal.authorities" />
	
		</p>
		
	</security:authorize>  
	
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<!--Link to leader page  -->
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip
				Meeting</a>(Only Manager peeps)
		</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<p>
		<!--Link to point admin page  -->
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>(Only Admin peeps)
		</p>
	</security:authorize>

	<p>
		<!-- Add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POSt">
			<input type="Submit" value="Logout" />
		</form:form>
	</p>
	
</body>
</html>