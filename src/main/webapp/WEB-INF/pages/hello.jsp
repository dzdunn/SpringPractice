<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC</title>
</head>
<body>
	<h2>${message}</h2>
	

	
 	<form method="POST" name="addStudent" action="hello/addStudent">
	<input type="text" name="studentName">
	<input type="submit" value = "submit">
	</form>
	
	<form:form method="POST" action="hello/addStudentSpringForm" modelAttribute="student">
		<form:label path="name">Name</form:label>
		<form:input path="name"/>	
		<form:label path="age">Age</form:label>
		<form:input path="age"/>	
		<input type="submit" value="submit"/>
	</form:form>
	

	
</body>
</html>