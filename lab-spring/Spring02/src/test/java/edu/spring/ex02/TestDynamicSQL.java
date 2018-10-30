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
public class TestDynamicSQL {
	private static final String NAMESPACE =
			"edu.spring.ex02.BoardMapper";
	private static final Logger logger =
			LoggerFactory.getLogger(TestDynamicSQL.class);
	
	@Autowired private SqlSession session;
	
	@Test
	public void doTest() {
		Map<String, Object> args = new HashMap<>();
		args.put("searchType", 3);
		args.put("searchKeyword", "%아이%");
		
		List<Board> list =
				session.selectList(NAMESPACE + ".search", args);
		logger.info("list size = {}", list.size());
	}

}







