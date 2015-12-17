<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div>
		<jsp:include page = "head.jsp" />
	</div>
	
	<div>
		<form action = "register.action" method = "post">
			<table>
				<tr>
					<th colspan = 3>Username must be in at most 16 ascii characters.</th>
				</tr>
				<tr>
					<th>Username: </th>
					<th colspan = 2><input type = "text" name = "username" maxlength = 16 /></th>
				</tr>
				<tr>
					<th colspan = 3>Password must be in at most 16 ascii characters.</th>
				</tr>
				<tr>
					<th>Password: </th>
					<th colspan = 2><input type = "password" name = "password" maxlength = 16 /></th>
				</tr>
				<tr>
					<th>Again: </th>
					<th colspan = 2><input type = "password" name = "passa" maxlength = 16 /></th>
				</tr>
			</table>
			<input type = "submit" value = "Register now!" />
		</form>
		<p>Already have an account? Please <a href = "login.jsp">log in</a>.</p>
	</div>
	
	<div>
		<jsp:include page = "foot.jsp" />
	</div>

</body>
</html>