<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update books</title>
</head>
<body>
	<div>
		<jsp:include page = "/head.jsp" />
	</div>
	
	<div>
		<form action = "/Bookstore/book?action=update" method = "post">
			<p>ISBN: <input type = "text" name = "isbn" /></p>
			<p>title: <input type = "text" name = "title" /></p>
			<p>category: <input type = "text" name = "category" /></p>
			<p>price: <input type = "text" name = "price" /></p>	
			<p><input type = "submit" value = "submit" /></p>		
		</form>		
	</div>
	
	<div>
		<jsp:include page = "/foot.jsp" />
	</div>

</body>
</html>