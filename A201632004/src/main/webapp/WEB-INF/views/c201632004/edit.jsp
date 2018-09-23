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
  <h1>교수 ${ professor.id > 0 ? "수정" : "등록" }</h1>
  <hr />
  <form:form method="post" modelAttribute="professor">  
    
    <div class="form-group">
      <label>이름:</label>
      <form:input path="ProfessorName" class="form-control w200" />
    </div>
    <div class="form-group">
      <label>학과</label>
      <form:select path="departmentId" class="form-control w200"
                   itemValue="id" itemLabel="departmentName" items="${ departments }" />
    </div>
    
    <hr />
    <div>
      <a href="list1" class="btn btn-info">목록으로</a>
    </div>
  </form:form>
</div>
</body>
</html>
