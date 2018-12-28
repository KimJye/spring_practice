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
		<h1>제품</h1>
		<hr />
		<form:form method="post" modelAttribute="productEditModel">
			<div class="form-group">
				<label>제품코드:</label>
				<form:input path="productCode" class="form-control w200" value="${product.productCode}"/>
				  <form:errors path="productCode" class="error" /> 
			</div>
			<div class="form-group">
				<label>제품명:</label>
				<form:input path="productName" class="form-control w200" value="${product.productName}"/>
				<form:errors path="productName" class="error" /> 
			</div>
			<div class="form-group">
				<label>표준가격:</label>
				<form:input path="standardCost" class="form-control w200" value="${product.standardCost}"/>
			</div>
			<div class="form-group">
				<label>표시가격:</label>
				<form:input path="listPrice" class="form-control w200" value="${product.listPrice}" />
			</div>
			<div class="form-group">
				<label>단위수량:</label>
				<form:input path="quantityPerUnit" class="form-control w200" value="${product.quantityPerUnit}"  />
			</div>
			<div class="form-group">
				<label>카테고리:</label>
				<form:input path="category" class="form-control w200" value="${product.category}"/>
			</div>
			<hr />
			<div>
				<button id="buttons">
					<span class="glyphicon glyphicon-ok"></span> 저장
				</button>
				<a href="list?${ pagination.queryString }" class="btn btn-info">목록으로</a>
			</div>
		</form:form>
	</div>
</body>
</html>
