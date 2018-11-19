<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="css/page.css">
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript">
	//신규 글을 등록하기 위해 호출하는 함수(컨텐츠 내용 및 작성자, 이미지 경로를 파라미터로 받음)
	function chat() {
		var hidden1 = document.form1.hidden1.value;
		if (hidden1 == "first") {
			var message = document.form1.message.value;
			sendRequest("control.jsp", "message=" + message, reply, "POST");
			document.form1.hidden1.value = "executed";
		} else {
			var message = document.form1.message.value;
			var messageHistory = document.form1.messageResult.value;
			sendRequest("control.jsp", "message=" + message
					+ "&messageHistory=" + messageHistory, reply, "POST");
		}
	}

	//ajax함수 호출 후(sendRequest) 처리 후 글 목록을 reply 영역에 출력하기 위해 처리하는 함수
	//control.jsp 로직을 보면 리스트를 출력하기 위해 while()구문이 작성되어 있음. 이때 작성된 html이 innerHTML속성을 통해 reply영역에 표시됨
	//이러한 처리로직의 장점은 화면을 reload 하지 않고, 처리가 가능하여 불필요한 request 및 화면 drawing을 줄여준다.(ajax장점)
	function reply() {
		var reply = document.getElementById("reply");
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				reply.innerHTML = httpRequest.responseText;
			}
		}
	}
	//초기 호출 시 Chat 이력처리를 위한 hidden 값
	function init() {
		document.form1.hidden1.value = "first";
	}
</script>
<!-- html페이지 내 이벤트 처리를 위한 자바스크립트 영역 종료 //-->
<title>Insert title here</title>
</head>
<body tabindex="0" onload="init()">
<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-default fixed-top">
		<div class="container">
			<a class="navbar-brand" href="home.jsp">티티</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="home.jsp">Home <span class="sr-only">(current)</span>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div id="jb-container">
		<div id="header">
			<div id="jb-sidebar">
				<form name="form1" method="post" action="javascript:chat()"
					enctype="mutipart/form-data">
					<input type="hidden" name="hidden1"></input>
					<!-- project_notice 데이타 출력 시작 - 테이블의 데이타가 출력되는 영역 - ajax 함수를 사용하여  reply 영역에 html을 삽입함(처리로직은 control.jsp 참조) //-->
					<div id="reply"></div>
					<!-- project_notice 데이타 출력 종료 //-->
					<table cellspacing="0" cellpadding="0" class="comboInput">
							<tr>
								<td class="inputPic">
									<input type="text" class="inputPic composerInput" id="composerInput" name="message" data-sigil="textarea"
										style="float: left; margin-right: 30px; height: 30px; margin-left: 20px; width: 100px; border: none">
									<input value="전송하기" type="submit" name="Send" onclick="javascript:chsat()"
										style="float: right; height: 33px; background-color: #858a91; color:white; font-weight: bold">
								</td>
							</tr>
						</table>
				</form>
			</div>
			<div id="jb-content">
				<div align="center" style="margin-bottom: 50px;">
					<table>
						<tr>
							<td width="200" height="240"> <img src="img/성동구.jpg" width="180px" height="220px"/> </td>
							<td width="200" height="240"> <img src="img/용산구.jpg" width="180px" height="220px"/> </td>
							<td width="200" height="240"> <img src="img/구로구.jpg" width="180px" height="220px"/> </td>
							<td width="200" height="240"> <img src="img/동대문구.jpg" width="180px" height="220px"/> </td>
						</tr>
						<tr style="font-size: 15px;">
							<td height="50"> [맛집리뷰] 성동구 맛집!! </td>
							<td height="50"> [맛집리뷰] 용산구 맛집!!</td>
							<td height="50"> [맛집리뷰] 구로구 맛집!! </td>
							<td height="50"> [맛집리뷰] 동대문구 맛집!! </td>
						</tr>
						<tr><td><br/><br/></td></tr>
						<tr>
							<td width="200" height="240"> <img src="img/마포구여행.jpg" width="180px" height="220px"/> </td>
							<td width="200" height="240"> <img src="img/구로구여행.jpg" width="180px" height="220px"/> </td>
							<td width="200" height="240"> <img src="img/광진구여행.jpg" width="180px" height="220px"/> </td>
							<td width="200" height="240"> <img src="img/강남구여행.jpg" width="180px" height="220px"/> </td>
						</tr>
						<tr style="font-size: 15px;">
							<td height="50"> [여행리뷰] 마포구 여행~ </td>
							<td height="50"> [여행리뷰] 구로구 여행~ </td>
							<td height="50"> [여행리뷰] 광진구 여행~ </td>
							<td height="50"> [여행리뷰] 강남구 여행~ </td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>