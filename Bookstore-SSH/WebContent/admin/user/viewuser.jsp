<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href = "/bootstrap/css/bootstrap.min.css" rel = "stylesheet" />
		<script src = "/bootstrap/js/jquery.min.js"></script>
		<script src = "/bootstrap/js/bootstrap.min.js"></script>
		<title>Welcome to my bookstore!</title>
	</head>
	
	<body>
		<jsp:include page = "/head.jsp" />
		
		<div>
			<table border = 0>
				<tr>
					<td>Username:</td>
					<td><%= request.getAttribute("username") %></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><%= request.getAttribute("email") %></td>
				</tr>
				<tr>
					<td>QQ:</td>
					<td><%= request.getAttribute("qq") %></td>
				</tr>
				<tr>
					<td>Tel:</td>
					<td><%= request.getAttribute("tel") %></td>
				</tr>
			</table>
			<form action = "editpass.action" method = "post">
				<input type = "hidden" name = "username"
					value = <%= request.getAttribute("username") %> />
				New password: <input type = "text" name = "newpass" />
				<input type = "submit" value = "change" />
			</form>
		</div>
		
		<jsp:include page = "/foot.jsp" />
	</body>
	
</html>