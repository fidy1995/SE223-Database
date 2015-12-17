<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User login</title>
</head>
<body>
	<div>
		<jsp:include page = "head.jsp" />
	</div>
	
	<div>
		<form action = "login?action=login" method = "post">
			<table>
				<tr>
					<th>Username: </th>
					<th colspan = 2><input type = "text" name = "username" maxlength = 16 /></th>
				</tr>
				<tr>
					<th>Password: </th>
					<th colspan = 2><input type = "password" name = "password" maxlength = 16 /></th>
				</tr>
			</table>
			<input type = "submit" value = "login" />
		</form>
		<p>Have no account? Click here to <a href = "register.jsp">register</a>.</p>
	</div>
	
	<div>
		<jsp:include page = "foot.jsp" />
	</div>

</body>
</html>