package net.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.practice.dto.Student;

@Mapper
public interface StudentMapper {
	Student findOne(int id);
	Student findByStudentNumber(String studentNumber);
	List<Student>findAll();
	List<Student>findByName(String srchText);
	List<Student>findByDepartmentId(int departmentId);
	List<Student>findStudentByDepartmentId(int departmentId);
	List<Student>findAllWithDepartment();
	void insert(Student student);
	void update(Student student);
	void delete(int id);
}
