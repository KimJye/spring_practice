package edu.spring.ex02.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.Board;
import edu.spring.ex02.pageutil.PaginationCriteria;

// @Repository: 스프링 프레임워크에게 DB를 사용하는 
// 영속성(persistence) 계층의 콤포넌트임을 등록하는 어노테이션
// root-context.xml 파일에서 bean으로 등록을 해야 함(context:component-scan)
@Repository
public class BoardDaoImple implements BoardDao {

	private static final String NAMESPACE =
			"edu.spring.ex02.BoardMapper";
	
	@Autowired // 의존성 주입(DI)
	private SqlSession session;
	
	@Override
	public List<Board> read() {
		
		return session.selectList(NAMESPACE + ".selectAll");
	}

	@Override
	public Board read(int bno) {
		
		return session.selectOne(
				NAMESPACE + ".selectByBno", bno);
	}

	@Override
	public List<Board> read(String userid) {
		String arg = "%" + userid + "%";
		return session.selectList(
				NAMESPACE + ".selectByUserid", arg);
	}

	@Override
	public List<Board> read(String title, String content) {
		Map<String, String> args = new HashMap<>();
		args.put("title", "%" + title + "%");
		args.put("content", "%" + content + "%");
		
		return session.selectList(
				NAMESPACE + ".selectByTitleOrContent", args);
	}

	@Override
	public int create(Board b) {
		
		return session.insert(NAMESPACE + ".insert", b);
	}

	@Override
	public int update(Board b) {
		
		return session.update(NAMESPACE + ".update", b);
	}

	@Override
	public int delete(int bno) {
		
		return session.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public List<Board> search(int type, String keyword) {
		Map<String, Object> args = new HashMap<>();
		args.put("searchType", type);
		args.put("searchKeyword", "%" + keyword + "%");
		
		return session.selectList(NAMESPACE + ".search", args);
	}
	
	@Override
	public int getTotalCount() {
		return session.selectOne(NAMESPACE + ".totalCount");
	}
	
	@Override
	public List<Board> read(PaginationCriteria c) {
		return session.selectList(NAMESPACE + ".selectPage", c);
	}
	
} // end class BoardDaoImple





