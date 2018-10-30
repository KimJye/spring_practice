<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="euc-kr"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="myChatbot.Client" %>
<% 
	//한글 깨짐 처리를 위해 인코딩 구문
	request.setCharacterEncoding("UTF-8");

	//글 삭제(del), 글 등록(insert) 이벤트를 한 jsp파일에서 처리하기 위해 type 파라미터를 받음
	String message = (String)request.getParameter("message");
	String messageHistory = (String)request.getParameter("messageHistory");
	String userName = (String)request.getParameter("user");
	
	if(messageHistory == null) {
		messageHistory = "";
	}
	
	char nullChar = (char) 0;
    String botName = "SUZY"; // or take as input
    
    //Client client = new Client();
    //Client.init(null);
    String rMessage = Client.doMessage(userName+nullChar+nullChar+message+nullChar);
    //String rMessage = Client.doMessage(nullChar+"1"+nullChar+nullChar);
    //String rMessage = Client.doMessage(userName+"1"+nullChar+message+nullChar);

    message = "\n[" + userName + "]" + message;
    rMessage = "\n[" + botName + "]" + rMessage;
    
    
%>
<%=messageHistory+""+message+""+rMessage%>

	