<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your user center</title>
</head>
<body>
	<div>
		<jsp:include page = "/head.jsp" />
	</div>
	<div>
		<p>Here is your personal center.</p>
		<p>You can&nbsp;
			<a href = "./password.jsp">change your password</a>
			&nbsp;or&nbsp;
			<a href = "./email.jsp">change your email</a>.</p>
		<p>You can also&nbsp;
			<a href = "/Bookstore/stats?action=query">see your stats</a>.</p>
	</div>
	<div>
		<jsp:include page = "/foot.jsp" />
	</div>

</body>
</html>