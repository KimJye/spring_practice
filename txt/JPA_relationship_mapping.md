@JsonIgnore : 양방향 참조시 필요하다. address에도 employId 만들고 employ에도 addressId 만들 때 만약에 안만들면  Infinite recursion error난다.

두개 테이블 중 하나를 무시해야 한다. 여기서는 address에서 employId를 무시하는게 좋으니까 @JsonIgnore 을 하는 것이 좋다.



내꺼를 먼저 적는다. 즉 address와 employee관계가 다대일일때 ManyToOne을 적어준다.

fk가 없는 컬럼(employee)은 @mappedBy(컬럼)



엔터티클래스 잘 정의하고 관계만 잘 정의하면 된다.  sql메소드를 직접 짤 필요가 없기 때문에 JPA가 유용하다.

RestAPI url에 쿼리스트링을 쓰지 않는게 관례이다. 따라서 id값을 @PathVariable로 넘겨야 한다.

목록이면 복수, 객체 하나면 단수.

동사가 나오면 안된다.

"department/{id}/employees" // 단수 복수 확인하자.



@OneToMany 뒤에 fetch = FetchType.LAZY 또는 EAGER 를 적어줄수 있다. 하지만이것을 JPA 엔진이 무시할 수 있다.



EAGER는 assciona때 미리 가져오기 때문에 약간 빠르다.

get메소드해서 조회해서 가져오기때문에 약간 느리다. 

기능차이는 없다. 성능차이가 약간 있을 뿐이다.



----------------------------

Java 객체 속성은 getter setter 메소드로 구현된다. 멤버변수가 아니다!

JSP파일에서 ${student.id}에서 id는 속성(메소드 이름)이지 멤버변수(i)가 아니다.

무조건 get set다 만들필요는 없다. get만하면 ReadOnlyPropertie, set만하면 WriteOnlyPropertie가 된다.

다 대 일 관계 : 수강과 학생

fk는 수강테이블에 학생이 있다. 따라서 수강테이블은 ManyToOne 그리고 @JoinColumn(studentId)

학생테이블은 OneToMany 그리고 @MappedBy(Student)

이 경우는 목록쪽에 @JSonIgnore

equals 메소드, hashCode 메소드 재정의

4) lombok : DTO 클래스만들때 geer, setter, hashCode, equals, toString을 자동으로 구현해준다. @Data만 붙여주면 된다.



@EqualsAndHashCode(exclude="temp") //equals, hashcode값 계산할때 빼야하는 임시 멤버변수(학생 클래스에 수강신청 목록이 있다.학생데이터를 비교할 때 수강신청 목록까지 비교하면 안된다. ) 



@EqualsAndHashCode(exclude={"temp1","temp2"})

오노테이션 문법 :  @RequestMapping(value=~)url 여러개 지정할 때 (value={첫번째 해당하는 엑션메소드 url / 문자열})





