<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>MyPage</h3>
<form method="post" modelAttribute="user">
		<div class="form-group">
			<label for="userId">아이디</label> <input type="text" name="userId" value=${user.userId }
				class="form-control" placeholder="학번을 입력해주세요"
				style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="departmentName">학과</label> <input type="text" value=${user.departmentName }
				name="departmentName" class="form-control" placeholder="학번을 입력해주세요"
				style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="name">이름</label> <input type="text" name="userName" value=${user.userName }
				class="form-control" placeholder="이름을 입력해주세요"
				style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="gender">성별</label> <input type="text" name="gender" value=${user.gender }
				class="form-control" placeholder="성별을 입력해주세요"
				style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="grade">학년</label> <input type="text" name="grade" value=${user.grade }
				class="form-control" placeholder="학년을 입력해주세요"
				style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="email">이메일</label> <input type="email" name="email" value=${user.email }
				class="form-control" style="height: 37px; font-size: 13pt;" />
		</div>
		<div class="form-group">
			<label for="phone">전화번호</label> <input type="text" name="phone" value=${user.phone }
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
				class="btn btn-primary btn-ji btn-block join-button">정보 수정</button>
		</div>
	</form>
	
	<form action="mySubject_upload" method="post"
		enctype="multipart/form-data" style="margin-left: 10px">
		<div class="form-group">
			<label for="file" class="cols-sm-2 control-label">수강목록 업로드</label>
			<div class="cols-sm-10">
				<div class="input-group">
					<span class="input-group-addon">
						<i class="fa fa-file-upload fa" aria-hidden="true"
							style="margin-top: 10px;">
						</i>
					</span> &nbsp;&nbsp; 
					<input type="file" name="file" style="width: 250px;" />
					<button type="submit" class="btn btn-outline-primary"
						style="font-size: 13px;">업로드</button>
				</div>
			</div>
		</div>
	</form>
	
	<a href="list">수강 목록 리스트 보기</a>
</body>
</html>