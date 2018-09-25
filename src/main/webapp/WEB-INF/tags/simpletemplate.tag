<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
<link href="static/bootstrap/4.1.3/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<script src="static/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

	<jsp:invoke fragment="content"></jsp:invoke>
	<br />
	<a href="/Practice/hello">Home</a>
	<br />
</body>
</html>
