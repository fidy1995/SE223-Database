<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login status page</title>
</head>
<body>
	<div>
		<jsp:include page = "head.jsp" />
	</div>
	
	<div>
	<%
		if (request.getAttribute("status").equals("Login success!")) {
	%>
		<p>Login success! Click <a href = "index.jsp">here</a> to go back.</p>
	<%
		} else if (request.getAttribute("status").equals("Logout success.")) {
	%>
		<p>Logout success. Click <a href = "index.jsp">here</a> to go back.</p>
		<p>Click <a href = "login.jsp">here</a> to login.
	<%
		} else {
	%>
		<p><%= String.valueOf(request.getAttribute("status")) %></p>
		<p>Click <a href = "login.jsp">here</a> to try again, 
			or <a href = "index.jsp">back</a> to index.</p>
	<%
		}
	%>
	</div>
	
	<div>
		<jsp:include page = "foot.jsp" />
	</div>

</body>
</html>