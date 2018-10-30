package edu.spring.ex02.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.Member;

@Repository
public class MemberDaoImple implements MemberDao {
	private static final String NAMESPACE =
			"edu.spring.ex02.mappers.MemberMapper";

	private static final Logger logger =
			LoggerFactory.getLogger(MemberDaoImple.class);
	
	@Autowired private SqlSession session;
//	@Autowired private MemberMapper mapper;
	
	@Override
	public List<Member> read() {
		logger.info("read() 호출");
		return session.selectList(NAMESPACE + ".selectAll");
	}

	@Override
	public Member read(String userid) {
		logger.info("read(userid: {}) 호출", userid);
		return session.selectOne(NAMESPACE + ".selectById", userid);
	}

	@Override
	public int create(Member m) {
		logger.info("create() 호출");
		return session.insert(NAMESPACE + ".insert", m);
	}

	@Override
	public int update(Member m) {
		logger.info("update() 호출");
		return session.update(NAMESPACE + ".update", m);
	}

	@Override
	public int delete(String userid) {
		logger.info("delete() 호출");
		return session.delete(NAMESPACE + ".delete", userid);
	}

} // end class MemberDaoImple
