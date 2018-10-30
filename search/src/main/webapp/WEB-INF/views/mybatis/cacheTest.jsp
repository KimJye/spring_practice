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

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>mybatis Cache Test</h1>
		<hr />
		<h3>학과목록</h3>
		<table class="table table-bordered" style="width: 500px;">
			<c:forEach var="department" items="${ departments }">
				<tr>
					<td>${ department.id }</td>
					<td>${ department.departmentName }</td>
					<td><fmt:formatDate pattern="HH:mm:ss"
							value="${ department.time }" /></td>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-info" href="cacheTest">새로고침</a>
		<hr />
		<h3>학과명 수정</h3>
		<form:form modelAttribute="department" method="post">
			<form:hidden path="id" />
			<form:input path="departmentName" class="form-control" />
			<br />
			<button type="submit" class="btn btn-info">저장</button>
		</form:form>
		
	<hr/>
	<h3>사용자목록</h3>
	<table class="table table-bordered" style="width:500px;">
		<c:forEach var="student" items="${students }">
			<tr>
				<td>${student.id }</td>
				<td>${student.studentNumber }</td>
				<td>${student.name }</td>
				<td>${student.departmentName }</td>
				<td><fmt:formatDate pattern="HH:mm:ss" value="${student.time }"/></td>	
			</tr>
		</c:forEach>
		</table>
	</div>

</body>
</html>