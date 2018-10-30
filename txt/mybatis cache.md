# mybatis cache

----------------------------------------------

학생 레코드

학적상태 : 재학, 휴학, 졸업

학과

학번

이렇게 3개로 pk를 만든다.

하지만 pk가 3개지만 조회및 삭제할때 한개로만 하면 편할것이다.

따라서 인덱스를 만들어줘야 한다.

-----------------------------------------------------------------

PRIMARY PRIMARY는 지정되어있고

학번 UNIQUE

Alter table add Index index studentNumber unique

이런식으로 mysql에서 clustered Index 사용하려면 이렇게 해야 한다.

----------------------------------------------

mysql에서는 autoincrement 필드가 있다면 그것이 무조건 pk이다.

redirect : get방식이다.

subString처럼 subList(0,5) 메소드가 있다.