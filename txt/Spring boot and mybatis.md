# Spring boot and mybatis

------

## 1) ORM(Object Relational Mapping)

- ORM에서 Object는 객체지향 언어의 객체
- Relational은 관계형 데이터베이스의 데이터
- Mapping은 객체지향 언어의 객체와 관계형 데이터를 서로 변환

=> 관계형 데이터베이스에서 조회한 데이터를 java객체로 변환하여 리턴해주고,

	java 객체를 관계형 데이터베이스에 저장해주는 라이브러리 혹은 기술을 말한다.

* java ORM 기술로 유명한 것은 mybatis, Hibernate, JPA이다.
* mybatis, Hibernate는 오픈소스 프로젝트이고 jar 라이브러리 형태로 제공
* JPA는 API 표준의 이름



## 2) JAP와 mybatis 비교

**JPA의 장점**

* SQL 명령을 구현할 필요가 없다. 그래서 DBMS 제품을 교체하더라도 소스코드를 수정할 필요가 없다.
* 자동으로 처리되는 부분이 많아서, 구현할 소스코드의 양이 상대적으로 적다.
* 관계형 데이터베이스가 아니더라도 적용할 수 있다.



**JAP의 단점**

* 복잡한 조회 명령을 구현해야 할때, JPA의 고급 기능을 공부해야 한다.



**mybatis의 장점**

* 익숙한 SQL 명령으로 구현할 수 있다.
* DB 조회 결과를 복잡한 객체 구조로 변환해야 할 때 myBatis 기능이 좋다.
* mybatis의 resultMap 기능이 바로 그것. 이 기능은 복잡한 보고서를 출력해야 할 때, 특히 유용
* SQL 쿼리 분석하기 편하다.



**mybatis의 단점**

* 구현할 소스코드 양이 상대적으로 많다.
* 관계형 데이터베이스에만 적용할 수 있다.
* DBMS 제품을 교체하면 SQL 소스코드를 수정해야 한다.



## 3) mybatis mapper

* SELECT/INSERT/UPDATE/DELETE SQL 명령들을 mybatis mapper에 구현한다. 

* 보통 데이터베이스 테이블 한 개당 mybatis mapper를 한 개를 구현한다. 
* mybatis mapper는 Java Interface 파일 한 개와, XML 파일 한 개로 구현된다.
* DB 테이블에 대한 조회, 삽입, 수정, 삭제 SQL 명령을 mapper XML 파일에 구현한다.
* 그리고 이 명령을 호출하기 위한 Java 메소드를 mapper Java Interface 파일에 선언한다. 
*  인터페이스를 구현한 Java 클래스를, mybatis spring이 자동으로 구현해 준다.

프로젝트의 설정, 라이버러리설치, 빌드의 자동화 도구는 gradle과 maven이 있다. gradle이 업그레이드 버전

### mapper 구현 규칙

1 . mapper 인터페이스의 이름과 패키지가 정확하기 일치해야 한다.

2 . id 애트리부트 값은 인터페이스의 메소드 이름과 일치해야 한다.

3 . DTO 클래스가 net.skhu.dto에 있는지 확인해야 해고 resultType 리턴값이 같아야 한다.

4 . 조회 결과 컬럼명 과 set 메소드 이름이 일치해야 한다. (대소문자 신경안써도 됨)



### console 탭의 에러 메세지

* jdbc driver.... => sql jdbc가 없다는 뜻. maven 다운로드가 덜 되거나 dependency 확인해볼것. pom.xml 확인
* connection.....=> db 연결이 안됨(실행 후 에러가 발생할 때까지 1~2분 정지 할때). application.properties확인 또는 db엔진이 실행여부 확인
* ~~mapper를 만들지 못했다. => 위의 mapper 구현 규칙을 확인해야 한다.



## 4) Mybatis

### mybatis 파라미터

* 파라미터 한 개일 경우 이름 일치 할 필요가 없다.
* 파라미터 여러개 일 경우 이름이 정확히 대소문자까지 일치해야 한다.(property 이름)





### auto increment 필드와 insert

* " useGeneratedKeys="true" keyProperty="id" =>  insert 하자마자 student 테이블의 id레코드의 값을 자동으로 채워줘라. insert 하자마자 조회하는 것이 아니라 insert하자마자 그 값을 리턴하는 개념이다.



## 5) 컨트롤러 구현

