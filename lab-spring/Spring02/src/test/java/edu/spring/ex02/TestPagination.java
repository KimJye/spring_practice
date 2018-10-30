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
import edu.spring.ex02.pageutil.PaginationCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
	locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
)
public class TestPagination {
	private static final String NAMESPACE =
			"edu.spring.ex02.BoardMapper";
	
	private static final Logger logger =
			LoggerFactory.getLogger(TestPagination.class);

	@Autowired
	private SqlSession session;
	
	@Test
	public void doTest() throws InterruptedException {
//		testBulkInsert();
//		testTotalCount();
		testSelectPage(new PaginationCriteria(2, 10));
		
	} // end doTest()
	
	private void testBulkInsert() throws InterruptedException {
		// 더미(dummy) 데이터 100개를 insert
		for (int i = 1; i <= 100; i++) {
			Board b = new Board();
			b.setTitle("Dummy Title " + i);
			b.setContent("Dummy Content " + i);
			b.setUserid("admin");
			
			session.insert(NAMESPACE + ".insert", b);
			Thread.sleep(100);
		}
	}
	
	private void testTotalCount() {
		int cnt = session.selectOne(NAMESPACE + ".totalCount");
		logger.info("total count: {}", cnt);
	}
	
	private void testSelectPage(PaginationCriteria c/*int start, int end*/) {
//		Map<String, Integer> args = new HashMap<>();
//		args.put("start", start);
//		args.put("end", end);
		
		List<Board> list =
				session.selectList(NAMESPACE + ".selectPage", c);
		for (Board b : list) {
			logger.info("{} : {} : {}",
					b.getBno(), b.getTitle(), b.getUserid());
		}
	}
	
} // end class TestPagination








