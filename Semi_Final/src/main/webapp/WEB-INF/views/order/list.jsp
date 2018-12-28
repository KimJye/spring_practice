<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
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
		<h1>주문 목록</h1>
		<div class="pull-right mb5">
			<a href="create" class="btn btn-info"> 
			<span
				class="glyphicon glyphicon-user">
			</span> 주문등록
			</a>
		</div>
		<form:form method="get" modelAttribute="search" class="form-inline mb5">
			
			<form:select path="sb" class="form-control" itemValue="value"
				itemLabel="label" items="${searchBy }"/>
			<form:input path="st" class="form-control" placeholder="검색문자열"/>
			<button type="submit" class="btn btn-default">
				<i class="glyphicon glyphicon-search"></i> 검색
			</button>
			<div class="pull-right">
				<span>페이지 크기:</span>
				<form:select path="sz" class="form-control autosubmit">
					<form:option value="10" />
					<form:option value="15" />
					<form:option value="30" />
				</form:select>
			</div>
			<c:if test="${ search.sb > 0}">
				<a class="btn btn-default" href="list?pg=1"> 
				<i
					class="glyphicon glyphicon-ban-circle"></i> 검색취소
				</a>
			</c:if>
		</form:form>
		<table id="articies" class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>직원이름</th>
					<th>고객이름</th>
					<th>주문 날짜</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="order" items="${list }">
					<tr data-url="view?id=${order.id}&${ search.queryString }">
						<td>${order.id }</td>
						<td>${order.employees.lastName }</td>
						<td>${order.customers.lastName }</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${order.orderDate }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
<my:pagination pageSize="${ search.sz }"
			recordCount="${ search.recordCount }" queryStringName="pg" />
	</div>
</body>
</html>