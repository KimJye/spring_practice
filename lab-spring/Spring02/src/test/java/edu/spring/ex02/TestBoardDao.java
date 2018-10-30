package edu.spring.ex02;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.Board;
import edu.spring.ex02.persistence.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
	locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
)
public class TestBoardDao {
	private static final Logger logger =
			LoggerFactory.getLogger(TestBoardDao.class);
	
	@Autowired
	private BoardDao dao;
	
	@Test
	public void doTest() {
//		testRead();
		testReadUserid();
	}
	
	private void testRead() {
		List<Board> list = dao.read();
		for (Board b : list) {
			logger.info(b.getBno() + " : " 
					+ b.getTitle() + " : "
					+ b.getUserid());
		}
	}
	
	private void testReadUserid() {
		List<Board> list = dao.read("태", "test");
		for (Board b : list) {
			logger.info(b.getBno() + " : " 
					+ b.getTitle() + " : "
					+ b.getUserid() + " : "
					+ b.getContent());
		}
	}

}






