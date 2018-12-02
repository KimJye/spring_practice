package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	// student 테이블에서 name필드로 레코드를 조회하여 리턴
	List<Student> findByName(String name);

	// student 테이블에서 name 필드로 레코드를 조회한다. 파라미터 변수 name값이 필드 값 앞 부분과 일치하면 된다.
	List<Student> findByNameStartsWith(String name);

	// student테이블과 department테이블을 조회하고, 조인된 department테이블의 name필드로 조회하여 일치하는 student 테이블 레코드 리턴
	// 즉, 파라미터 변수 name과 department.name 필드 값 전체가 일치해야 한다.
	List<Student> findByDepartmentName(String name);

	// 파라미터 변수 name값이, department.name필드 값 앞 부분과 일치하면 된다.
	List<Student> findByDepartmentNameStartsWith(String name);

	// 테이블의 전체 레코드를 name 필드의 오름차순으로 정렬하여 리턴
	List<Student> findAllByOrderByName();

	// 테이블의 전체 레코드를 name 필드의 내림차순으로 정렬하여 리턴
	List<Student> findAllByOrderByNameDesc();

	// student테이블과 department 테이블 조회하고
	// 조회된 department테이블의 id 필드로 조회하여 일치하는 student테이블 레코드를 리턴
	// 조회 결과를 student테이블의 name필드의 내림차순으로 정렬하여 리턴한다.
	List<Student> findByDepartmentIdOrderByNameDesc(int id);
}