* Spring Web MVC : Model(class), View(file), Controller(class)

  => Jsp와 Spring, 이 둘의 차이는 분업의 차이다. 역할별로 소스코드가 잘 분리가 되어있다.

  	Mybatis를 쓰는데 JDBC는 DAO를 다 써줬는데 Spring Mybatis가 자동적으로 해준다.(Spring Data 라이브러리의 기능이다.)

  spring 장점 : 코딩량이 적다.

  	     단점 : 각종 설정...



* @Autowired : 객체를 자동으로 생성해서 이 멤버변수에 대입하라. Dependency Injection(DI)

* @RequestMapping("/student") : Http Request에 대한 Mapping. ()는 url과 action메소드를 짝을 짓는 것이다.

* 액션메소드가 controller의 메소드니까 역할이 같다. 지휘만 한다. 작업은 하지 않는다.

* Model은 mapper가 가져온 것(데이터)을 view에 가져다줄때 넣어서 주는 것. 즉 택배상자같음.

* return "student/list"; // view 이름에 return

* view는  html 태그들을 출력하는 것

* data는 model에 담겨져 있어서 view에 넘겨짐.

* @RequestMapping(value="create", method=RequestMethod.GET) : Student /edit.jsp가 처음 뜰때

* @RequestMapping(value="create", method=RequestMethod.POST) :  Stduent/edit.jsp에서 저장버튼 눌렀을때

* return "redirect:list"; : list라는 url로 redirect 해라. /이게 없으니까 상대 url(path는 같고 마지막만 바뀌는것)이고 따라서 student/list다. 

* @RequestParam("id") 

  : String s = request.getParameter("id");

    int id = Integer.parseInt(s);와 같음

    requestParam 바로 넣는다. jsp는 받아서 parsing하는데 spring은 그렇지 않다.

## 6) 뷰 구현

#### student / list.jsp

* WEB-INF/views/student/list.jsp => application.properties 에러나면 404에러나타남

* <c:forEach var="student" items="${ students }"> 

* jsp tage libery (JSTL) : <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  => pom.xml에서 JSTL maven dependency를 매번 프로젝트마다 추가해줘야 한다.

* <c:url var="R" value="/" />  : url을 계산하는 확장태그. url을 계산해서 R이라는 변수에 대입해라.
  * Context Path를 포함한 url을 R에 대입한다.
  * Project이름이 default로 Context Path로 하는데 종종 서버에서 프로젝트 하나만 도메인에 올리면 생략한다. 예를 들면 http://sw.skhu.ac.kr/이다. 여기서 Context Path는 Root(/)이다. 이것이 관례이다. 그렇게 이렇게하는게 요즘 대세
  * 즉, 위 문장은 Context Path가 바꿀수 있다는 뜻이다.

* 

   <script src="${R}res/common.js"></script>

          계산된 Context Path에 /도 포함이 되어있다.

* <c:forEach var="student" items="${ students }">  : student 목록에 있는 데이터를 student라는 변수에 하나씩 대입한다.

* <tr data-url="edit?id=${ student.id }">

   : <tr data-url="student/edit?id=${student.id}">

   tr태그가 클릭되면 data-url이 요청(자바스크립트)이 되는데 왜 그냥 edit로 적었을까? 이유는 상대 URL과 절대URL 인데, 

   상대 URL은 파일 이름부분으로 "edit?id=2" 

   현재 URL은 http: localhos:8080/mybatis1/student/list이다. 

   따라서 변환된 절대 URL http://localhost:8080/myabtis1/student/eidt?id=2이다. 

   절대 URL은 현재 URL과 결합할때 Context Path 부터 결합된다.

#### edit.jsp

* <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  : spring form 확장태그

* <form:form method="post" modelAttribute="student">  : model에 들어있는 student 데이터를 입력하기 위한 확장태그

*  <form:input path="studentNumber" class="form-control w200" /> : 

  input 태그를 input위한 확장태그,	student.studentNumber의 property를 input하기 위한 확장태그

*  <form:select path="departmentId" class="form-control w200"                    

  itemValue="id" itemLabel="departmentName" items="${ departments }" /> 

	=> items는 옵션테이블로 출력할것들. 

* <c:if test="${ student.id > 0 }"> : sutdent.id>0는  수정페이지때는 id가 0보다 크고 등록페이지에는 id가 0이다.

