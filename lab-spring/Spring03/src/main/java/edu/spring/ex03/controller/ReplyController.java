package edu.spring.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {
	
	@RequestMapping(value = "/reply", method = RequestMethod.GET)
	public void reply(int bno, Model model) {
		model.addAttribute("bno", bno);
		
	}

}





