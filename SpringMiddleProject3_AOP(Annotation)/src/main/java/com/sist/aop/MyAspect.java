package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect // (공통기반이라는 의미) => 메모리 할당이 안됨
@Component // 메모리 할당 O
	/* 메모리 할당 되는 어노테이션
	 	@Component
	 	@Service
	 	@Repository
	 	@Controller
	 	@RestController
	 	@ControllerAdvice
	 */
public class MyAspect {
	@Before("execution(* com.sist.dao.MyDAO.*(..))")
	public void before() {
		System.out.println("오라클 연결");
	}
	
	@After("execution(* com.sist.dao.MyDAO.*(..))")
	public void after() {
		System.out.println("오라클 해제");
	}
}
