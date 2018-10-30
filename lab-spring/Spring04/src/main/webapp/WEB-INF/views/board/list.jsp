<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.2.1.min.js">
</script>

</head>
<body>

<h1>게시판 메인 페이지</h1>
<c:if test="${empty loginUserid}">
    <button id="btn-login">로그인</button>
</c:if>
<c:if test="${not empty loginUserid}">
    ${loginUserid}님, 환영합니다!
    <button id="btn-logout">로그 아웃</button>
</c:if>

<hr/>
<a href="register">새 글 작성</a>

<hr/>
<h2>게시글 목록</h2>


<script>
$(document).ready(function() {
	
	$('#btn-login').click(function() {
		console.log(location.href);
		location = encodeURI('/ex04/member/login?url=' 
                + location.href);
	});
	
	$('#btn-logout').click(function() {
		location = '/ex04/member/logout';
	});
	
});
</script>

</body>
</html>








