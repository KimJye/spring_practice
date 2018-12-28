<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>

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

</head>
<body>
	<div class="container">
		<h1>학생 목록</h1>
		<table id="articies" class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>학번</th>
					<th>이름</th>
					<th>학과</th>
					<th>학년</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="student" items="${list }">
					<tr>
						<td>${student.id }</td>
						<td>${student.studentNo }</td>
						<td>${student.name }</td>
						<td>${student.department.name }</td>
						<td>${student.year }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<my:pagination pageSize="${ pagination.sz }"
			recordCount="${ pagination.recordCount }" queryStringName="pg" />

	</div>
</body>
</html>