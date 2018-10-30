package edu.spring.ex03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex03.domain.Reply;
import edu.spring.ex03.service.ReplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
	locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
)
public class TestReplyAspect {
	
	@Autowired private ReplyService service;
	
	@Test
	public void doTest() {
		int result = service.insert(
				new Reply(0, 123, "댓글 내용", "guest", null));
		System.out.println("result = " + result);
	}

}









