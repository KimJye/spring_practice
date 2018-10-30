package edu.spring.ex03.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex03.domain.Reply;
import edu.spring.ex03.mappers.ReplyMapper;

@Repository
public class ReplyDaoImple implements ReplyDao {

	private static final String NAMESPACE =
			"edu.spring.ex03.mappers.ReplyMapper";
	
	@Autowired private SqlSession session;
	@Autowired private ReplyMapper mapper;
	
	@Override
	public List<Reply> read() {
		return session.selectList(NAMESPACE + ".selectAll");
	}
	
	@Override
	public List<Reply> read(int bno) {
		return mapper.read(bno);
	}

	@Override
	public int create(Reply r) {
		return mapper.insert(r);
	}
	
	@Override
	public int update(Reply r) {
		return mapper.update(r);
	}
	
	@Override
	public int delete(int rno) {
		return mapper.delete(rno);
	}
	
	@Override
	public Integer getBno(int rno) {
		return mapper.getBnoByRno(rno);
	}
	
} // end class ReplyDaoImple





