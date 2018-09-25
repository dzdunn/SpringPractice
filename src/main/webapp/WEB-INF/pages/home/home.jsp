<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<mt:simpletemplate title="Hello Page">
	<jsp:attribute name="content">
		HELLO!
	</jsp:attribute>
</mt:simpletemplate>
</head>
<body>

<div class="alert alert-primary" role="alert">
  This is a test
</div>

<% for (int i=0; i < 10; i++){ %>
	<h2>HOME PAGE</h2>
	

<% }%>

<a href="/Practice/hello">test</a>

<form method="GET" action="/Practice/hello">
	<a>Click here</a>
	<input type="submit" value="submit">
</form>	




</body>
</html>