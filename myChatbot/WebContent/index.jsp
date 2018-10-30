<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">

<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>


<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>My Chatbot</title>
		
		<!-- 디자인을 위한 스타일쉬트 영역 시작 //-->
		<style type="text/css">
			.bgcolor1{background-color:#3b5998}
			.bgcolor2{background-color:#eceff5}	
			.bgcolor3{background-color:#dd3c10}
			.inputPic{padding-right:5px}.fcb{color:#000}
			.composerInput{height:30px;width:300px;margin-bottom:7px}
			.mfsxs{font-size:x-small}
			.mfsxs:hover{background-color:#3b5998;color:#fff}
		</style>
		<!-- 디자인을 위한 스타일쉬트 영역 종료 //-->
		
		<!-- html페이지 내 이벤트 처리를 위한 자바스크립트 영역 시작 //-->
		<!-- ajax 함수를 사용하기 위해 httpRequest.js 링크 //-->
		<script type="text/javascript" src="js/httpRequest.js"></script> 
		<script type="text/javascript">
	
			//신규 글을 등록하기 위해 호출하는 함수(컨텐츠 내용 및 작성자, 이미지 경로를 파라미터로 받음)
			function chat(){  
	//			var hidden1 = document.form1.hidden1.value;
	//			if (hidden1 == "first") {
	//				var message = document.form1.message.value;
	//				sendRequest("control.jsp","message="+message, reply , "POST");
	//				document.form1.hidden1.value = "executed";
	//			} else {
					var message = document.form1.message.value;
					var messageHistory = document.form1.messageResult.value;
					var user = document.form1.user.value;
					sendRequest("control.jsp","message="+message+"&messageHistory="+messageHistory+"&user="+user, reply , "POST");
					document.form1.message.value = "";
					//var temp = document.form1.messageResult.value;
					//document.form1.messageResult.value = '';document.form1.messageResult.value=temp;
					
	//			}
			}
			
			//ajax함수 호출 후(sendRequest) 처리 후 글 목록을 reply 영역에 출력하기 위해 처리하는 함수
			//control.jsp 로직을 보면 리스트를 출력하기 위해 while()구문이 작성되어 있음. 이때 작성된 html이 innerHTML속성을 통해 reply영역에 표시됨
			//이러한 처리로직의 장점은 화면을 reload 하지 않고, 처리가 가능하여 불필요한 request 및 화면 drawing을 줄여준다.(ajax장점)
			function reply(){
				var reply = document.getElementById("messageResult");
				if(httpRequest.readyState==4){
					if(httpRequest.status == 200){    
						//innerHTML에서 responseText로 변경함
						//초기 Load 시 Textarea를 찾는 javascript 오류를 방지하기 위해 text로 변경함
						var responseText = httpRequest.responseText;
						reply.value = responseText.trim();
					}
				}
				//Textarea의 Focus를 맨 하단으로 이동시킨 후 Message로 Focus 이동처리
				document.form1.messageResult.focus();
				document.form1.message.focus();
        	}
			//초기 호출 시 Chat 이력처리를 위한 hidden 값
			//function init() {
			//	document.form1.hidden1.value = "first";
			//	var message = "Hello";
			//	sendRequest("control.jsp","message="+message, reply , "POST");
			//	document.form1.hidden1.value = "executed";
			//}
		</script>
		<!-- html페이지 내 이벤트 처리를 위한 자바스크립트 영역 종료 //-->
		  
	</head>

	<body tabindex="0">
		<div class="bgcolor1">
			<table cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<!-- 본인이 만들고 싶은 사이트의 제목을 작성하는 영역, 이미지로 대체해도 좋음 //-->
					<td valign="top"><font color="#FFFFFF">Chatbot</font><p></td>
				</tr>
			</table>
		</div>
		<form name="form1" method="post" action="javascript:chat()" enctype="mutipart/form-data">
		<input type="hidden" name="hidden1"></input>
		<div class="bgcolor2">
			<!-- 신규글을 등록하기 위해 만들어둔 form 영역 시작 //-->
			<!-- form 구문을 통해 server-side script(ex:asp,jsp,php 등)와 데이터 처리가 가능해짐 //-->
			<!-- 원래 action 구문에는 전송할 페이지가 작성되지만, ajax처리를 위해 action의 경로는 sendRequest() 함수 호출 시 정의됨 //-->
		
			<table cellspacing="0" cellpadding="0" class="comboInput">
				<tr> 
					<td class="inputPic">User : </td>
					<td class="inputPic">
						<input type="text" class="inputPic composerInput" id="composerInput2" name="user" data-sigil="textarea"><br>
					</td>
				</tr>
				<tr> 
					<td class="inputPic">Message : </td>
					<td class="inputPic">
						<input type="text" class="inputPic composerInput" id="composerInput1" name="message" data-sigil="textarea"><br>
					</td>
				</tr>
				<tr>
					<td class="inputPic">&nbsp;</td>
					<td class="inputPic">
						<input value="Send Message" type="submit" name="Send">
					</td>
				</tr>
				<tr>
					<td class="inputPic">Chat :</td>
					<td>	
						
						<!-- DB에서 가져온 글을 화면에 표시하기 위해 html로 작성 //-->
						<span></span><br>
						<textarea id="messageResult" name="messageResult" height="2000" rows="20" cols="45" data-sigil="textarea">
						</textarea>
					</td>
				</tr>
			</table>
	<hr>
			
			<!-- 신규글을 등록하기 위해 만들어둔 form 영역 종료 //-->
		</div>		
		
		
		</form>
	</body>
</html>
						
	