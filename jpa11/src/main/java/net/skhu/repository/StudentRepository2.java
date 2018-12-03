package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.skhu.domain.Course;
import net.skhu.domain.Department;
import net.skhu.domain.Student;

//jpql 활용해보기
public interface StudentRepository2 extends JpaRepository<Student,Integer>{

	@Query("SELECT s FROM Student s ORDER BY name")
	List<Student> findStudents();

	@Query("SELECT s FROM Student s WHERE s.department.id=?1")
	List<Student> findStudentsByDepartmentId(int departmentId);

	@Query("SELECT s FROM Student s WHERE s.studentNo = ?1 OR s.name = ?2")
	List<Student> findStudentsByStudentNoOrName(String studentNo, String name);

	@Query("SELECT s FROM Student s WHERE s.studentNo = :studentNo OR s.name = :name")
	List<Student> findStudentsByStudentNoOrName2(@Param("studentNo") String studentNo, @Param("name") String name);

	@Query("SELECT s.department FROM Student s")
	List<Department> findDepartmentOfStudents();

	@Query("SELECT DISTINCT s.department FROM Student s")
	List<Department> findDistinctDepartmentOfStudents();

	//학생이 수강한 과목
	@Query("SELECT r.course FROM Student s JOIN s.registrations r WHERE s.studentNo = ?1")
	List<Course> findCourseByStudentNo(String studentNo);

	@Query("SELECT s.id, s.name FROM Student s")
	List<Object[]> findIdAndNameOfStudents();

	@Query("SELECT s.department.name, COUNT(s) FROM Student s GROUP BY s.department")
	List<Object[]> findStudentCountOfDepartment();

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Student s SET name = :name WHERE id = :id")
	void updateStudentName(@Param("id") int id, @Param("name") String name);




}
