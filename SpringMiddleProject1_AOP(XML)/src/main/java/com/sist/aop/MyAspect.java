package com.sist.aop;
/*
 	aspect : 공통모듈 (자주 호출)
 		공통 / 핵심
 	OOP는 공통으로 사용 할 때 => 한 개의 클래스를 이용할 때 : 메소드
 												    -----
 								= getConnection(), disConnection()
 							 여러개 클래스 이용할 때 : 클래스
 							 	= CreateConnection
 	스프링에서는 => 공통으로 사용되는 부분을 자동화 처리 => AOP -> CommonsData.foodData()
 	AOP 처리	ex) 로그파일, 트랜잭션 처리, 보안
 		1. 시점 (언제 호출할 것인지) => JoinPoint
 			1) Before 
 			2) After
 			3) AfterReturning
 			4) AfterThrowing
 			5) Around
 			
 			public String display(){
 				@Before (getConnection())    -   try 들어가기 전에 호출
 				try{
 					=======================Around (처리시간 계산) => setAutoCommit(false)
 					소스 코딩
 					
 					=======================commit
 					
 				}catch(exception e){
 					에러발생 시 => @AfterThrowing (Rollback())
 				}finally{
 					@After (disconnection())
 				}
 				
 				return ""    -   @AfterReturning(정상수행시)
 			
 			}
 		2. 어떤 메소드에서 자동화를 시킬 건지 => PointCut
 			exercution("* com.sist.main.*.*(..)")
 					   ---				- - --  => 모든 매개변수
 					   리턴형		       모든 ㄴ 클래스 
 			within("com.sist.main.*") => 패키지 단위로 모든 클래스에 적용
 		
 		3. Advice (JointPoint + PointCut) => Aspect
 		4. Weaving : 통합 => Proxy 패턴(대리자)
 			ex) public class A{
 					public void display(){
 					
 					}
 				}
 				
 				public class Proxy{
 					private A a;
 					public Proxy(A a){
 						this.a = a;
 					}
 					public void display(){
 						@Before
 						System.out.println("Before")
 						a.display()
 						
 						@After
 						System.out.println("After")
 				}
 */
public class MyAspect {
	public void getConnection() {
		System.out.println("오라클 연결");
	}
	
	public void disConnection() {
		System.out.println("오라클 닫기");
	}
}
