package edu.spring.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import oracle.jdbc.OracleDriver;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // web.xml 파일의 설정을 사용
@ContextConfiguration (
		locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
) // root-context.xml, servlet-context.xml 파일의 설정 사용
public class TestOracleJdbc {
	// Log 사용
	private static final Logger logger =
			LoggerFactory.getLogger(TestOracleJdbc.class);
	
	// Oracle JDBC 사용
	private static final String URL =
			"jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "scott";
	private static final String PASSWORD = "tiger";
	
	@Test
	public void doJdbcTest() throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = 
				DriverManager.getConnection(URL, USER, PASSWORD);
		logger.info("JDBC 연결 성공: conn=" + conn);
		
		PreparedStatement pstmt = 
				conn.prepareStatement("select * from test_board");
		ResultSet rs = pstmt.executeQuery();
		int count = 0;
		while (rs.next()) {
			count++;
		}
		logger.info("test_board size = " + count);
		
		rs.close();
		pstmt.close();
		conn.close();
		logger.info("JDBC 연결 해제 성공");
	}

}







