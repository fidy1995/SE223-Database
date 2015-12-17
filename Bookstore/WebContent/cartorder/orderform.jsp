<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "dpp.bookstore.pojo.Order" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My orders</title>
</head>
<body>
	<div>
		<jsp:include page = "/head.jsp" />
	</div>
	
	<div>
	<%
		Vector<Order> orders = (Vector<Order>)request.getAttribute("orders");
		int size = orders.size();
		if (size != 0) {
	%>
		<table border = "1">
			<tr>
				<td align = "center">ISBN</td>
				<td align = "center">Quantity</td>
				<td align = "center">Date</td>
			</tr>
		<%
			for(int i = 0; i < size; i++) {
		%>
				<tr>
					<td><%= orders.get(i).getIsbn() %>&nbsp;</td>
					<td><%= orders.get(i).getQuantity() %>&nbsp;</td>
					<td><%= orders.get(i).getPaiddate().toString() %>&nbsp;</td>
				</tr>
		<%
			}
		%>
		</table>
	<%
		} else {
	%>
		<p>You haven't buy anything! Why not have a look at our
			<a href = "/Bookstore/book?action=query">booklist</a>?</p>
	<%
		}
	%>
	</div>
	
	<div>
		<jsp:include page = "/foot.jsp" />
	</div>

</body>
</html>