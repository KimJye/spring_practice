<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">

<h1>회원 가입 페이지</h1>

<form action="register" method="post"
    class="form-group">
    <label for="userid">아이디</label><br/>
    <input class="form-control" type="text" name="userid" id="userid" required />
    <br/>
    <label for="password">비밀번호</label><br/>
    <input class="form-control" type="password" name="password" id="password" required />
    <br/>
    <label for="email">이메일</label><br/>
    <input class="form-control" type="email" name="email" id="email" required />
    <br/>
    <input class="form-control btn btn-primary" type="submit" value="회원 가입" />
</form>

</div>

</body>
</html>
