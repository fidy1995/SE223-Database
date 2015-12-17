<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register status page</title>
</head>
<body>
	<div>
		<jsp:include page = "head.jsp" />
	</div>
	
	<div>
		<p><%= String.valueOf(request.getAttribute("status")) %></p>
		<p>You can go back to&nbsp;
		<a href = "index.jsp">the index</a>
	<%
		if (request.getAttribute("status").equals("Register succeed.") == false) {
	%>
		&nbsp;or&nbsp;
		<a href = "register.jsp">try again.</a>
	<%
		}
	%>
	</div>
	
	<div>
		<jsp:include page = "foot.jsp" />
	</div>

</body>
</html>