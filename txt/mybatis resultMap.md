# mybatis resultMap

--------------------------------

* 학습목표 : mybatis 메소드의 조회 결과를 여러 객체들이 결합된 구조로 변환해서 리턴해주는 mybatis resultMap 기능을 학습한다.

* mybatis의 장점이자 단점 : SQL으로구현. ORM 기술 사용.  resultMap

* implements Serializable : Clonable  = shallow copy

  						    Serializable = deep copy

  객체.clone() : 그 클래스 또는 부모클래스를 implements 하면 된다.

  deep copy를 구현하려면 serialID를 지정해주면 된다.

  여기써 쓴 이유는 mybatis cash를 활성화하기 위해서 DTO 클래스에서 구현한다. cash에서 원본을 가져오는것은 위험하기 때문에 복제해서 리턴해줘야 한다. 따라서 이것이 생략되어있으면 실행될때 에러가 날것이다.

*  List<Student> students; : 학과 목록을 조회할때 학생 목록도 동시에 조회하려고 추가함.

* ' <select id="findByDepartmentId" resultType="Student">     SELECT * FROM Student WHERE departmentId = #{departmentId}   </select>  ' : 학과ID로 학번 조회

* ' @RequestMapping("departmentList1")     public String departmentList1(Model model) {         List<Department> departments = departmentMapper.findAll();         for (Department department : departments) {             List<Student> students = studentMapper.findByDepartmentId(department.getId());             department.setStudents(students);         }         model.addAttribute("departments", departments);         return "mybatis/departmentList";     } ' : DB에서 꺼내와서 저장.

* forEach문 중첩

* ${ department.students.size() }명 : List(students)의 size().



여기까지가 mybatis ResultMap 기능을 사용하기 전이다.!!

--------------------------------------------------

### mybatis ResultMap 기능 사용하기

* ' <select id="findAllWithStudents" resultMap="resultMap1">' : resultType이 아닌 resultMap임을 유의하자.

* department1은 학과목록을 조회한다음에 그 학과에 소속된 할생을 따로따로 조회해서 객체에 저장하지만 department2는 한번에 저장한다. 

  성능면에서 훨씬 이득이다. 왜냐면 2는 디비를 한번조회하기 때문이다.

-----------------------------

### ORM 구조로 구현하기

여지껏 우리는 join 결과값을 넣기 위해 StudentDTO에 departmentName필드에 넣는다. 하지만 이경우에는 속성 몇개만 넣을 수 있으며 클래스 명이 유명무실해진다. 따라서  필드하나하나가 아니라 객체를 넣는다.

이렇게 객체 구조에 넣을때 장점은 db와 모델링이 같기 때문에 DTO클래스가 깔끔하다. 하지만 구현이 어렵다.

================before===============

StudentDTO

id, name, departminetId, departmentName

------

=============After=============================

Student DTO

id, name,

departmentId, (중복되지만 이게 필요한 이유는  추후에 insert,update, delete할때 편하다.)

Department department  

------

Department DTO

id, departmentName, 

List<Student> students

---------------------------------

collection(객체 여러개)일때 typeOf 이고 association(객체가 하나)일때는 javaType이다.

pk는 id고 그냥 필드는 result다.

--------------------------------------

어떤 경우는 join 해서 departmentName만 가져올 경우 / 어떤 경우는 다 가져오는 경우 이렇게 다를 때는 그냥 다 조회해오고 채우는 것이 낫다. 이러면 느리지 않는다. 디비에서 조회할때 몇번 조회해오냐가 성능면에서 중요한 것이다.cpu속도보다 network 속도가 상대적으로 느리다. 모바일정도되면 메모리에서 차이가 날것이다. 하지만 우리는 서버에서 하기때문에 서버는 메모리절약까지는 신경쓸필요가 없다. 서버는 램이 넉넉하기 때문이다.

-