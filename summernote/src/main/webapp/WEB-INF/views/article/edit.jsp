<%--
  Created by IntelliJ IDEA.
  User: jihye
  Date: 2019-01-27
  Time: 오후 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<c:url var="R" value="/"/> <!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="${R}res/summernote/summernote.css" rel="stylesheet">
    <script src="${R}res/summernote/summernote.js"></script>
    <script src="${R}res/common.js"></script>
    <link href="${R}res/common.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>${ board.boardName }</h1>
    <hr/>
    <form:form method="post" modelAttribute="articleModel">
        <span>제목 </span>
        <form:input path="title" class="form-control"/>
        <form:errors path="title" class="error"/><br/>

        <div id="summernote">${ articleModel.body }</div>
        <form:errors path="body" class="error"/>
        <input type="hidden" name="body"/>
    </form:form>

    <div id="buttons">
        <a class="btn btn-primary" onclick="save()">
            <i class="glyphicon glyphicon-hdd"></i> 저장</a>
        <a class="btn btn-default" href="list?${ pagination.queryString }">
            <i class="glyphicon glyphicon-list"></i>목록으로</a>
    </div>
</div>

<script>
    $('#summernote').summernote({height: 500});

function save() {
    var s = $('#summernote').summernote('code');
    $('input[name=body]').val(s);
    $('form').submit();
}
</script>
</body>
</html>

