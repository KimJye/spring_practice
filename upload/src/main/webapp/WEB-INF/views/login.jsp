<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<div class="form-group">
			<input type="text" name="userId" value="${ user.userId }" />
		</div>

		<div class="form-group">
			<input class="input100" type="password" name="password"
				value="${ user.password }" />
		</div>
	<div class="form-group">
			<div class="wrap-login100-form-btn">
				<div class="login100-form-bgbtn"></div>
				<button class="login100-form-btn">Login</button>
			</div>
		</div>
	</form>
</body>
</html>