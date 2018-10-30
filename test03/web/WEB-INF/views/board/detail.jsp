<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"
    uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js">
    </script>
</head>
<body>

<h1>게시글 상세 보기</h1>

<ul>
    <li><a href="update?bno=${board.bno}">수정하기</a></li>
    <li><a href="list">메인으로</a></li>
</ul>

<form>
    <label for="bno">번호</label><br/>
    <input type="number" name="bno" id="bno" 
        value="${board.bno}" readonly />
    <br/>
    <label for="title">제목</label><br/>
    <input type="text" name="title" id="title"
        value="${board.title}" readonly />
    <br/>
    <label for="content">본문</label><br/>
    <textarea rows="5" cols="40" name="content" id="content"
        readonly>${board.content}</textarea>
    <br/>
    <label for="userid">작성자</label><br/>
    <input type="text" name="userid" id="userid"
        value="${board.userid}" readonly />
    <br/>
</form>



<%-- 여기서부터 reply 처리 --%>

<%--먼저 간단하게 입력창 만들기--%>
<input type="text" name="rcontent" id="rcontent"
       placeholder="댓글을 입력하세요" />
<input type="text" name="replier" id="replier"
       placeholder="아이디 입력" />
<button type="button" id="btn-insert">댓글 입력</button>

<%--여기가 목록(조회가 끝난 데이터를 이 div에 붙여줄 것)--%>
<hr/>
<h2>댓글 목록</h2>
<div id="replies"></div>


</body>

<script>
    // $(document).ready(function() ---- html의 로드가 끝나면 function을 실행하게끔 하는 코드
    // 여기도 단순히 3개의 function만 구현(getAllReplies - 조회, btn-inssert 클릭 - 생성, replies - 삭제)
    $(document).ready(function() {
        // 검색할 댓글의 게시글 번호
        var bno = $('#bno').val();

        // jQuery를 사용해서 AJAX 요청을 보내는 함수들 중에서
        // $.getJSON(url, data, callback)
        // 해당 url로 HTTP GET 방식의 ajax 요청을 보내고,
        // JSON 객체를 로드하는 함수
        // url (필수): 서버로 요청을 보내는 주소
        // data (선택): 요청과 함께 서버로 보내는 데이터. 생략 가능.
        // callback (선택): 응답을 받았을 때 처리할 일을 정의하는 콜백 함수

        // 조회
        function getAllReplies() {
            $.getJSON('/replies/all/' + bno, function(data) {
                // 매개변수 data: Ajax 요청에 대한 응답으로 온 데이터
                console.log('댓글 갯수: ' + data.length);

                // 통신에 성공하면 data는 댓글 리스트를 포함
                // replyList 변수에 이 리스트의 변수 하나하나를 이용하여 html 코드를 직접 만들어줌
                // each가 하나의 reply 데이터를 이용하여 html코드를 만들고
                // 또 다음 reply 데이터를 이용하여 html코드를 만들고, reply 데이터가 떨어질때까지 반복
                // 이 리스트 자체를 replyList 저장
                var replyList = '';
                $(data).each(function() {
                    replyList +=
                        '<div class="reply-item" data-rno="'
                        + this.rno
                        + '">'
                        + '<input type="hidden" id="rno" value="'
                        + this.rno
                        + '" readonly />'
                        + '<input type="text" id="rcontent" value="'
                        + this.rcontent
                        + '" />'
                        + '<input type="text" id="replier" value="'
                        + this.replier
                        + '" readonly />'
                        + '<button class="btn-delete">삭제</button>'
                        + '</div>';
                });

                // replyList 만들기가 완료되면 미리 만들어두었던 html코드에 집어넣기
                $('#replies').html(replyList);
            });
        } // end function getAllReplies()
        // function을 만드는 작업

        getAllReplies(); // 만든 후 함수 호출

        // 생성
        // btn-insert 버튼을 클릭했을 때 댓글 입력 기능
        $('#btn-insert').click(function() {
            var rcontent = $('#rcontent').val();
            var replier = $('#replier').val();
            console.log('bno = ' + bno);
            // 미리 만들어 두었던 input html 코드를 읽어서 변수에 저장

            // json을 이용한 ajax 비동기 방식 통신
            $.ajax({
                type: 'post',
                url: '/replies',
                headers: {
                    'Content-Type': 'application/json',
                    'X-HTTP-Method-Override': 'POST'
                }, // 일반설정
                data: JSON.stringify({
                    'bno': bno,
                    'rcontent': rcontent,
                    'replier': replier
                }), // 댓글 정보 json화
                success: function(result) {
                    if (result === 1) {
                        alert("댓글 입력 성공");
                        getAllReplies();
                    } else {
                        alert("댓글 입력 실패");
                    }
                } // 통신에 성공햇을 때 callback 함수 설정
                // 성공하면 result에 1이 리턴됨(Oracle)
            });
        });

        // 삭제
        // 위 insert 버튼과 형식 동일(위와 다르게 자바스크립트 on 메소드를 사용했습니다)
        $('#replies').on('click', '.reply-item .btn-delete', function() {
                var rno = $(this).prevAll('#rno').val();

                $.ajax({
                    type: 'DELETE',
                    url: '/replies/' + rno,
                    headers: {
                        'Content-Type': 'application/json',
                        'X-HTTP-Method-Override': 'DELETE'
                    },
                    success: function(result) {
                        if (result === 'success') {
                            alert('댓글 삭제 성공');
                            getAllReplies();
                        } else {
                            alert('댓글 삭제 실패');
                        }
                    }
                });
            });

    });
</script>

</html>






