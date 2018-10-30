package edu.spring.ex04.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex04.domain.Member;

@Repository
public class MemberDaoImple implements MemberDao {
	private static final String NAMESPACE =
			"edu.spring.ex04.mappers.MemberMapper";
	
	@Autowired private SqlSession session;

	@Override
	public Member login(Member m) {
		
		return session.selectOne(NAMESPACE + ".login", m);
	}

} // end class MemberDaoImple














