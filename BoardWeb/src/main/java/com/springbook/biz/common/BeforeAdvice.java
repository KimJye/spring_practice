package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect//Aspect=Point+Advice
public class BeforeAdvice {
	/*
	 * Before 어드바이스
	 * public void beforeLog(JointPoint jp) {
	 * String method = jp.getSignature().getName();
	 * Object[] args = jp.getArgs();
	 * 
		System.out.println("[사전 처리]" +method+"()메소드 ARGS 정보: "+ args[0].toString());
	}
	 */
	/*
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	*/
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method= jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[사전 처리]" +method+"()메소드 ARGS 정보: "+ args[0].toString());
	}
}
