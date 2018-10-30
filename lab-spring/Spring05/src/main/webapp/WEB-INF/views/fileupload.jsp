<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js">
</script>
</head>
<body>

<h1>파일 업로드</h1>
<h2>단일 파일 업로드</h2>
<form action="fileupload" method="post"
    enctype="multipart/form-data">
    <input type="file" name="uploadFile" placeholder="파일 선택" />
    <input type="submit" value="파일 업로드" />
</form>

<hr/>
<h2>다중 파일 업로드</h2>
<form action="fileupload2" method="post" 
    enctype="multipart/form-data">
    <input type="file" name="uploadFiles" 
        placeholder="파일 선택" multiple />
    <input type="submit" value="파일 업로드" />
</form>

<script>
$(document).ready(function() {
	if (${not empty result}) {
		alert('${result} 파일 저장 성공');
	}
	
});
</script>

</body>
</html>






