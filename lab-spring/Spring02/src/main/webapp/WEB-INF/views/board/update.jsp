<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"
    uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js">
</script>
</head>
<body>

<h1>게시글 수정 페이지</h1>

<ul>
    <li><a href="list">메인으로</a></li>
    <li><a id="btn-delete">삭제하기</a></li>
</ul>

<form action="update" method="post">
    <label for="bno">번호</label><br/>
    <input type="number" name="bno" id="bno" 
        value="${board.bno}" readonly />
    <br/>
    <label for="title">제목</label><br/>
    <input type="text" name="title" id="title"
        value="${board.title}" />
    <br/>
    <label for="content">본문</label><br/>
    <textarea rows="5" cols="40" name="content" id="content">${board.content}</textarea>
    <br/>
    <label for="userid">작성자</label><br/>
    <input type="text" name="userid" id="userid"
        value="${board.userid}" readonly />
    <br/>
    <label for="regdate">작성 시간</label><br/>
    <fmt:formatDate value="${board.regdate}" var="regdate"
        pattern="yyyy/MM/dd HH:mm:ss" />
    <input type="text" id="regdate" value="${regdate}" readonly />
    <br/>
    <input type="submit" value="수정 완료" />
</form>

<script>
$(document).ready(function() {
	$('#btn-delete').click(function() {
		var result = confirm('정말 삭제하시겠습니까?');
		if (result) {
			location = 'delete?bno=${board.bno}';
		}
	});
});
</script>

</body>
</html>






