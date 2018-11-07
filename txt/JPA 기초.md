# JPA 기초

---------------------------------

spring web mvc, spring data, mybatis, jpa 프로젝트 등 다 다르다.

spring-jdbc를 사용하면 코딩 양이 많이 줄기때문에 우리가 고웹1에서 했을 때처럼 jdbc를 직접 코딩하지않는다. 

우리 중간고사전까지 spring data프로젝트안에 spring mybatis프로젝트를 한 것이다. 

마찬가지로 우리가 앞으로 배워야할 것은 spring data프로젝트안에서 spring-jpa프로젝트를 할 것이다.

## 1) Domain Model 

* 수강신청 도메인을 이해하기 위해서 그 관계를 그림으로 그려놓음

## 2) JPA Repository 기본 메소드

* import org.springframework.data.jpa.repository.JpaRepository;
* 기본 메소드가 포함되어있다.

## 3) Rest API

클라이언트 즉 웹브라우저가 서버에게 httpRequest를 하고 서버는 웹브라우저에게 http response(html출력). 이런식으로 구현은 점점 줄어든다.

요즘은 웹브라우저가 httpRequest(Ajax)를 하고 서버는 웹브라우저에게 http response(json 데이터).

Ajax : javascript가 보낸 요청.

대표적인 것 : react, vue, anlgular framework

즉. 클라이언트의 url요청에 대해서  json 형태의 데이터를 출력하는 서버이 메소드를 말한다.

## 4) JSON (Javascript Object Notation)

## 5)RestController 

Rest Controller : view 안만들어도 됨. 데이터를 직접 출력하니까. 대신 javascript에서 구현하는게 많다.

평범한 컨트롤러 액션메소드 리턴값은 문자열이다. 이 문자열은 1. 대부분의 경우 view의 이름(뒤에 query string 붙을 수 없다.) 2. redirect : url일경우.(뒤에 url이 붙을 수 있다.)

## 6) @ResponseBody

* json으로 변환하라!
* @RestController
* Controller 유형에 따라 나누는 것이 좋다.

## 7) @RequestBody

클라이언트에서 RequestParameter를 보내는 형식이 default 형식(query String)으로 보낼 수 있고 다른 형식(json format)으로 보낼수 있다.

* RequestParameter를 json형식으로 보낼 때.
* 어떨 때 default format 인지 json format인가 ? 대부분은 default format. 하지만 default format으로 보내는 것이 어려운 경우가 있는데 객체 배열(목록)일때가 어렵다. 이때는 json format으로 보낸다.
* 학생목록을 한꺼번에 서버에 저장하려면 json format으로 보내는 것이 훨씬 편하다

## 8) Request Method

* Rest api 서비스를 구현할 때 get, post 뿐만아니라 delete, put등 request method들을 전부 잘 써야 관례다.

## 9) Rest API URL 패턴

* url에 query string을 사용하지 않는 것이 관례
* url에 동사를 사용하지 않는 것.



## 10) @PathVariable

* 요청된 URL이 http://localhost:8080/jpa1-/api/student/3과 같다면

  url에 들어있는 id값 3을 받기위한 액션 메소드는 

  @RequestMapping("api/student/{id}")

  public Student student(@PathVariable("id") int id) 과 같다.



## 11)액션 메소드 URL

컨트롤러 클래스에도 @RequestMapping("URL1") 어노테이션 붙어있고 

액센 메소드에도 @RequestMapping("URL2") 어노테이션이 붙어있다면, 

그 액션 메소드를 호출하기 위한 URL은 "URL1/URL2" 이다.

## 12) JAP Entity 클래스

* domain Model을 그려놓은 것  = entity와 relation을 그려놓은 것.
* @Entity : 클래스 앞에
* @Id : primary key앞에
* @GeneratedValue(strategy = GenerationType.IDENTITY) : auto increment필드 앞에
* @ManyToOne : student 객체에서 department를 볼 때 
* @JoinColumn : foriegn key. 
* mybatis에서 association,collection, resultMap을 구현안하고 위의 3줄 어노테이션을 구현하면 간단하게 가능하다.
* @OneToMany : department객체에서 student객체를 볼 때
* @MappedBy("department") : department 테이블에는 fk가 없으니까 student테이블의 department멤버변수에 저장. 
* List<Student>student; //student 목록



## 13)  Eager Loading, Lazy Loading

jpa로 구현하면 join 필요없이 값이 자동으로 채워진다.

데이터를 조회할때 같이 조회한다.

* Eager Loading : 미리 조회

* lazy loading : 미리조회하지 않고 사용하려고 할 때 조회한다. 즉, department객체를 조회할때마다 student객체를 사용하려고 할 때 늦게 조회한다.