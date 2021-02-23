<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manager Category - Evergreen Bookstore Administration</title>
	<link rel="stylesheet" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h1 class="pageheading">Category list</h1>
		<h3>
			<a href="category_form.jsp">create new category</a>
		</h3>
	</div>
	<div align="center">
		<h3 class="message">${message}</h3>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="category" items="${listCategory}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${category.categoryId}</td>
					<td>${category.name}</td>
					<td><a href="edit_category?id=${category.categoryId}">Edit</a> &nbsp; 
					<a href="javascript:void(0)" class="deleteLink" id="${category.categoryId}">Delete</a></td>
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
					if(confirm("are you sure want to delete category with id=" +id+ "?")){
						window.location="delete_category?id=" + id;
					}
				});
			});
		});
	</script>
</body>
</html>