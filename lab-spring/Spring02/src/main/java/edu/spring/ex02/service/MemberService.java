package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.Member;

public interface MemberService {

	List<Member> select();
	Member select(String userid);
	int insert(Member m);
	int update(Member m);
	int delete(String userid);
	
} //end interface MemberService
