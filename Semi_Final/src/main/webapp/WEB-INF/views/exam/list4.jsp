<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="R" value="/" />
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
</head>
<body>
	<div class="container">
		<h1>직원 목록</h1>
		<form:form method="get" modelAttribute="search"
			class="form-inline mb5">
			도시:<form:select path="sb" class="form-control ml20" itemValue="value"
				itemLabel="label" items="${searchBy }"/>
			<button type="submit" class="btn btn-primary">
				조회
			</button>
		</form:form>
		<table id="articies" class="table table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>이름</th>
					<th>이메일</th>
					<th>직위</th>
					<th>전화</th>
					<th>도시</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="employee" items="${list }">
					<tr>
						<td>${employee.id }</td>
						<td>${employee.lastName },${employee.firstName }</td>
						<td>${employee.emailAddress }</td>
						<td>${employee.jobTitle }</td>
						<td>${employee.businessPhone }</td>
						<td>${employee.city }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>