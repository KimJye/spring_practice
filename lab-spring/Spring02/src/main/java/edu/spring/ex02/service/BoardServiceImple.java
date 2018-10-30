package edu.spring.ex02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.Board;
import edu.spring.ex02.pageutil.PaginationCriteria;
import edu.spring.ex02.persistence.BoardDao;

// @Service: 스프링 프레임워크에게 Business(Service) 계층 콤포넌트임을
// 설정하는 어노테이션
// root-context.xml에서 bean으로 등록해야 함
@Service
public class BoardServiceImple implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> select() {
		
		return boardDao.read();
	}

	@Override
	public Board select(int bno) {
		
		return boardDao.read(bno);
	}

	@Override
	public List<Board> select(String userid) {
		
		return boardDao.read(userid);
	}

	@Override
	public List<Board> select(String title, String content) {
		
		return boardDao.read(title, content);
	}

	@Override
	public int insert(Board b) {
		
		return boardDao.create(b);
	}

	@Override
	public int update(Board b) {
		
		return boardDao.update(b);
	}

	@Override
	public int delete(int bno) {
		
		return boardDao.delete(bno);
	}

	@Override
	public List<Board> search(int type, String keyword) {
		return boardDao.search(type, keyword);
	}
	
	@Override
	public int getTotalCount() {
		return boardDao.getTotalCount();
	}
	
	@Override
	public List<Board> select(PaginationCriteria c) {
		return boardDao.read(c);
	}
} // end class BoardServiceImple









