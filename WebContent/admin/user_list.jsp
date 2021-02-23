<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Manage Users - Evergreen Bookstore Administration</title>
	<link rel="stylesheet" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">User List Manager</h2>
		<a href="user_form.jsp">create new User</a>
	</div>
	<div align="center">
		<h3 class="message">${message}</h3>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Full Name</th>
				<th>Email</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="user" items="${listUsers}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${user.id}</td>
					<td>${user.fullName}</td>
					<td>${user.email}</td>
					<td>
						<a href="edit_user?id=${user.id}">Edit</a>  &nbsp;
						<a href="javascript:void(0);" class="deleteLink" id="${user.id}">Delete</a>					
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
	
		$(document).ready(function() {
			$(".deleteLink").each(function() {
				$(this).on("click",function() {
					id = $(this).attr("id");
					if(confirm("are you sure want to delete user with id=" +id+ "?")){
						window.location="delete_user?id=" + id;
					}
				});
			});
		});
		
	</script>
	
</body>

</html>