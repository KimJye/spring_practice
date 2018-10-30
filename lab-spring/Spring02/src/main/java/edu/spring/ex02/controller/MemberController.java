package edu.spring.ex02.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.ex02.domain.Member;
import edu.spring.ex02.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(MemberController.class);

	@Autowired private MemberService memberService;
	
	@RequestMapping(value = "/list",
			method = RequestMethod.GET)
	public void list(Model model) {
		logger.info("list() 호출");
		List<Member> list = memberService.select();
		model.addAttribute("memberList", list);
	}
	
	@RequestMapping(value = "/register",
			method = RequestMethod.GET)
	public void register() {
		logger.info("register() 호출");
	}
	
	@RequestMapping(value = "/register",
			method = RequestMethod.POST)
	public String register(Member m) {
		logger.info("register({}) 호출", m);
		memberService.insert(m);
		
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/detail",
			method = RequestMethod.GET) 
	public void detail(String userid, Model model) {
		logger.info("detail(userid:{}) 호출");
		Member m = memberService.select(userid);
		model.addAttribute("member", m);
	}
	
	@RequestMapping(value = "/update",
			method = RequestMethod.POST)
	public String update(Member m) {
		logger.info("update({}) 호출", m);
		memberService.update(m);
		
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/delete",
			method = RequestMethod.GET)
	public String delete(String userid) {
		logger.info("delete(userid:{}) 호출", userid);
		memberService.delete(userid);
		
		return "redirect:/member/list";
	}
	
} // end class MemberController
