# Transaction Isolation Level

-------------------------------

Atomicity : 전체 성공 or 전체 실패. 구현 기법 

consistency : 일관성

Isolation : 격리성. 수강신청 문제

Durability : 지속성 commit을 하면 현재 상태는 영원히 보장된다.

* transaction이 (conco여러개 실행되는데 (isolation)혼자 돌아가는 것처럼 보호가 됨



Read Uncommitted : Read Lock 안검.

Read Commited : Read Lock을 가급적 빨리 푼다. 명령 하나 단위로 건다. 단점은

transaction내에서 읽자마자 lock을 풀어서 다른 transaction이 중간에 바꿀 수 있다. 이 문제점을 막기 위해서 Repeatable Read가 나옴.

Repeatable Read : transaction 끝날때(commit 후) 푼다. 하지만 중간에 달라질 수 있다. insert되는 경우에는 select 즉 read가 아닌 경우. read는 락이 걸려잇지만 insert는 락이 거려있지 않다.

serialiable : 좀더 읽기 락을 충분히 건다. 미래에 읽을지도 모르는 것까지 포함하여 읽기락을 건다. 예를들면 insert되는 경우.commit 때 품. 수강신청때 쓰자.



Readn Uncommitted : Read Lock을 안건다.  문제점 : 쓰고 있는데 읽을 수 있다. 데이터 완성안했는데 읽어버릴 수 있다. 이것을 Dirty Read라고 부른다.

Read Commited : 문제점 : non Repeatable Read 문제가 발생한다. 읽기락을 안거니까 누가 내 코드를 바꿔버려서 다시 읽으면 달라질 수가 있다.

Repeatable Read : 위 문제를 해결하기 위함. 한번 읽은 레코드를 보호가 되지만 앞으로 읽을지도(where가 true가 되도록 insert되거나 update되는 )모르는 레코드의 변경사항을 알수가 없다. 이것을 유령읽기(phantom Reads)라고 한다. 이 문제를 해결하기 위해서 serialiable lavel이 나왔다.

serialiable 



-------------------------------

디비 성능 문제 : cash, index

디비 cash 는 동시접속자(똑같은 명령이 빈번하게 여러번 실행)일때 효과적

index는 쿼리자체가 복잡해서 오래걸리는 경우가 효과적이다.(쿼리성능최적화)

--------------

테이블 정규화를 하는 이유: 1.이상현상(anomaly) 제거. 2. 디비 구조 확장 시 재 디자인 최소화. 3. 사용자에게 데이터 모델을 더욱 의미있게 제공

여기서 이상현상은 삽입, 삭제, 수정이상이다.

단점 : 데이터를 처리할 때 속도가 빨라질 수도 있고 느려질 수도있다. 느려지는 경우의 대표적인 예로는 join연산. 릴레이션 분해로 인해 릴레이션 간 join연산이 많아진다.

정규화는 관계형 데이터베이스에서 중복을 최소화하기 위해 결정자에 의해 함수적 종속을 가지고 있는 일반 속성을 의존자로 하여 이상현상을 제거하는 것이다. 데이터를 구조화한 것이다.

------------------------

ORM이란 : Object Relactoin Mapping. 디비에서 조회한 데이터를 자바 객체에 저장해주고 이러한 작업들을 ORM기술이라하고 mybatis와 jpa가 있다.

mybatis 장점 : sql문, 단점 : db마다 sql이 다르기 때문이다.

jpa : 장점: 구현이 쉽다. sql을 직접 구현하지 않다. db가 독립적이다. 단점 : 익숙하지 않다.