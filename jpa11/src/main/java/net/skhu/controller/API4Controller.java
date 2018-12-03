package net.skhu.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Course;
import net.skhu.domain.Department;
import net.skhu.domain.Student;
import net.skhu.repository.StudentRepository2;

@RestController
@RequestMapping("api4")
public class API4Controller {

	@Autowired StudentRepository2 studentRepository2;

	//학생 이름순 정렬
	@RequestMapping("test1")
	public List<Student> test1(){
		return studentRepository2.findStudents();
	}

	//학과별 학생 - 여기서 1은 국어국문학
	@RequestMapping("test2")
	public List<Student> test2(){
		return studentRepository2.findStudentsByDepartmentId(1);
	}

	//해당 학번이거나 해당 이름인 학생
	@RequestMapping("test3")
	public List<Student> test3() {
		return studentRepository2.findStudentsByStudentNoOrName("200032010", "고은별");
	}

	//해당 학번이거나 해당 이름인 학생
	@RequestMapping("test4")
	public List<Student> test4() {
		return studentRepository2.findStudentsByStudentNoOrName2("200032010", "고은별");
	}

	//모든 학생의 학과
	@RequestMapping("test5")
	public List<Department> test5() {
		return studentRepository2.findDepartmentOfStudents();
	}

	//모든 학생의 학과 - distinct
	@RequestMapping("test6")
	public List<Department> test6() {
		return studentRepository2.findDistinctDepartmentOfStudents();
	}

	//해당 학번 학생이 수강한 과목들의 상세 내용
	@RequestMapping("test7")
	public List<Course> test7() {
		return studentRepository2.findCourseByStudentNo("200032010");
	}

	//학생 id와 이름
	@RequestMapping("test8")
	public List<Object[]> test8() {
		return studentRepository2.findIdAndNameOfStudents();
	}

	//학과별 학생수 count
	@RequestMapping("test9")
	public List<Object[]>test9() {
		return studentRepository2.findStudentCountOfDepartment();
	}

	//수정하기
	//@Modifying 어노테이션이 붙은 메소드를 호출하는 코드를 포함하는 메소드에 @Transactional 어노테이션을 반드시 붙여야 ㅎㄴ다.
	//이 방식으로 update하는것은 바람직하지 않다. 다만, JPQL로 UPDATE 문을 구현할 수 있다는 것을 보여주기 위함이다.
	@Transactional
	@RequestMapping("testUpdate1")
	public Student testUpdate1() {
		Student student = studentRepository2.findById(2).get();
		if (student.getName().equals("고은별"))
			studentRepository2.updateStudentName(2, "Go En Byeol");
		else
			studentRepository2.updateStudentName(2, "고은별");
		return studentRepository2.findById(2).get();
	}

	//DB 수정은 위 방식보다 이 방식으로 구혆는 것이 바람직하다.
	@RequestMapping("testUpdate2")
	public Student testUpdate2() {
		Student student = studentRepository2.findById(2).get();
		if (student.getName().equals("고은별"))
			student.setName("Go En Byeol");
		else
			student.setName("고은별");
		studentRepository2.save(student);
		return studentRepository2.findById(2).get();
	}
}

