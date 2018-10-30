<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018-07-31
  Time: 오후 6:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>상품 등록 페이지</h1>
<form action="product" method="post">
    <input type="number" name="id" placeholder="상품 아이디" />
    <br/>
    <input type="text" name="name" placeholder="상품 이름" />
    <br/>
    <input type="submit" value="상품 등록" />
</form>

</body>
</html>
