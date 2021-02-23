<link rel="stylesheet" href="../css/style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<div>
		<a href="${pageContext.request.contextPath}/admin/"><img src="../images/BookstoreAdminLogo.png"></a>
	</div>
	<div style="padding-bottom: 20px">
		Welcome,<c:out value="${sessionScope.useremail}" /><a href="logout"> Logout</a> <br>
	</div>
	<div id="headermenu">
		<div class="menu_item">
			<a href="list_users"> <img alt="" src="../images/users.png"><br>Users
			</a>
		</div>

		<div class="menu_item">
			<a href="list_category"> <img alt="" src="../images/category.png"><br>Categories
			</a>
		</div>

		<div class="menu_item">
			<a href="list_books"> <img alt="" src="../images/book.png"><br>Books
			</a>
		</div>
		<div class="menu_item">
			<a href="list_customer"> <img alt="" src="../images/customer.png"><br>Customers
			</a>
		</div>

		<div class="menu_item">
			<a href="list_review"> <img alt="" src="../images/review.png"><br>Reviews
			</a>
		</div>

		<div class="menu_item">
			<a href="list_order"> <img alt="" src="../images/order.png"><br>Order
			</a>
		</div>
	</div>
</div>