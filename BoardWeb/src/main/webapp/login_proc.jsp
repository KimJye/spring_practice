<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import ="com.springbook.biz.user.UserVO" %>
   <%@page import ="com.springbook.biz.user.impl.UserDAO" %>
  
  <%
  	//1.사용자 입력 정보 추출
  	String id= request.getParameter("id");
  	String password = request.getParameter("password");
  	
  	//2.DB 연동 처리
  	UserVO vo = new UserVO();
  	vo.setId(id);
  	vo.setPassword(password);
  	
  	UserDAO userDAO = new UserDAO();
  	UserVO user = userDAO.getUser(vo);
  	
  	//3.화면 네비게이션
  	if(user !=null){
  		response.sendRedirect("getBoardList.jsp");
  	}else{
  		response.sendRedirect("login.jsp");
  	}
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