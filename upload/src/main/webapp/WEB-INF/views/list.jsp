<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page import="net.skhu.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-left: 15%; margin-top: 5%;">
		<h3>수강 목록</h3>
	</div>
	
	<form method="post">
		<select name="option" class="form-control"
			style="display: inline; max-width:150px; margin-left:450px;">
			<option value="과목명">과목명</option>
			<option value="과목코드">과목코드</option>	
		</select>
		<input name="srchText" class="form-control"
			style="display: inline; max-width:200px;" placeholder="검색하세요" />
		<input type="submit" class="btn btn-outline-primary" value="조회하기" />
	</form>
	<div class="table-responsive"
		style="margin-left: 15%; font-size: 12pt; margin-top: 2%">
		<table class="table" style="width: 70%; margin-bottom: 100px;">
			<thead>
				<tr>
					<th>년도</th>
					<th>학기</th>
					<th>과목코드</th>
					<th>과목명</th>
					<th>이수구분</th>
					<th>학점</th>
					<th>성적등급</th>
					<th></th>
				</tr>
			</thead>

			<tbody style="font-size: 12pt;">
				<c:forEach var="mySubjectlist" items="${mySubjectlist }">
					<tr>
						<td>${mySubjectlist.takeYear }</td>
						<td>${mySubjectlist.takeSemester }</td>
						<td>${mySubjectlist.subjectCode }</td>
						<td>${mySubjectlist.subjectName }</td>
						<td>${mySubjectlist.completionDivision }</td>
						<td>${mySubjectlist.credit }</td>
						<td>${mySubjectlist.score }</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

</body>
</html>