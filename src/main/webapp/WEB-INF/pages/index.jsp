<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<mt:simpletemplate title="Home page">
<jsp:attribute name="content">
Home page
</jsp:attribute>

</mt:simpletemplate>
</head>
<body>
<h2>INDEX TEST</h2>

<h3>${studentName}</h3>

<h5>Student's name is: ${student.name}</h5>
<h5>Student's age is: ${student.age}</h5>

</body>
</html>