package com.kimjye.demospringaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component // Bean만 Aspect가 될 수 있다.
@Aspect  // Aspect 역할을 한다고 명시
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(LogExecutionTime)") // LogExecutionTime 애노테이션 주변으로 메소드에 명시한 일들을 하라.
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // spring이 제공하는 stopWatch
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();
        stopWatch.stop();
        logger.info(stopWatch.prettyPrint());

        return result;
    }
}
