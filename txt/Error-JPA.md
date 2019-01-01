com.fasterxml.jackson.databind.JosnMappingException: Infinite recursion(StackOverflowError)

==> 무한 반복 출력 때문에, Infinite recursion 에러가 발생하였다.

Department 객체를 JSON 포맷으로 출력할 때, employees 속성을 생략하거나. 

아니면, Employee 객체를 JSON 포맷으로 출력할 때, department 속성을 생략해야 한다.

보통 목록 속성 출력을 생략하는 경우가 많다. 

속성 앞에 @JsonIgnore 어노테이션을 붙여주면, 그 객체를 JSON 포맷으로 출력할 때 

그 속성값을 생략된다. 

--------------------------------------------------

int 타입은 null 값이 가능하지 않기 때문에 변수를 Integer 클래스 타입으로 선언해야 한다.

----------------------------

JPQL query를 직접 구현해야 하는 경우는, 대부분 SELECT, UPDATE 명령이다.

-------------------

  UPDATE / DELETE 명령인 경우에  

     @Modifying(clearAutomatically = true) 어노테이션을 반드시 붙여야 한다. 