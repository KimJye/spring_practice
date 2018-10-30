<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"
    uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<h1>게시글 상세 보기</h1>

<ul>
    <li class="btn btn-default" id="btn-main">메인으로</li>
    <li class="btn btn-default" id="btn-update">수정하기</li>
    <li class="btn btn-default" id="btn-delete">삭제하기</li>
</ul>

<form action="update" method="post"
     class="form-group" id="member-reg-form">
    <label for="userid">아이디</label><br/>
    <input class="form-control" type="text" name="userid" id="userid" 
        value="${member.userid}" readonly />
    <br/>
    <label for="password">비밀번호</label><br/>
    <input class="form-control" type="password" name="password" id="password"
        value="${member.password}" />
    <br/>
    <label for="email">이메일</label><br/>
    <input class="form-control" type="email" name="email" id="email"
        value="${member.email}" />
    <br/>
    
</form>

</div>

<script>
$(document).ready(function() {
	$('#btn-main').click(function() {
		location = 'list';
	});
	
	$('#btn-update').click(function() {
		var msg = '아래 정보로 수정하시겠습니까?\n'
				+ '비밀번호: ' + $('#password').val() + '\n'
				+ '이메일: ' + $('#email').val();
		var result = confirm(msg);
		if (result) {
			$('#member-reg-form').submit();
		}
	});
	
	$('#btn-delete').click(function() {
		var result = confirm('정말 삭제하시겠습니까?');
		if (result) {
			location = 'delete?userid=' + $('#userid').val();
		}
	});
});
</script>

</body>
</html>






