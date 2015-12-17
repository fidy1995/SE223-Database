<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "dpp.bookstore.pojo.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User list</title>
</head>
<body>
	<div>
		<jsp:include page = "/head.jsp" />
	</div>
	
	<%
		Vector<User> users = (Vector<User>)request.getAttribute("userlist");
		int size = users.size();
		if (size > 0) {
	%>
			<table>
				<tr>
					<td>Username</td>
					<td>Password</td>
					<td>Email Address</td>
				</tr>
		<%
			for (int i = 0; i < size; i++) {
		%>
				<tr>
					<td><%= users.get(i).getUsername() %>&nbsp;</td>
					<td><%= users.get(i).getPassword() %>&nbsp;</td>
					<td><%= users.get(i).getEmail() %>&nbsp;</td>
				</tr>
		<%
			}
		%>
		</table>
	<%
		} else {
	%>
		<p>Sorry, but nothing has been found!</p>
	<%
		}
	%>	
		
	</div>
	
	<div>
		<jsp:include page = "/foot.jsp" />
	</div>

</body>
</html>