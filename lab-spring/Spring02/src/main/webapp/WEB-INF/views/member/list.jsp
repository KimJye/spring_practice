<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>
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

<h1>회원 정보 메인 페이지</h1>

<ul>
    <li><a href="register">새 회원 추가</a></li>
</ul>

<hr/>

<table class="table table-striped">
    <thead>
        <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이메일</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="member" items="${memberList}">
            <tr>
                <td>
                    <a href="detail?userid=${member.userid}">${member.userid}</a>
                </td>
                <td>${member.password}</td>
                <td>${member.email}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</div>

</body>
</html>




