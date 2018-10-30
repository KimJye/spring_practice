package edu.spring.ex04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex04.domain.Member;
import edu.spring.ex04.persistence.MemberDao;

@Service
public class MemberServiceImple implements MemberService {

	@Autowired MemberDao memberDao;
	
	@Override
	public Member login(Member m) {
		
		return memberDao.login(m);
	}

} // end class MemberServiceImple















