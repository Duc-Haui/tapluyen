<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<div align="center">
	<h1>Book Store Administration</h1>
	<h2>Admin Login</h2>
	<div>
		<h2>${message}</h2>
	</div>
	<form action="login" method="post" id="formLogin">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" id="email" size="20"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password" size="20"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Login</button>
				</td>
			</tr>
		</table>
	</form>	
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#formLogin").validate({
				rules:{
					email:{
						required:true,
						email:true
					},
					password:"required"
				},
				messages:{
					email:{
						required:"please enter your email"
					},
					password:"please enter your password"
				}
			});
		});
	</script>
</body>
</html>