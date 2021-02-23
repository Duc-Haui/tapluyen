<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div align="center">
	<div>
		<a href="${pageContext.request.contextPath}"><img
			src="images/BookstoreLogo.png"></a>
	</div>

	<div>
		<form action="search" method="get">
			<input type="text" name="keyword" size="50" /> <input type="submit"
				value="Search" /> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				
				<a href="view_cart">Cart</a>
		</form>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/admin/">Admin</a>
	</div>
	<div>&nbsp;</div>
	
</div>



