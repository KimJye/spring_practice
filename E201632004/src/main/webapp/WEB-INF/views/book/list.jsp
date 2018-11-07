<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="R" value="/" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${R}res/common.js"></script>
<link rel="stylesheet" href="${R}res/common.css">
<title>책 목록</title>
</head>
<body>
	<div class="container">
		<h1>책 목록</h1>
		<br>
		<div class="pull-right mb5">
			<a href="create" class="btn btn-info"> <span
				class="glyphicon glyphicon-user"></span> 책등록
			</a>
		</div>

		<form class="form-inline" action="findByTitle">
			<div class="form-group">
				<label>책제목</label> <input type="text" class="form-contrl"
					name="srchText" value="${srchText}" placeholder="검색조건" />
			</div>
			<button type="submit" class="btn btn-primary">조회</button>
		</form>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>제목</th>
					<th>작가</th>
					<th>카테고리명</th>
					<th>가격</th>
					<th>출판사명</th>
					<th>대여가능</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${ books }">
					<tr data-url="edit?id=${ book.id }">
						<td>${  book.id }</td>
						<td>${  book.title }</td>
						<td>${  book.author }</td>
						<td>${ book.categoryName }</td>
						<td>${ book.price }</td>
						<td>${ book.publisherName }</td>
						<td>${book.available }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>