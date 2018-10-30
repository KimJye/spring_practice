<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">

<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>


<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>My Chatbot</title>
		
		<!-- �������� ���� ��Ÿ�Ͻ�Ʈ ���� ���� //-->
		<style type="text/css">
			.bgcolor1{background-color:#3b5998}
			.bgcolor2{background-color:#eceff5}	
			.bgcolor3{background-color:#dd3c10}
			.inputPic{padding-right:5px}.fcb{color:#000}
			.composerInput{height:30px;width:300px;margin-bottom:7px}
			.mfsxs{font-size:x-small}
			.mfsxs:hover{background-color:#3b5998;color:#fff}
		</style>
		<!-- �������� ���� ��Ÿ�Ͻ�Ʈ ���� ���� //-->
		
		<!-- html������ �� �̺�Ʈ ó���� ���� �ڹٽ�ũ��Ʈ ���� ���� //-->
		<!-- ajax �Լ��� ����ϱ� ���� httpRequest.js ��ũ //-->
		<script type="text/javascript" src="js/httpRequest.js"></script> 
		<script type="text/javascript">
	
			//�ű� ���� ����ϱ� ���� ȣ���ϴ� �Լ�(������ ���� �� �ۼ���, �̹��� ��θ� �Ķ���ͷ� ����)
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
			
			//ajax�Լ� ȣ�� ��(sendRequest) ó�� �� �� ����� reply ������ ����ϱ� ���� ó���ϴ� �Լ�
			//control.jsp ������ ���� ����Ʈ�� ����ϱ� ���� while()������ �ۼ��Ǿ� ����. �̶� �ۼ��� html�� innerHTML�Ӽ��� ���� reply������ ǥ�õ�
			//�̷��� ó�������� ������ ȭ���� reload ���� �ʰ�, ó���� �����Ͽ� ���ʿ��� request �� ȭ�� drawing�� �ٿ��ش�.(ajax����)
			function reply(){
				var reply = document.getElementById("messageResult");
				if(httpRequest.readyState==4){
					if(httpRequest.status == 200){    
						//innerHTML���� responseText�� ������
						//�ʱ� Load �� Textarea�� ã�� javascript ������ �����ϱ� ���� text�� ������
						var responseText = httpRequest.responseText;
						reply.value = responseText.trim();
					}
				}
				//Textarea�� Focus�� �� �ϴ����� �̵���Ų �� Message�� Focus �̵�ó��
				document.form1.messageResult.focus();
				document.form1.message.focus();
        	}
			//�ʱ� ȣ�� �� Chat �̷�ó���� ���� hidden ��
			//function init() {
			//	document.form1.hidden1.value = "first";
			//	var message = "Hello";
			//	sendRequest("control.jsp","message="+message, reply , "POST");
			//	document.form1.hidden1.value = "executed";
			//}
		</script>
		<!-- html������ �� �̺�Ʈ ó���� ���� �ڹٽ�ũ��Ʈ ���� ���� //-->
		  
	</head>

	<body tabindex="0">
		<div class="bgcolor1">
			<table cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<!-- ������ ����� ���� ����Ʈ�� ������ �ۼ��ϴ� ����, �̹����� ��ü�ص� ���� //-->
					<td valign="top"><font color="#FFFFFF">Chatbot</font><p></td>
				</tr>
			</table>
		</div>
		<form name="form1" method="post" action="javascript:chat()" enctype="mutipart/form-data">
		<input type="hidden" name="hidden1"></input>
		<div class="bgcolor2">
			<!-- �űԱ��� ����ϱ� ���� ������ form ���� ���� //-->
			<!-- form ������ ���� server-side script(ex:asp,jsp,php ��)�� ������ ó���� �������� //-->
			<!-- ���� action �������� ������ �������� �ۼ�������, ajaxó���� ���� action�� ��δ� sendRequest() �Լ� ȣ�� �� ���ǵ� //-->
		
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
						
						<!-- DB���� ������ ���� ȭ�鿡 ǥ���ϱ� ���� html�� �ۼ� //-->
						<span></span><br>
						<textarea id="messageResult" name="messageResult" height="2000" rows="20" cols="45" data-sigil="textarea">
						</textarea>
					</td>
				</tr>
			</table>
	<hr>
			
			<!-- �űԱ��� ����ϱ� ���� ������ form ���� ���� //-->
		</div>		
		
		
		</form>
	</body>
</html>
						
	