<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stats page</title>
</head>
<body>
	<div>
		<jsp:include page = "/head.jsp" />
	</div>
	
	<div>
	<%
		HashMap<String, Integer> stats = (HashMap<String, Integer>)request.getAttribute("statsmap");
		Set set = stats.entrySet();
		Iterator i = set.iterator();
	%>
		<table border = "1">
			<tr>
				<td>Factor</td>
				<td>Stats</td>
			</tr>
	<%
		while(i.hasNext()) {
			HashMap.Entry<String, Integer> entry = (HashMap.Entry<String, Integer>)i.next();
	%>
			<tr>
				<td><%= entry.getKey() %>&nbsp;</td>
				<td><%= entry.getValue() %>&nbsp;</td>
			</tr>
	<%
		}
	%>
		</table>
	</div>
	
	<div>
	<%
		if (request.getSession().getAttribute("username").equals("admin")) {
	%>
		<form action = "userStats.action" method = "post">
			<p>
				Username:<input type = "text" name = "username" />
				<input type = "submit" value = "Go!" />
			</p>
		</form>
	<%
		}
	%>
		<form action = "timeStats.action" method = "post">
			<select name = "time">
				<option value = "d">by day</option>
				<option value = "m">by month</option>
				<option value = "y">by year</option>
			</select>
			<input type = "submit" value = "Go!" />
		</form>
		<a href = "catStats.action">
			By category &nbsp;<button>Go!</button>
		</a>
	</div>
	
	<div>
		<jsp:include page = "/foot.jsp" />
	</div>

</body>
</html>