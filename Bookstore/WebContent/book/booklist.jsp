<%@ page language="java" import = "java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "dpp.bookstore.pojo.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booklist</title>
</head>
<body>
	<div>
		<jsp:include page = "/head.jsp" />
	</div>
	
	<div>
		<jsp:include page = "/searchbar.jsp" />
	</div>
	<div>
	<%
		Vector<Book> books = (Vector<Book>)request.getAttribute("booklist");
		int size = books.size();
		if (size > 0) {
	%>
			<table border = "1">
				<tr>
					<td>Title</td>
					<td>ISBN</td>
					<td>Category</td>
					<td>Price</td>
					<td>&nbsp;</td>
				</tr>
		<%
			for (int i = 0; i < size; i++) {
		%>
				<tr>
					<td><%= books.get(i).getTitle() %>&nbsp;</td>
					<td><%= books.get(i).getIsbn() %>&nbsp;</td>
					<td><%= books.get(i).getCategory() %>&nbsp;</td>
					<td><%= books.get(i).getPrice() %>&nbsp;</td>
					<td><form action = "/Bookstore/cart?action=add" method = "post">
						<input type = "text" name = "quantity" />
						<input type = "hidden" name = "bookname" value = <%= books.get(i).getIsbn() %> />
						<input type = "submit" value = "Add to cart" />
						</form>
					</td>
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