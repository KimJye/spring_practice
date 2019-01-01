# JPA

-------------------

subsystem여러개가 하나의 프로젝트가 된다.

전체 시스템의 구조를 Architecture라고 말한다.

나눠서 개발할 때 subsystem을 가급적 수직으로 쌓아올린다. 수직으로 쌓아올리는데 이것을 layered Atrchitecture라고 부른다. 이유는 큰 조직은 수직적일 수록 효율적이다.

예를 들면 spring(거대한 사이트)이 있다.

spring은 controller 밑에 service dao, mapper(mybatis) 또는 jpa.

여기서 api가 등장한다.

api는 계층 구조를 더 단순히 하기 위해서 각 계층마다 api라고 부르는 목록을 미리 설계하고 약속한 것이다.

자바에서 api를 간단하게보면 public class, method, interface이 있다. 

다형성 호출 가능.



표준 api는 언어에 라이브러리에있는 public class 예를 들면 stringbuilder, list 등등

구글이 오라클의 자바api를 침범했다. 이것은 public class, public method 목록을 똑같이 만들었다. 예를 들면 math, integer,string,arrayList 등등

JPA(java persistence(연속성 즉, 저장) api)  = 자바 저장하기 위한 api

 jpa : 약속만 정해준거지 코드가 있는 것은 아니다.

jpa로 만든 제품중 가장 유명한 것이 hibernate다.

예를 들면 jsp(기술) 와 tomcat(jsp를 구현한 제품)

jpa 프로젝트는 hibernate가 실행되고 있다.



spring data프로젝트에서 jpa(by spring data team) - repository자동 구현

spring data mybatis - mapper 자동 구현

spring data jdbc 기능도 있다.



JPA Repository 기본 메소드 

* Optional<Student>  findById (int id); 
* List<Student>      findAll(); 
* Student            save(Student student); 
* void               delete(Student student); 
* boolean            exists(int id);



위 기본 메소드 외에 다른 메소드들도 자동으로 구현해준다.

쿼리 메소드 자동 구현 

public interface StudentRepository extends JpaRepository<Student, Integer>  {     	

	List<Student> findByName(String name);     

	List<Student> findByStudentNo(String studentNo);   

	 List<Student> findByNameStartsWith(String name);     

	List<Student> findByDepartmentName(String name);     

	List<Student> findByDepartmentNameStartsWith(String name);  //앞부분 일치

   	List<Student> findAllByOrderByName();     

	List<Student> findAllByOrderByNameDesc();    

	 List<Student> findByDepartmentIdOrderByNameDesc(int id); }

Spring Data JPA는, JPA repository 기본 메소드 뿐만 아니라,  

repository 인터페이스에 선언된 다른 메소드들도 자동으로 구현해 준다.

mybatis와 달리 sql 안만들어줘도 된다.

규칙만 지키면 된다. jpa에서는 엔터티 클래스의 속성명과 일치해야 한다.

StudentNumber가 아니라 StudentNo인 이유는 :  엔터티 클래스 속성명과 디비 필드명과 일치하면 좋지만 일치하지 않아도 된다. 이때는 어노테이션만 붙여주면 된다.



mybatis에서 파라미터가 여러개일때 @Param("id")  int id 이렇게 명시해준다. 여기서 또 변수를 선언해주는 이유는 파라미터 변수명이 무시되기 때문인데 무시되는 이유는 Java 언어는 바이트코드로 컴파일된다. (*.class 파일) 

컴파일된 바이트코드가 JVM(Java Virtual Machine)에서 실행된다. 

컴파일된 *.class 파일에  

Java 지역 변수 이름과 파라미터 변수 이름은 들어있지 않다. 

그래서 JVM은 메소드 파라미터 변수 이름을 알 수 없으니, 

바이트코드 JVM에서 실행될 때 메소드 파라미터 변수 이름은 무시될 수 밖에 없다.

mybatis에서 in연산자는 dynamicSQL을 써야 한다.