<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" modelAttribute="user">
		<div class="form-group">
			<label for="userId">아이디</label> <input type="text" name="userId"
				class="form-control" placeholder="학번을 입력해주세요"
				style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="departmentName">학과</label> <input type="text"
				name="departmentName" class="form-control" placeholder="학번을 입력해주세요"
				style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="name">이름</label> <input type="text" name="userName"
				class="form-control" placeholder="이름을 입력해주세요"
				style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="gender">성별</label> <input type="text" name="gender"
				class="form-control" placeholder="성별을 입력해주세요"
				style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="grade">학년</label> <input type="text" name="grade"
				class="form-control" placeholder="학년을 입력해주세요"
				style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="email">이메일</label> <input type="email" name="email"
				class="form-control" style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="phone">전화번호</label> <input type="text" name="phone"
				class="form-control" style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label> <input type="password"
				name="password" class="form-control"
				style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group"
			style="margin-top: 10px; margin-left: 31%; width: 120px;">
			<button type="submit"
				class="btn btn-primary btn-ji btn-block join-button">회원가입</button>
		</div>
	</form>
</body>
</html>