package edu.spring.ex03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex03.service.ReplyService;
import edu.spring.ex03.service.SampleServiceImple;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
	locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
)
public class TestSampleAop {

	@Autowired private SampleServiceImple service;
	@Autowired private ReplyService replyService;
	
	@Test
	public void doTest() {
		service.doService();
//		replyService.select(100);
	}
	
}








