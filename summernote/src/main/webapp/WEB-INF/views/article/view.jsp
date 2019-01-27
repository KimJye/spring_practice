<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<c:url var="R" value="/"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${R}res/common.js"></script>
    <link rel="stylesheet" href="${R}res/common.css">
    <style>
        div#info span:nth-child(odd) {
            color: #aaa;
        }

        div#info span:nth-child(even) {
            margin-right: 40px;
        }

        div#body {
            min-height: 500px;
        }

        div#buttons {
            min-height: 100px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>${ article.board.boardName }</h1>
    <hr/>
    <h3>${ article.title }</h3>
    <hr/>
    <div id="info">
        <span>no:</span> <span>${ article.no }</span> <span>글쓴이:</span> <span>${ article.user.name }</span>
        <span>글쓴시각:</span> <span><fmt:formatDate
            pattern="yyyy-MM-dd HH:mm:ss" value="${ article.writeTime }"/></span>
    </div>
    <hr/>
    <div id="body">${ article.body }</div>
    <hr/>
    <div id="buttons">
        <a class="btn btn-primary" href="edit?id=${ article.id }&${ pagination.queryString }">
            <i class="glyphicon glyphicon-pencil"></i> 수정
        </a>
        <a class="btn btn-danger" href="delete?id=${ article.id }&${ pagination.queryString }" data-confirm-delete> <i
                class="glyphicon glyphicon-remove"></i> 삭제
        </a>
        <a class="btn btn-default" href="list?${ pagination.queryString }">
            <i class="glyphicon glyphicon-list"></i> 목록으로
        </a>
    </div>
</div>
</body>
</html>
