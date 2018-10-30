package edu.spring.ex03.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // Aspect 클래스임을 선언
@Component // 스프링 프레임워크에게 Java bean으로 관리(component-scan의 대상)
public class SampleAspect {
	
	// Pointcut: advice가 적용될 지점
	@Before(
	"execution(void edu.spring.ex03.service.SampleServiceImple.doService())"
	)
	// Advice: 여러 서비스에서 공통적으로 사용되는 기능
	public void startLog() {
		System.out.println("----------------------");
		System.out.println("로깅 기능을 시작합니다.");
		System.out.println("----------------------");
	}

	@After(
	"execution(* edu.spring.ex03.service.*Imple.*(..))"
	)
	public void endLog() {
		System.out.println("----------------------");
		System.out.println("모든 로그 파일을 저장합니다.");
		System.out.println("----------------------");
	}
}




