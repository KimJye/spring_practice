package edu.spring.ex02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
)
public class TestSqlSession {
	private static final String NAMESPACE =
			"edu.spring.ex02.BoardMapper";
	
	private static final Logger logger =
			LoggerFactory.getLogger(TestSqlSession.class);
	
	@Autowired
	private SqlSession session;
	
	@Test
	public void doTest() {
		testSelectByBno();
//		 testSelectByTitleOrContent();
//		 testSelectByUserid();
//		 testDeleteBoard();
//		 testUpdateBoard();
//		 testInsertBoard();
		
		/*
		logger.info("SqlSession: " + session);
		
		List<Board> list = 
				session.selectList(NAMESPACE + ".selectAll");
		logger.info("list size: " + list.size());
		*/
	} // end doTest()
	
	private void testInsertBoard() {
		Board b = new Board();
		b.setTitle("MyBatis 테스트");
		b.setContent("Spring MyBatis SqlSession 테스트입니다...");
		b.setUserid("admin");
		
		int result = session.insert(NAMESPACE + ".insert", b);
		logger.info("insert 결과: " + result);
	} // end testInsertBoard()
	
	private void testUpdateBoard() {
		Board b = new Board(26, "수정 테스트", "TEST 테스트", null, null);
		int result = session.update(NAMESPACE + ".update", b);
		logger.info("update 결과: " +  result);
	} // end testUpdateBoard()

	private void testDeleteBoard() {
		int result = session.delete(NAMESPACE + ".delete", 2);
		logger.info("삭제 결과: " + result);
	} // end testDeleteBoard()
	
	private void testSelectByUserid() {
		List<Board> list =
				session.selectList(NAMESPACE + ".selectByUserid", "%dm%");
		for (Board b : list) {
			logger.info(b.toString());
		}
	} // end testSelectByUserid()
	
	private void testSelectByTitleOrContent() {
		Map<String, String> args = new HashMap<>();
		args.put("title", "%태기%");
		args.put("content", "%태기%");
		
		List<Board> list =
				session.selectList(NAMESPACE + ".selectByTitleOrContent", args);
		for (Board b : list) {
			logger.info(b.toString());
		}
		
	} // end testSelectByUseridOrContent()
	
	private void testSelectByBno() {
		Board b = session.selectOne(
				NAMESPACE + ".selectByBno", 2);
		logger.info("bno: " + b.getBno());
		logger.info("title: " + b.getTitle());
		logger.info("content: " + b.getContent());
		logger.info("userid: " + b.getUserid());
		logger.info("regdate: " + b.getRegdate());
	}
	
	
} // end class TestSqlSession






