

@Transactional => 롤백, 따라서 디비 안건듦

Mapper의 interface(xml구현안함) => test=>클래스 구현

agile? => 계획주도 개발이 아닌 협력 과 피드백이다. => 테스트 주도 개발

service test하기 => 일단 exception클래스 만들자 그리고 가짜메퍼(mock)만들자

InjectMocks : Mapper목객체를 만들고 service안에 목객체를 넣어라 

mockito.verify=> 이 메소드가 호출됐는지 확인

mockito.times(0)=> 메소드 호출 안한거 맞는지 확인

htmlUnit, Selenium => 자바가 사용자. 사람대신 프로그램이 테스트하는 것을 구현하는 로봇

둘의 차이 : selenium 은 실제 웹브라우저를 이용하여 테스트하여 느리다. 하지만 대세

			htmlUnit은 gui가 없어서 빠르다

로그인이나 크롤링할때쓴다.

보안이 잘되어있는 사이트에서 정보를 긁어올때

JSOUP?