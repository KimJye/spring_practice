package edu.spring.ex02;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
)
public class TestSqlSessionFactory {
	private static final Logger logger =
			LoggerFactory.getLogger(TestSqlSessionFactory.class);
	
	@Autowired
	private SqlSessionFactory factory;
	
	@Test
	public void doTest() {
		logger.info("SqlSessionFactory: " + factory);
		
	}

}






