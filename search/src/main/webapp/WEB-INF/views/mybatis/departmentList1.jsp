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
<title>학과별 학생 조회</title>
</head>
<body>
	<div class="container">
		<h1>학과별 학생 목록</h1>
		<hr />
		<c:forEach var="department" items="${ departments }">
			<h3>${ department.departmentName }
				<small>${ department.students.size() }명</small>
			</h3>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>id</th>
						<th>학번</th>
						<th>이름</th>
						<th>학년</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${ department.students }">
						<tr>
							<td>${ student.id }</td>
							<td>${ student.studentNumber }</td>
							<td>${ student.name }</td>
							<td>${ student.year }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:forEach>
	</div>

</body>
</html>