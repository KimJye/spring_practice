package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect//Aspect=Point+Advice
public class AfterThrowingAdvice {

	/*
	 * After Throwing 어드바이스
	 * public void exceptionLog(JoinPoint jp, Exception exceptObj){
	 * 	String method = jp.getSignature().getName();
	 * 
	 *  System.out.println("[예외 처리]"+method+"()메소드 수행 중 발생된 예외 메시지:" + exceptObj.getMessage());
	 */
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}

	@AfterThrowing(pointcut="allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj){
		String method = jp.getSignature().getName();

		System.out.println("[예외 처리]"+method+"()메소드 수행 중 발생된 예외 메시지:" + exceptObj.getMessage());
	}
}