* <span class="glyphicon glyphicon-ok"></span> 저장</button> 

  * 자동으로 Post 방식과 redirect로 list.jsp로 간다.

  * <c:url var="R" value="/" /> : JSTL 확장태그 Url인데 이 태그를 왜쓰냐면 Context Path가 변경될수 있기 때문이다. 여기는 Context Path를 간단하게 계산하는 방법으로 앞으로 이 기법을 자주 쓸것이다.

  * <form:form method="post" modelAttribute="student">  

    : html form 태그를 출력한다. 이 입력폼에서 편집할 데이터 객체는  model에 들어있는 student다.

  *  <form:input path="studentNumber" class="form-control w200" /> 

    : input 태그를 출력한다. modelAttribute 객체의 studentNumber 속성값이, input 태그의 value 애트리뷰트의 출력된다. input텍스트 값이 뜰때 저 값이 채워져있다라는 것이고 input 태그의 name값(submit될때 requestparameter의 name이다.)은 path값과 같은studentNumber이다.

*    <form:select path="departmentId" class="form-control w200"                    itemValue="id" itemLabel="departmentName" items="${ departments }" /> 

   : 





### 실행 매커니즘

(1) 웹브라우저에서, http://localhost:8080/mybatis/student/ist UTL을 서버에 요청한다. GET 방식 요청.

(2) 요청된 URL에 연결된(request mapping) 액션 메소드가 실행된다. 

	없으면404에러.

	@RequestMapping("student")

	@Controller

	class StudentController{

		@RequestMapping("list")

		public String list(...){}

	}

(3) StudentController의 list 메소드 실행됨.	

      studentMapper.selectAll() 메소드를 호출하여 리턴된 학생 목록을 model객체에 추가함.

  List<Student> students = studentMapper.findAll();         model.addAttribute("students", students);



(4) 뒤를 이어 실행될 뷰 이름을 리턴함.

	return "student/list";

(5) "student/list" 뷰 이름 앞 뒤에 view prefix, view suffix가 붙는다.

	(applicatoin.properties 참고)

	/WEB-INF/views/student/list.jsp" 파일이 실행된다.

(6) 뷰는 model에 들어있는 학생 목록 데이터를 출력한다. (model 데이터의 이름은 students)

	출력결과는 html태그.

	출력된 html 태그들이 웹브라우저로 전송된다.

----------------------------------------------------------------------------------------------

(1) 웹브라우저창의 학생 목록에서 고은별 학생을 클릭

	클릭된 tr태그의 onclick 이벤트 핸들러가 호출됨.

	이 이벤트 핸들러는 common.js 파일의 javascript 코드에 의해서

	tr 태그에 자동으로 등록되어 있다.



(2) <tr data-url="edit?id=2">

	"edit?id=2" 상대URL

	상대 URL -> 절대 URL 만들기!!

	현재 웹브라우저창의 URL 파일명만 교체하면 된다.

	현재 웹브라우저의 URL http://localhost:8080/mybatis1/student/list

	결과 URLhttp://localhost:8080/mybatis1/student/edit?id=2

	이 결과 URL이 서버에 요청됨. GET 방식


(3) 요청된 URL에 연결된(request mapping) 엑션 메소드가 실행된다. 없으면 404 에러.

	@RequestMapping("/student")

	@Controller

	class StudentController{

	@ReaustMapping( value="edit", mtehod=RequestMethod.GET

	  Student student = studentMapper.findOne(id);       

	  List<Department> departments = departmentMapper.findAll();         								

	model.addAttribute("student", student);         	

	model.addAttribute("departments", departments);         

	return "student/edit";

		}

	}

(4) request parameter로 전달된 id 값에 해당하는 학생 레코드를 조회해서 model에 추가. 

        Student student = studentMapper.findOne(id); 

        model.addAttribute("student", student); 



    학과 목록 전체를 조회해서 model에 추가 

        List<Department> departments = departmentMapper.findAll(); 

        model.addAttribute("departments", departments); 



(5) 뒤를 이어 실행될 뷰 이름을 리턴함. 

        return "student/edit";   



(6) "student/edit" 뷰 이름 앞 뒤에 view prefix, view suffix가 붙는다.  

    (application.properties 참고)   

 /WEB-INF/views/student/edit.jsp 파일이 실행된다. 



(7) 뷰는 model에 들어있는 학생 데이터를 form 태그과 input 태그에 출력한다.(model 데이터의 이름은 student) 

     학과 목록 데이터를 select 태그와 option 태그에 출력한다. (model 데이터 이름은 departments) 

    출력 결과는 html 태그. 

 출력된 html 태그들이 웹브라우저로 전송되어 웹브라우저창에 그려진다. 



------------------------------

(1) 웹브라우저 창에서 입력 폼의 데이터를 수정하고, 저장버튼을 클릭.









































































































































































































































































































































