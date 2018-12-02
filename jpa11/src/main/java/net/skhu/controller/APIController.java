package net.skhu.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Course;
import net.skhu.domain.Department;
import net.skhu.domain.Professor;
import net.skhu.domain.Registration;
import net.skhu.domain.Student;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.ProfessorRepository;
import net.skhu.repository.StudentRepository;

@RestController
@RequestMapping("api")
public class APIController {

	@Autowired DepartmentRepository departmentRepository;
	@Autowired ProfessorRepository professorRepository;
	@Autowired StudentRepository studentRepository;

	//학과 전체 출력
	@RequestMapping("departments")
	public List<Department> departments(){
		return departmentRepository.findAll();
	}

	//전체 학생 목록 출력 - 학생정보와 학생 해당 학과의 id와 name 나옴.
	@RequestMapping("students")
	public List<Student> students(){
		return studentRepository.findAll();
	}

	//해당학과에 속한 학생 목록 출력 - 각 학생정보와 학생 해당 학과의 id와 name 나옴.
	@RequestMapping("department/{id}/students")
	public List<Student> departmentStudents(@PathVariable("id")int id){
		Department department = departmentRepository.findById(id).get();
		return department.getStudents();
	}

	//해당학과에 속한 교수 목록 출력 - 각 교수정보와 학생 해당 학과의 id와 name 나옴
	@RequestMapping("department/{id}/professors")
	public List<Professor> departmentProfessors(@PathVariable("id")int id){
		Department department = departmentRepository.findById(id).get();
		return department.getProfessors();
	}

	//해당 id값의 학생의 수강 목록(수강목록의id, grade, createDate)과 학생정보, 그 학생의 학과 정보(id, name),
	//수강 과목 정보(id,unit,starDate,name), 수강과목의 학과 정보, 수강과목의 교수 정보, 수강과목의 교수정보의 학과 정보
	@RequestMapping("student/{id}/registrations")
	public List<Registration> studentRegistrations(@PathVariable("id")int id){
		Student student = studentRepository.findById(id).get();
		return student.getRegistrations();
	}

	/*
	//해당 id값의 학생이 수강한 과목의 정보 - 해당 과목의 정보, 해당과목의 학과 정보, 해당과목의 교수 정보, 해당과목의 교수의 학과 정보
	@RequestMapping("student/{id}/courses")
	public List<Course> studentCourses(@PathVariable("id") int id){
		Student student = studentRepository.findById(id).get();
		List<Course> list = new ArrayList<Course>();
		for(Registration r :student.getRegistrations())
			list.add(r.getCourse());
		return list;
	}
	*/
	//Stream API 활용 with lambda expression
	@RequestMapping("student/{id}/courses")
	public Stream<Course> studentCourses(@PathVariable("id") int id) {
		System.out.println(3);
		return studentRepository
				.findById(id).get()
				.getRegistrations()
				.stream()
				.map(s -> s.getCourse());
		}


}
