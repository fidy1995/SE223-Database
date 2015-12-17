<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<jsp:include page = "/head.jsp" />
	</div>
	<div>
		<p>Here is your command center.</p>
		<p>Book:&nbsp;
			<a href = "book.action">query</a>
			&nbsp;&nbsp;
			<a href = "./book/addbook.jsp">update</a>.</p>
		<p>Users:&nbsp;
			<a href = "queryUser.action">query</a>
			&nbsp;&nbsp;
			<a href = "order.action">order</a>.</p>
	</div>
	<div>
		<jsp:include page = "/foot.jsp" />
	</div>
</body>
</html>