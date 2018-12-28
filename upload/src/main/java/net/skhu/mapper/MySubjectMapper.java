package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.model.MySubject;
import net.skhu.model.User;

@Mapper
public interface MySubjectMapper {
	void deleteById(String userId);
	void insert(List<MySubject> mySubjects);
	List<MySubject> findAll(String userId);//학생이 수강한 전체 과목을 조회.
	List<MySubject> findByYearAndSemester(String userId, String takeYear, String takeSemester);//조회조건 년도와 학기
	List<MySubject> findByCode(String userId, String srchText);//조회조건 과목코드
	List<MySubject> findByName(String userId,  String srchText);//조회조건 과목명
	void update(User u);
}
