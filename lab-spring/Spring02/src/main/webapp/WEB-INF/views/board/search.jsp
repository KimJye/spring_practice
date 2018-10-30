<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
    uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>

<h1>검색 결과 페이지</h1>

<ul>
    <li><a href="register">새 글 작성</a></li>
</ul>

<hr/>

<form action="search" method="get">
    <select name="searchType">
        <option value="1">작성자</option>
        <option value="2">제목</option>
        <option value="3">제목 + 내용</option>
    </select>
    <input type="text" name="searchKeyword" placeholder="검색어" />
    <input type="submit" value="검색" />
</form>

<table>
    <thead>
        <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>수정시간</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="board" items="${boardList}">
            <tr>
                <td>${board.bno}</td>
                <td>
                    <a href="detail?bno=${board.bno}">${board.title}</a>
                </td>
                <td>${board.userid}</td>
                <td>
                    <fmt:formatDate var="regdate" 
                        value="${board.regdate}"
                        pattern="yyyy/MM/dd HH:mm:ss"/>
                    ${regdate}
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>




