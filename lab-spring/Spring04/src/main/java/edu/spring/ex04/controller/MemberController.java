package edu.spring.ex04.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.ex04.domain.Member;
import edu.spring.ex04.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	private static final Logger logger =
			LoggerFactory.getLogger(MemberController.class);

	@Autowired private MemberService memberService;
	
	@RequestMapping(value = "/login", 
			method = RequestMethod.GET)
	public void login(String url, Model model) {
		logger.info("login() GET 호출");
		logger.info("url: {}", url);
		
		if (url != null) {
			model.addAttribute("loginTarget", url);
		}
	}
	
	@RequestMapping(value = "/login-post",
			method = RequestMethod.POST)
	public void login(Member m, Model model) {
		logger.info("login() POST 호출");
		logger.info("userid: {}, password: {}",
				m.getUserid(), m.getPassword());
		
		Member member = memberService.login(m);
		logger.info("member: {}", member);
		
		model.addAttribute("member", member);
	}
	
	@RequestMapping(value = "/logout",
			method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		logger.info("logout() 호출");
		request.getSession().invalidate();
		
		// 로그아웃 이후에 board 메인 페이지로 이동
		return "redirect:/board/list";
	}
	
} // end class MemberController
















