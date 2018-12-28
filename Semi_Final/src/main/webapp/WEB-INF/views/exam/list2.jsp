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
		<h1>주문 목록</h1>
		
		<table id="articies" class="table table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>제품명</th>
					<th>카테고리</th>
					<th>수량</th>
					<th>단가</th>
					<th>주문날짜</th>
					<th>고객</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="orderDetail" items="${list }">
					<tr>
						<td>${orderDetail.id }</td>
						<td>${orderDetail.products.productName}</td>
						<td>${orderDetail.products.category }</td>
						<td>${orderDetail.quantity }</td>
						<td>${orderDetail.unitPrice }</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${orderDetail.orders.orderDate }"/></td>
					<td>${orderDetail.orders.customers.lastName },${orderDetail.orders.customers.firstName }</td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>