<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Internal Sever Error</title>
</head>
<body>
	<div align="center">
		<div>
			<img src="${pageContext.request.contextPath}/images/BookstoreLogo.png">
		</div>
		<div>
			<h2>Sorry, the sever has encountered an error while fulling your request.</h2>
			<h3>Please check back later or contact Administration</h3>
		</div>
		<div>
			<a href="javascript:history.go(-1)">Go back</a>
		</div>
	</div>
</body>
</html>