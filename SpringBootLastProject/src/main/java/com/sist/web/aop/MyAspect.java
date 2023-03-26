package com.sist.web.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

@Aspect
@Component
public class MyAspect {
	@After("execution(* com.sist.web.controller.*Controller.*(..))")
	public void after() throws Exception {
		HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getResponse();
		response.sendRedirect("../news/news_aop_react");
	}
}
