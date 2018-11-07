<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
        rel="stylesheet" media="screen">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="${R}res/common.js"></script>
  <link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
<div class="container">
  <h1>학생 ${ student.id > 0 ? "수정" : "등록" }</h1>
  <hr />
  <form:form method="post" modelAttribute="student">  
    <div class="form-group">
      <label>학번:</label>
      <form:input path="studentNumber" class="form-control w200" />
    </div>
    <div class="form-group">
      <label>이름:</label>
      <form:input path="name" class="form-control w200" />
    </div>
    <div class="form-group">
      <label>학과</label>
      <form:select path="departmentId" class="form-control w200"
                   itemValue="id" itemLabel="departmentName" items="${ departments }" />
    </div>
    <div class="form-group">
      <label>학년:</label>
      <form:input path="year" class="form-control w200" />
    </div>
    <hr />
    <div>
      <button type="submit" class="btn btn-primary">
        <span class="glyphicon glyphicon-ok"></span> 저장</button>
      <c:if test="${ student.id > 0 }">
        <a href="delete?id=${ student.id }" class="btn btn-danger" data-confirm-delete>
          <i class="glyphicon glyphicon-remove"></i> 삭제</a>
      </c:if>
      <a href="list" class="btn btn-info">목록으로</a>
    </div>
  </form:form>
</div>
</body>
</html>
