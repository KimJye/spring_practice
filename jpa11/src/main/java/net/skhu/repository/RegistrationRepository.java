package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Registration;

public interface RegistrationRepository  extends JpaRepository<Registration,Integer>{
	//id에 해당하는 학생의 수강강좌 목록
	List<Registration> findByStudentId(int id);
}
