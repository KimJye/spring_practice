<%--
  Created by IntelliJ IDEA.
  User: jihye
  Date: 2019-02-04
  Time: 오전 5:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container"><h1>사용자 첫 페이지</h1>
    <hr/>
    <table class="table table-bordered" style="width:500px;">
        <tr>
            <td>로그인ID</td>
            <td><sec:authentication property="user.loginId"/></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><sec:authentication property="user.name"/></td>
        </tr>
        <tr>
            <td>이메일</td>
            <td><sec:authentication property="user.email"/></td>
        </tr>
    </table>
    <a class="btn btn-default" href="logout_processing">로그아웃</a>
</div>
</body>
</html>

