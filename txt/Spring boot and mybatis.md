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