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
		<h1>직원 ${ employee.id > 0 ? "수정" : "등록" }</h1>
		<hr />
		<form:form method="post" modelAttribute="employee">
			<div class="form-group">
				<label>회사:</label>
				<form:input path="company" class="form-control w200" />
			</div>
			<div class="form-group">
				<label>이름:</label>
				<form:input path="lastName" class="form-control w200" />
			</div>
			<div class="form-group">
				<label>이메일 주소:</label>
				<form:input path="emailAddress" class="form-control w200" />
			</div>
			<div class="form-group">
				<label>직책:</label>
				<form:input path="jobTitle" class="form-control w200" />
			</div>
			
			<div class="form-group">
				<label>웹주소:</label>
				<form:input path="webPage" class="form-control w200" />
			</div>
			<hr />
			<div>
				<button id="buttons">
					<span class="glyphicon glyphicon-ok"></span> 저장
				</button>
				<c:if test="${ employee.id > 0 }">
					<a href="delete?id=${employee.id}" class="btn btn-danger"
						data-confirm-delete> <i class="glyphicon glyphicon-remove"></i>
						삭제
					</a>
				</c:if>
				<a href="list?${ pagination.queryString }" class="btn btn-info">목록으로</a>
			</div>
		</form:form>
	</div>
</body>
</html>
