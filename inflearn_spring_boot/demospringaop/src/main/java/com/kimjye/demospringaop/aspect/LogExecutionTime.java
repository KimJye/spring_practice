package com.kimjye.demospringaop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Annotation 생성
@Target(ElementType.METHOD) // 이 애노테이션을 어디에 붙일 수 있는지 타겟정보 명시
@Retention(RetentionPolicy.RUNTIME) // 이 애노테이션을 사용한 코드를 런타임까지 유지를 한다고 명시
public @interface LogExecutionTime {
}
