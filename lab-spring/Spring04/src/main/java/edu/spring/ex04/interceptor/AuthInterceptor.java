package edu.spring.ex04.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor
	extends HandlerInterceptorAdapter {
	
	private static final Logger logger =
			LoggerFactory.getLogger(AuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandle() 호출");
		// 로그인 정보가 있는 지 체크하고,
		// 로그인 된 상태면(세션에 loginUserid 정보가 있는 경우), 콘트롤러 메소드를 실행
		// 로그인 안 된 상태면, 로그인 페이지로 이동
		HttpSession session = request.getSession();
		String loginUserid = 
				(String) session.getAttribute("loginUserid");
		if (loginUserid != null) { // 로그인 된 상태
			return true;
		} else { // 로그인 안 된 상태
			String redirect = getRedirectTarget(request);
			response.sendRedirect(redirect);
			
			return false;
		}
		
	} // end preHandle()
	
	public String getRedirectTarget(HttpServletRequest request) {
		String url = request.getRequestURL().toString();
		logger.info("요청 주소: {}", url);
		
		String query = request.getQueryString();
		logger.info("요청 쿼리 스트링: {}", query);
		if (query == null) {
			query = "url=" + url;
		} else {
			query += "&url=" + url;
		}
		
		return "/ex04/member/login?" + query;
	}
	
} // end class AuthInterceptor


























