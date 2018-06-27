<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.springbook.biz.board.impl.BoardDAO" %>
    <%@page import="com.springbook.biz.board.BoardVO" %>
    <%
    	//1.사용자 입력 정보 추출
    	request.setCharacterEncoding("UTF-8");
    	String title= request.getParameter("title");
    	String writer=request.getParameter("writer");
    	String content = request.getParameter("content");
    	
    	//2.DB 연동 처리
    	BoardVO vo = new BoardVO();
    	vo.setTitle(title);
    	vo.setWriter(writer);
    	vo.setContent(content);
    	
    	BoardDAO boardDAO = new BoardDAO();
    	boardDAO.insertBoard(vo);
    	
    	//3.화면 네비게이션
    	response.sendRedirect("getBoardList.jsp");
    
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>