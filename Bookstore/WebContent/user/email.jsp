<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit email page</title>
</head>
<body>
	<div>
		<jsp:include page = "/head.jsp" />
	</div>
	
	<div>
		<form action = "/Bookstore/user?action=email" method = "post">
			<p>Old Email: <input type = "text" name = "oldmail" /></p>
			<p>New Email: <input type = "text" name = "newmail" maxlength = 32 /></p>
			<p><input type = "submit" value = "submit" /></p>
		</form>
	</div>
	
	<div>
		<jsp:include page = "/foot.jsp" />
	</div>

</body>
</html>