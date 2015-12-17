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
		if (session.getAttribute("username") == null
				|| session.getAttribute("username").equals("")) {
	%>
	<p>
		Welcome to the bookstore! Please&nbsp;&nbsp; <a href="login.jsp">[login]</a>
		&nbsp;&nbsp; <a href="register.jsp">[register]</a>
	</p>
	<%
		} else if (session.getAttribute("username").equals("admin") == false) {
	%>
	<p>
		Welcome back, ${ session.getAttribute("username") }. You can 
		<a href="/Bookstore/user/center.jsp">[user center]</a>
		&nbsp;&nbsp;
		<a href="/Bookstore/cart?action=query">[shopping cart]</a>
		&nbsp;&nbsp; 
		<a href="/Bookstore/order?action=query">[see order form]</a>
		&nbsp;&nbsp;
		<a href="/Bookstore/index.jsp">[index]</a>
		&nbsp;&nbsp;
		<a href="/Bookstore/login?action=logout">[log out]</a>
	</p>
	<%
		} else {
	%>
	<p>
		Welcome back, administrator! You can 
		<a href="/Bookstore/admin/center.jsp">[go to admin center]</a>
		&nbsp;&nbsp; 
		<a href="/Bookstore/stats?action=query">[see selling stats]</a>
		&nbsp;&nbsp;
		<a href="/Bookstore/index.jsp">[index]</a>
		&nbsp;&nbsp;
		<a href="/Bookstore/login?action=logout">[log out]</a>
	<%
		}
	%>
	
</body>
</html>