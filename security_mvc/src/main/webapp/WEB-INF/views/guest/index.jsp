<%--
  Created by IntelliJ IDEA.
  User: jihye
  Date: 2019-02-04
  Time: 오전 5:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/"/> <!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1>손님 첫 페이지</h1>
    <hr/>
    <sec:authorize access="not authenticated">
        <a class="btn btn-default" href="${R}guest/login">로그인</a>
    </sec:authorize>
    <sec:authorize access="authenticated">
        <a class="btn btn-default" href="${R}user/logout_processing">로그아웃</a>
    </sec:authorize></div>
</body>
</html>

