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
	 * Before �����̽�
	 * public void beforeLog(JointPoint jp) {
	 * String method = jp.getSignature().getName();
	 * Object[] args = jp.getArgs();
	 * 
		System.out.println("[���� ó��]" +method+"()�޼ҵ� ARGS ����: "+ args[0].toString());
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
		System.out.println("[���� ó��]" +method+"()�޼ҵ� ARGS ����: "+ args[0].toString());
	}
}
