<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edis password</title>
</head>
<body>
	<div>
		<jsp:include page = "/head.jsp" />
	</div>
	
	<div>
		<form action = "/Bookstore/user?action=password" method = "post">
			<p>Old password: <input type = "password" name = "oldpass" /></p>
			<p>New password: <input type = "password" name = "newpass" maxlength = 16 /></p>
			<p>Again:        <input type = "password" name = "newpassa" /></p>
			<p><input type = "submit" value = "submit" /></p>
		</form>
	</div>
	
	<div>
		<jsp:include page = "/foot.jsp" />
	</div>

</body>
</html>