<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>보내는 사람 목록</h1>
		
		<table id="articies" class="table table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>이름</th>
					<th>직책</th>
					<th>도시</th>
					<th>웹주소</th>
					<th>메모</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="shippers" items="${list }">
					<tr>
						<td>${shippers.id }</td>
						<td>${shippers.lastName}, ${shippers.firstName }</td>
						<td>${shippers.jobTitle }</td>
						<td>${shippers.city}</td>
						<td>${shippers.webPage }</td>
						<td>${shippers.notes }</td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>