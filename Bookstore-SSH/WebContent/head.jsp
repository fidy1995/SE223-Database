<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%  
		if (request.getAttribute("status") != null 
			&& request.getAttribute("status") != "") {
	%>
		<p align = "center"><%= String.valueOf(request.getAttribute("status")) %></p>
	<%
		}
		if (session.getAttribute("username") == null
				|| session.getAttribute("username").equals("")) {
	%>
	<p>
		Welcome to the bookstore! Please&nbsp;&nbsp; <a href="login.jsp">[login]</a>
		&nbsp;&nbsp; <a href="/Bookstore-SSH/register.jsp">[register]</a>
	</p>
	<%
		} else if (session.getAttribute("username").equals("admin") == false) {
	%>
	<p>
		Welcome back, <%= session.getAttribute("username") %>. You can 
		<a href="queryProfile.action?username=<%= session.getAttribute("username")%>">[user center]</a>
		&nbsp;&nbsp;
		<a href="cart.action">[shopping cart]</a>
		&nbsp;&nbsp; 
		<a href="order.action">[see order form]</a>
		&nbsp;&nbsp;
		<a href="/Bookstore-SSH/index.jsp">[index]</a>
		&nbsp;&nbsp;
		<a href="logout.action">[log out]</a>
	</p>
	<%
		} else {
	%>
	<p>
		Welcome back, administrator! You can 
		<a href="/Bookstore-SSH/admin/center.jsp">[go to admin center]</a>
		&nbsp;&nbsp; 
		<a href="userStats.action">[see selling stats]</a>
		&nbsp;&nbsp;
		<a href="/Bookstore-SSH/index.jsp">[index]</a>
		&nbsp;&nbsp;
		<a href="logout.action">[log out]</a>
	<%
		}
	%>
	
</body>
</html>