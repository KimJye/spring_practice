package edu.spring.ex04.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.spring.ex04.domain.Member;

public class LoginInterceptor
	extends HandlerInterceptorAdapter {

	private static final Logger logger =
			LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandle() 호출");

		return super.preHandle(request, response, handler);
	} // end preHandle()
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle() 호출");
		String target = request.getParameter("queryString");
		logger.info("target: {}", target);
		
		Map<String, Object> model = modelAndView.getModel();
		Member m = (Member) model.get("member");
		if (m != null) { // id/pw가 일치하는 사용자가 있음 - 로그인 성공
			// 세션에 로그인한 사용자의 아이디를 저장
			HttpSession session = request.getSession();
			session.setAttribute("loginUserid", m.getUserid());
			
			// 로그인 후 타겟 페이지로 이동
			response.sendRedirect(target);
		} else { // 일치하는 사용자 없음 - 로그인 실패
			// 로그인 페이지로 이동
			response.sendRedirect("/ex04/member/login?url=" 
					+ target);
		}
		
		super.postHandle(request, response, handler, modelAndView);
	} // end postHandle()
	
} // end class LoginInterceptor



















