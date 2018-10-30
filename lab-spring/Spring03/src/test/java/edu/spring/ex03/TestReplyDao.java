package edu.spring.ex03;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex03.domain.Reply;
import edu.spring.ex03.persistence.ReplyDao;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
	locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
)
public class TestReplyDao {
	private static final Logger logger =
			LoggerFactory.getLogger(TestReplyDao.class);
	
	@Autowired private ReplyDao dao;
	
	@Test
	public void doTest() {
//		testSelectAll();
//		testInsert();
//		testUpdate();
//		dao.delete(1);
		testSelectByBno();
		
	} // end doTest()
	
	private void testSelectByBno() {
		List<Reply> list = dao.read(101);
		for (Reply r : list) {
			logger.info(r.toString());
		}
	}
	
	private void testSelectAll() {
		List<Reply> list = dao.read();
		for (Reply r : list) {
			logger.info(r.toString());
		}
	}

	private void testInsert() {
		Reply r = new Reply(0, 100, "Mapper 인터페이스 테스트",
				"guest", null);
		dao.create(r);
	}
	
	private void testUpdate() {
		Reply r = new Reply(1, 0, "update 테스트...", null, null);
		dao.update(r);
	}
	
} // end class TestReplyDao

















