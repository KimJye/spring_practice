<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"
    uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>

<h1>게시글 상세 보기</h1>

<ul>
    <li><a href="update?bno=${board.bno}">수정하기</a></li>
    <li><a href="list">메인으로</a></li>
</ul>

<form>
    <label for="bno">번호</label><br/>
    <input type="number" name="bno" id="bno" 
        value="${board.bno}" readonly />
    <br/>
    <label for="title">제목</label><br/>
    <input type="text" name="title" id="title"
        value="${board.title}" readonly />
    <br/>
    <label for="content">본문</label><br/>
    <textarea rows="5" cols="40" name="content" id="content"
        readonly>${board.content}</textarea>
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
</form>

</body>
</html>






