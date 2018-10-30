package net.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.practice.dto.Department;

@Mapper
public interface DepartmentMapper {
	List<Department> findAll();
	void update(Department department);
}
