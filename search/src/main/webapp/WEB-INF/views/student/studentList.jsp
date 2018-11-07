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
<title>학생 조회 (resultMap)</title>
</head>
<body>
	<div class="container">
		<h1>학생목록</h1>
		<br>
		<div class="pull-right mb5">
			<a href="create" class="btn btn-info"> <span
				class="glyphicon glyphicon-user"></span> 학생등록
			</a>
		</div>

		<form class="form-inline" action="findByName">
			<div class="form-group">
				<label>이름</label> <input type="text" class="form-contrl"
					name="srchText" value="${srchText}" placeholder="검색조건" />
			</div>
			<button type="submit" class="btn btn-primary">조회</button>
		</form>

		<table class="table table-bordered mt5">
			<thead>
				<tr>
					<th>id</th>
					<th>학번</th>
					<th>이름</th>
					<th>학년</th>
					<th>학과id</th>
					<th>학과</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${ students }">
					<tr data-url="edit?id=${ student.id }">
						<td>${ student.id }</td>
						<td>${ student.studentNumber }</td>
						<td>${ student.name }</td>
						<td>${ student.year }</td>
						<td>${ student.department.id }</td>
						<td>${ student.department.departmentName }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>