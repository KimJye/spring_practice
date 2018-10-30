package edu.spring.ex04.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value = "/list",
			method = RequestMethod.GET)
	public void listBoard() {
		logger.info("listBoard() 호출");
		
	} // end listBoard()

	@RequestMapping(value = "/register",
			method = RequestMethod.GET)
	public void boardRegister() {
		logger.info("boardRegister() 호출");
		
	}
	
} // end class BoardController

















