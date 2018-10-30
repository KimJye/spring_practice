package edu.spring.ex02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

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
public class TestDataSource {
	private static final Logger logger =
			LoggerFactory.getLogger(TestDataSource.class);
	
	// root-context.xml에 설정된 DataSource 빈(bean)을 
	// 주입(injection)받음
	// DI(Dependency Injection): 의존성 주입
	// IoC(Inversion of Control): 제어의 역전
	// tightly-coupled(밀접한 연결) vs loosely-coupled(느슨한 연결)
	// 1) tightly-coupled: 콤포넌트 혹은 시스템을 변경할 때 코드 변경이 많음
	// 2) loosely-coupled: 콤포넌트 혹은 시스템을 변경할 때 코드 변경이 최소화
	@Autowired
	private DataSource ds;
	
	@Test
	public void doTest() throws SQLException {
		logger.info("dataSource: " + ds);
		
		// DB Connection Pool에서 Connection 객체를 빌려옴
		Connection conn = ds.getConnection();
		logger.info("connection: " + conn);
		
		PreparedStatement pstmt =
				conn.prepareStatement("select * from test_board");
		ResultSet rs = pstmt.executeQuery();
		List<Board> list = new ArrayList<>();
		while (rs.next()) {
			int bno = rs.getInt(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			String userid = rs.getString(4);
			Date regdate = rs.getTimestamp(5);
			Board b = new Board(bno, title, content, userid, regdate);
			list.add(b);
		}
		logger.info("select count: " + list.size());
		
		rs.close();
		pstmt.close();
		conn.close();
		logger.info("연결 해제 성공");
	}

}







