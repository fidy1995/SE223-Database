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
			<a href = "/Bookstore-SSH/user/pwd.jsp">change your password</a>
		<p>You can also see your&nbsp;
			<form action = "userStats.action" method = "post">
				<input type = "hidden" name = "username"
					value = "<%= session.getAttribute("username") %>" />
				<input type = "submit" value = "stats" />.
			</form>
		</p>
	</div>
	<div>
		<form action = "updateProfile.action" method = "post">
			<input type = "hidden" name = "username" value = "<%= session.getAttribute("username") %>" />
			<p>email: <%= request.getAttribute("email") %></p>
			<p><input name = "email" type = "text" /><input type = "submit" value = "change" /></p>
		</form>
		<form action = "updateProfile.action" method = "post">
			<input type = "hidden" name = "username" value = "<%= session.getAttribute("username") %>" />
			<p>qq: <%= request.getAttribute("qq") %></p>
			<p><input name = "qq" type = "text" /><input type = "submit" value = "change" /></p>
		</form>
		<form action = "updateProfile.action" method = "post">
			<input type = "hidden" name = "username" value = "<%= session.getAttribute("username") %>" />
			<p>tel: <%= request.getAttribute("tel") %></p>
			<p><input name = "tel" type = "text" /><input type = "submit" value = "change" /></p>
		</form>
	</div>
	<div>
		<jsp:include page = "/foot.jsp" />
	</div>

</body>
</html>