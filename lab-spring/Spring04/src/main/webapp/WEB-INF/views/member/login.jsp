<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>

<h1>로그인 양식</h1>
<form action="login-post" method="post">
    <input type="text" name="userid" placeholder="아이디"
        required autofocus />
    <br/>
    <input type="password" name="password" placeholder="비밀번호"
        required />
    <br/>
    <!-- 로그인 후에 이동할 페이지 -->
    <input type="hidden" name="queryString" 
        value="${loginTarget}" />
    <br/>
    <input type="submit" value="로그인" />
</form>

</body>
</html>





