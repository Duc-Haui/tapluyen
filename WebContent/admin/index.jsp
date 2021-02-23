<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Evergreen Bookstore Administration</title>
	<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">Administrative Dashboard</h2>
	</div>
	<div align="center">
		<hr width="60%" />
		<h2 class="pageheading">Quick Actions:</h2>
		<b> <a href="new_book">New Book</a> &nbsp; <a href="user_form.jsp">New
				User</a> &nbsp; <a href="category_form.jsp">New Category</a> &nbsp; <a
			href="customer_form.jsp">New Customer</a>
		</b>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>