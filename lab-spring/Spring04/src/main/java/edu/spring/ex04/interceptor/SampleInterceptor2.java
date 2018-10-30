package edu.spring.ex04.interceptor;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.util.proxy.MethodHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor2 
	extends HandlerInterceptorAdapter {
	
	private static final Logger logger =
			LoggerFactory.getLogger(SampleInterceptor2.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("sample2::preHandle() 호출");
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		logger.info("method: {}", method);
		// 콘트롤러 메소드의 프로토타입(리턴 타입, 메소드 이름, 매개변수)
		
		logger.info("bean: {}", handlerMethod.getBean());
		// 생성된 콘트롤러 클래스 객체의 이름과 주소
		
		// preHandle() 메소드의 리턴값:
		// 1) true: 콘트롤러 메소드가 실행됨
		// 2) false: 콘트롤러 메소드가 실행되지 않음
//		return super.preHandle(request, response, handler);
		return true;
		
	} // end preHandle
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
		logger.info("sample2::postHandle() 호출");
		
		Map<String, Object> model = mav.getModel();
		String data = (String) model.get("data");
		logger.info("data: {}", data);
		
		if (data == null) {
			model.put("data", "Dummy 데이터");
		} else {
			model.put("data", data + " 수정됨");
		}
		
		// Session 객체를 얻어옴
		HttpSession session = request.getSession();
		session.setAttribute("data2", "테스트 세션 데이터");
		
		super.postHandle(request, response, handler, mav);
	} // end postHandle()
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("sample2::afterCompletion() 호출");
		
		super.afterCompletion(request, response, handler, ex);
	} // end afterCompletion()
	
} // end class SampleInterceptor2



















