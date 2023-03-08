package com.sist.aop;
import com.sist.dao.FoodDAO;
import com.sist.vo.*;
import java.util.*;
import com.sist.openapi.*;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// 공통모듈 => 공통으로 적용되는 기능을 모아서 관리 => 트랜잭션, 보안 (제작되어 있음)
/*
 	트랜잭션:
 		conn.setAutoCommit(false)
 		  sql
 		  sql
 		  ...
 		  conn.commit()
 		  
 		  => conn.rollback()
 		  
 	보안 : 인증/인가
 	  => 사용자 정의 : 로그파일 => 빅데이터(데이터 수집, 데이터 전처리...) => 데이터 예측
 	  							데이터 전처리 + 데이터 분석
 	  							======================= 딥러닝
 	  							----------   ---------- 따로따로는 머신러닝
 */
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Aspect
@Component
public class CommonAspect {
	@Autowired
	private FoodDAO dao;
	@Autowired
	private NaverNewsManager mgr;
	
	@Around("execution(* com.sist.web.*Controller.*(..))") // com.sist.web에 있는 모든 Controller에 모든 메소드
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		Object obj = null;
		long start = System.currentTimeMillis(); // 시작
		System.out.println("=======================================");
		System.out.println("클라이언트 요청:"+jp.getSignature().getName());
		obj = jp.proceed(); // 메소드 호출
		System.out.println("클라이언트 요청 처리 종료");
		long end = System.currentTimeMillis(); // 끝나는 시간
		System.out.println("요청 처리에 걸린 시간:"+(end-start));
		
		return obj;
	}
	@After("execution(* com.sist.web.*FController.*(..))") // F를 붙인 이유 - restController과 구분짓기위해
	public void foodData() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<FoodVO> tList = dao.foodTop7();
		for(FoodVO vo:tList) {
			String address = vo.getAddress();
			String[] addr = address.split(" ");
			vo.setAddress(addr[1].trim());
		}
		request.setAttribute("tList", tList);
		
		List<NewsVO> nList = mgr.newsListData("맛집");
		request.setAttribute("nList", nList);
	}
	
	//////////////////////////////////////////////////////////////////
	
	
}
