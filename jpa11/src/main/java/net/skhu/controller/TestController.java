package net.skhu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Course;
import net.skhu.domain.Professor;
import net.skhu.domain.Registration;
import net.skhu.domain.Student;
import net.skhu.repository.CourseRepository;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.ProfessorRepository;
import net.skhu.repository.RegistrationRepository;
import net.skhu.repository.StudentRepository;

@RestController
@RequestMapping("test")
public class TestController {

	@Autowired DepartmentRepository departmentRepository;
	@Autowired ProfessorRepository professorRepository;
	@Autowired StudentRepository studentRepository;
	@Autowired RegistrationRepository registrationRepository;
	@Autowired CourseRepository courseRepository;

	//어느 학생이 수강하는 강좌 목록을 조회하는 REST 액션 메소드 구현.

	//1) 구현 #1 JPA Repository의 기본 메소드만 활용하여 구현
	@RequestMapping("student/{id}/courses")
	public List<Course> studentCourses1(@PathVariable("id") int id) {

		Student student = studentRepository.findById(id).get();
		List<Course> list = new ArrayList<Course>();

		for (Registration r : student.getRegistrations()) {
			list.add(r.getCourse());
		}
		return list;
	}

	//2) 구현 #2 JPA Repository의 query creation 활용하여 구현
	@RequestMapping("student/{id}/courses")
	public List<Course> studentCourses2(@PathVariable("id") int id) {

		List<Course> list = new ArrayList<Course>();

		for (Registration r : registrationRepository.findByStudentId(id)) {
			list.add(r.getCourse());
		}
		return list;
	}

	//3) 구현 #3 JPQL 활용하여  구현
	@RequestMapping("student/{id}/courses")

	public List<Course> studentCourses3(@PathVariable("id") int id) {

		return courseRepository.findByStudentId(id);

	}

	//어느 교수가 강의하는 강좌 목록을 조회하는 REST 액션 메소드 구현.

	// 1) 구현 #1 JPA Repository의 기본 메소드만 활용하여 구현
	@RequestMapping("professor/{id}/courses")
	public List<Course> professorCourses1(@PathVariable("id") int id) {

		Professor professor = professorRepository.findById(id).get();
		List<Course> list = professor.getCourses();
		return list;
	}

	//2) 구현 #2 JPA Repository의 query creation 활용하여 구현
	@RequestMapping("professor/{id}/courses")
	public List<Course> professorCourses2(@PathVariable("id") int id) {

		return courseRepository.findByProfessorId(id);

	}

	//3) 구현 #3 JPQL 활용하여  구현

	@RequestMapping("professor/{id}/courses")
	public List<Course> professorCourses(@PathVariable("id") int id) {

		return courseRepository.findByProfessorId2(id);

	}


}
