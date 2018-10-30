<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>

<h1>상품 등록 페이지</h1>
<form action="product" method="post">
    <input type="number" name="pid" placeholder="상품 아이디" />
    <br/>
    <input type="text" name="pname" placeholder="상품 이름" />
    <br/>
    <input type="number" name="price" placeholder="상품 가격" />
    <br/>
    <input type="submit" value="상품 등록" />
</form>

</body>








</html>