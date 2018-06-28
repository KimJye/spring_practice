package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller

public class LogoutController{
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("�α׾ƿ� ó��");
		session.invalidate();
		return "login.jsp";
		/*
		//1.�������� ����� ���� ��ü�� ���� �����Ѵ�.
		HttpSession session = request.getSession();
    	session.invalidate();
    
    	//2.���� ���� ��, ���� ȭ������ �̵��Ѵ�.
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("redirect:login.jsp");//View ���� ����
    	return mav;
	*/
	}
}
