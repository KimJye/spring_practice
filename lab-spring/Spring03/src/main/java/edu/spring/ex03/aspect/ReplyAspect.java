package edu.spring.ex03.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// Aspect = Advice(메소드) + Pointcut(메소드가 실행되는 지점)
// Join Point: pointcut들의 집합(aspect를 적용할 수 있는 서비스 메소드들)
@Aspect
@Component
public class ReplyAspect {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyAspect.class);
	
	@Before("execution(* edu.spring.ex03.service.Reply*.*(..))")
	public void beforeAdvice(JoinPoint jp) { // 3
		logger.info("***** beforeAdvice()");
		Signature signature = jp.getSignature();
		logger.info("signature: {}", signature);

		Object[] args = jp.getArgs();
		logger.info("args: " + Arrays.toString(args));
		
		Object target = jp.getTarget();
		logger.info("target: {}", target);
		
	} // end beforeAdvice()
	
	@After("execution(* edu.spring.ex03.service.Reply*.*(..))")
	public void afterAdvice() {
		logger.info("***** afterAdvice()");
	}
	
	@AfterReturning("execution(* edu.spring.ex03.service.Reply*.*(..))")
	public void afterReturningAdvice() {
		logger.info("***** afterReturningAdvice()");
	}
	
	@AfterThrowing("execution(* edu.spring.ex03.service.Reply*.*(..))")
	public void afterThrowingAdvice() {
		logger.info("***** afterThrowingAdvice()");
	}
	
	@Around("execution(* edu.spring.ex03.service.Reply*.*(..))")
	// Around Advice는
	// 1) 매개변수로 ProceedingJoinPont를 선언하고,
	// 2) advice 메소드 안에서 pjp.proceed()를 호출해야 
	// pointcut의 메소드가 실행됨
	// 3) proceed()의 결과값(리턴 값)을 반드시 리턴해야 함
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("***** aroundAdvice() 시작");
		logger.info("proceed() 실행 전");
		
		Object result = pjp.proceed();
		logger.info("proceed() 실행 후");
		logger.info("result: " + result);
		
		return result;
	}
	
} // end class ReplyAspect

















