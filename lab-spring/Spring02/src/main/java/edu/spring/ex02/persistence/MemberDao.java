package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.Member;

public interface MemberDao {

	List<Member> read();
	Member read(String userid);
	int create(Member m);
	int update(Member m);
	int delete(String userid);
	
} // end interface MemberDao
