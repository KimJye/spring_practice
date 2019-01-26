<%--
  Created by IntelliJ IDEA.
  User: jihye
  Date: 2019-01-26
  Time: 오후 5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <base href="/form1/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="res/common.css">
    <style> .error {
        color: red;
    }</style>
</head>
<body>
<div class="container">
    <h1>회원 가입</h1>
    <form:form method="post" modelAttribute="userRegistrationModel">

        <div class="form-group">
            <label>아이디:</label>
            <form:input path="userid" class="form-control w200"/>
            <form:errors path="userid" class="error"/>
        </div>

        <div class="form-group">
            <label>비밀번호:</label>
            <form:password path="passwd1" class="form-control w200"/>
            <form:errors path="passwd1" class="error"/>
        </div>

        <div class="form-group">
            <label>비밀번호 확인:</label>
            <form:password path="passwd2" class="form-control w200"/>
            <form:errors path="passwd2" class="error"/>
        </div>

        <div class="form-group">
            <label>이름:</label>
            <form:input path="name" class="form-control w200"/>
            <form:errors path="name" class="error"/>
        </div>

        <div class="form-group">
            <label>이메일:</label>
            <form:input path="email" class="form-control w300"/>
            <form:errors path="email" class="error"/>
        </div>

        <div class="form-group">
            <label>학과</label>
            <form:select path="departmentId" class="form-control w200" itemValue="id"
                         itemLabel="name" items="${ departments }"/>
        </div>

        <button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-user"></i> 회원가입</button>
    </form:form>
</div>
</body>
</html>

