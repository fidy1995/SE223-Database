<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "dpp.bookstore.pojo.Order" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My cart</title>
</head>
<body>
	<div>
		<jsp:include page = "/head.jsp" />
	</div>
	
	<div>
	<%
		Vector<Order> orders = (Vector<Order>)request.getAttribute("orders");
		if (orders.size() == 0) {
	%>
			<p>Cart is empty! Why not see our
				<a href = "/Bookstore/book?action=query">booklist</a>?</p>
	<%
		} else {
	%>
		<table border = "1">
			<tr>
				<td align = "center">ISBN</td>
				<td align = "center">Quantity</td>
				<td>&nbsp;</td>
			</tr>
		<%
			for (int i = 0; i < orders.size(); i++) {
		
		%>
				<tr>
					<td align = "center"><%= orders.get(i).getIsbn() %>&nbsp;</td>
					<td align = "center"><%= orders.get(i).getQuantity() %>&nbsp;</td>
					<td><form action = "/Bookstore/cart?action=delete" method = "post">
							<input type = "hidden" name = "isbn" value = <%= orders.get(i).getIsbn() %> />
							<input type = "submit" value = "delete" />					
						</form>
					</td>
				</tr>
		<%
			}
		%>
		</table>
		<form action = "/Bookstore/cart?action=pay" method = "post">
			<input type = "submit" value = "Pay now!" />
		</form>
	<%
		}
	%>
	</div>
	
	<div>
		<jsp:include page = "/foot.jsp" />
	</div>
</body>
</html>