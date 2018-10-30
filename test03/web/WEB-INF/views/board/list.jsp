<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

    <style>
        .pagination li {
            display: inline-block;
        }
    </style>

</head>
<body>

<h1>게시판 메인 페이지</h1>

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
        </tr>
    </c:forEach>
    </tbody>
</table>

<ul class="pagination">
    <c:if test="${pageMaker.prev}">
        <!-- 이전 버튼은 (startPage - 1)로 이동 -->
        <li><a href="${pageMaker.startPage - 1}">이전</a></li>
    </c:if>

    <c:forEach var="num"
               begin="${pageMaker.startPage}"
               end="${pageMaker.endPage}">
        <li><a href="${num}">${num}</a></li>
    </c:forEach>

    <c:if test="${pageMaker.next}">
        <!-- 다음 버튼은 (endPage + 1)으로 이동 -->
        <li><a href="${pageMaker.endPage + 1}">다음</a></li>
    </c:if>
</ul>

<form id="pageForm" action="list" method="get">
    <input type="hidden" id="page" name="page"
           value="${pageMaker.criteria.page}" />
    <input type="hidden" id="perPage" name="perPage"
           value="${pageMaker.criteria.numsPerPage}" />
</form>

<script>
    $(document).ready(function() {
        $('.pagination li a').click(function() {
            // <a> 태그의 기본 동작(페이지 이동)을 막아버림
            event.preventDefault();

            // 이동할 페이지
            var target = $(this).attr('href');
            $('#page').val(target);
            $('#pageForm').submit();
        });

    });
</script>

</body>
</html>




