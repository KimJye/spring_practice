package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Student;
import net.skhu.repository.StudentRepository;

@RestController
@RequestMapping("api2")
public class API2Controller {

	@Autowired StudentRepository studentRepository;

	@RequestMapping("test1")
	public List<Student> test1(){
		return studentRepository.findByName("고은별");
	}

	@RequestMapping("test2")
	public List<Student> test2(){
		return studentRepository.findByNameStartsWith("김");
	}

	@RequestMapping("test3")
	public List<Student> test3(){
		return studentRepository.findByDepartmentName("국어국문학");
	}

	@RequestMapping("test4")
	public List<Student> test4(){
		return studentRepository.findByDepartmentNameStartsWith("국어");
	}

	@RequestMapping("test5")
	public List<Student> test5(){
		return studentRepository.findAllByOrderByName();
	}

	@RequestMapping("test6")
	public List<Student> test6(){
		return studentRepository.findAllByOrderByNameDesc();
	}

	@RequestMapping("test7")
	public List<Student> test7(){
		return studentRepository.findByDepartmentIdOrderByNameDesc(1);
	}


}
