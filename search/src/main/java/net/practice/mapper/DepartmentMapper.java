package net.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.practice.dto.Department;

@Mapper
public interface DepartmentMapper {
	List<Department> findAll();
	List<Department> findAllWithStudents();//resultMap이용한 학과별 학생 조회
	void update(Department department);
}
