package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController{
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("�α��� ó��...");
		
		UserVO user = userDAO.getUser(vo);
		
		if(user!=null) {
			session.setAttribute("userName",user.getName());
			return "getBoardList.do";
		}else return "login.jsp";
		
		/*
		//1.����� �Է� ���� ����
	  	String id= request.getParameter("id");
	  	String password = request.getParameter("password");
	  	
	  	//2.DB ���� ó��
	  	UserVO vo = new UserVO();
	  	vo.setId(id);
	  	vo.setPassword(password);
	  	
	  	UserDAO userDAO = new UserDAO();
	  	UserVO user = userDAO.getUser(vo);
	  	
	  	//3.ȭ�� �׺���̼�
	  	ModelAndView mav = new ModelAndView();
	  	
	  	if(user !=null){
	  	mav.setViewName("redirect:getBoardList.do"); 
	  	}else{
	  		mav.setViewName("redirect:login.jsp");
	  	}
	  	return mav;
	  	*/
	}
}
