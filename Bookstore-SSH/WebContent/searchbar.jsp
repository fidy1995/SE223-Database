<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--

	The search bar of the website.

 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>A simple search bar.</title>
</head>
<body>
	<div>
		<form action = "book.action" method = "post">
			<p>
				<input type = "text" name = "content" />
				&nbsp;
				<select name = "method">
					<option value = "title" selected = "selected">Title</option>
					<option value = "isbn">Isbn</option>
					<option value = "category">Category</option>
				</select>
				&nbsp;
				<input type = "submit" value = "Search!" />
			</p>
		</form>
	</div>
</body>
</html>