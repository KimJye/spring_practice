<title>spring boot app 실행</title>
</head>
<body>
<h1>안녕하세요</h1>
<h3>${message }</h3>
<p>서버에 war파일 올릴때는 포트번호별로 톰캣이 올라가기 때문에 메모리 낭비가 심할 수 있다.
따라서 서버에 올릴때는 보통 프로젝트 한개를 올린다. 내장된 톰캣이다. 내장된 톰캣에서 실행할때는 contextPath를 적어주지 않는다.</p>
<p>tomcat 서버에서 올릴때는 프로젝트 여러개를 올리고 싶을때 한다. 내장된 톰캣이 아니니까 url에 contextPath를 적어준다.</p>
<p>WEB-INF 폴더의 특징 : 외부에 노출하지 않을 것들을 모아놓는다. 대표적으로는 설정파일들,라이브러리가 있다.</p>
<p>우리가 views폴더는  컨트롤러 다음에 실행되고 스프링 내부에서 실행된다. 따라서 url을 통해 실행되는것은 컨트롤러의 actionMethod다.</p>
<p>Wepapp폴더 밑에 있는 파일들은 외부에 노출하겠다는 것이다. 이미지파일 같은 값을 넣는다. url을 적어주면 웹브라우저에서 바로 접근이 가능하다.
 정적 파일을 src/main/resources/static에 넣어야 한다.</p>
<h3><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${now }"/></h3>

