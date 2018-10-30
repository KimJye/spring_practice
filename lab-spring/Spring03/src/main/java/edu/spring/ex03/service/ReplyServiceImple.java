package edu.spring.ex03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.ex03.domain.Reply;
import edu.spring.ex03.persistence.BoardDao;
import edu.spring.ex03.persistence.ReplyDao;

@Service
public class ReplyServiceImple implements ReplyService {

	@Autowired ReplyDao replyDao;
	@Autowired BoardDao boardDao;
	
	@Override
	public List<Reply> select() {
		return replyDao.read();
	}

	@Override
	public List<Reply> select(int bno) {
		return replyDao.read(bno);
	}
	
	// DataSourceTransactionManager 클래스가
	// DB 트랜잭션 관리를 하도록 AOP 설정
	@Transactional
	@Override
	public int insert(Reply r) {
		// TODO: 댓글 입력이 성공하면 게시글 테이블의 댓글 갯수를 업데이트
		// 1. 댓글 테이블에 insert
		replyDao.create(r);
		// 2. 게시글 테이블의 replycnt를 1 증가
		boardDao.updateReplyCnt(r.getBno(), 1);
		
		return 1;
	}

	@Override
	public int update(Reply r) {
		return replyDao.update(r);
	}

	@Transactional
	@Override
	public int delete(int rno) {
		// 댓글 삭제 후 Board 테이블의 댓글 갯수도 수정
		// 1) rno를 이용해서, bno를 찾고
		int bno = replyDao.getBno(rno);
		// 2) 댓글 테이블에서 해당 rno 댓글 삭제
		replyDao.delete(rno);
		// 3) 게시글 테이블에서 replycnt를 1 감소
		boardDao.updateReplyCnt(bno, -1);
		
		return 1;
	}

} // end class ReplyServiceImple



