package edu.spring.ex04.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 인터셉터 클래스는 HandlerInterceptor를 상속받아서 만듬
// Interface HandlerInterceptor
// |__ Interface AsyncHandlerInterceptor
//     |__ Class HandlerInterceptorAdapter
public class SampleInterceptor 
	extends HandlerInterceptorAdapter {
	private static final Logger logger =
			LoggerFactory.getLogger(SampleInterceptor.class);
	
	// 지정된 콘트롤러 메소드의 실행 이전에 요청을 가로챔
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("***** preHandle() 호출");
		
		return super.preHandle(request, response, handler);
	} // end preHandle()
	
	// 지정된 콘트롤러 메소드의 처리가 끝난 후
	// & DispatcherServlet이 View(화면)을 만들기 전
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("***** postHandle() 호출");
		
		super.postHandle(request, response, handler, modelAndView);
	} // end postHandle()
	
	// 요청에 대한 모든 처리가 끝나고 View(화면)도 완성된 상태에서 실행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("***** afterCompletion() 호출");

		super.afterCompletion(request, response, handler, ex);
	}
	
} // end class SampleInterceptor







