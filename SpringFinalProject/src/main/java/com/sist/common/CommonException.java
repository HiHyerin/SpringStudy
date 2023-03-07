package com.sist.common;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
/*
 *    스프링 : 객체 생성 ~ 소멸 (필요시마다 호출이 가능 => 기본 싱글턴) => 핵심만 코딩
 *   1. 메모리 할당 (제외: VO (사용자 정의 데이터형) , Mapper(인터페이스))  ==> 기능별 분리해서 저장
 *      @Component => OpenAPI (일반 클래스)
 *      @Repository => DAO (저장소: 데이터베이스 관련) => 테이블 1개 연결
 *      @Service => DAO가 여러개인 경우 (Join,SubQuery...)
 *      ------------------------------------------------- 1) Service VS DAO
 *      @Controller : 브라우저와 연결 (DispatcherServlet이 위임) : 파일명 (화면 이동)
 *      @RestConroller : 다른 프로그램과 연결 (자바스크립트와 연결,Kotlin연결) => JSON / JSONP
 *      @ControllerAdvice : Controller에서 공통 예외처리
 *      @RestConrollerAdvice : RestController에서 공통 예외처리
 *      @Configuration: 자바로 환경설정(스프링 셋팅)
 *   2. 주입
 *      일반 문자열 주입 => @Vaule
 *      클래스 객체 주소 주입 => @Autowired , @Resource(가장 많이 사용) , @Qualifier
 *                                       ----------------------- 특정 객체 지정
 *                       =>  @Autowired + @Qualifier = @Resource
 *                       =>  @Qualifier("id명"), @Resource(name="id명") => JDK1.8 (JDK1.8 호환성 가장 좋다)
 *                                                                        ======= 썬
 *   => DI / AOP / Transaction
 *   => 자바
 *      => 캡슐화 VS 은닉화
 *      => 상속 VS 포함
 *      => 오버로딩 VS 오버라이딩
 *      => 추상 클래스 VS 인터페이스
 *      => 객체란?
 *      => 예외처리의 종류 ( 예외 복구 / 예외 회피 )
 *      => 컬렉션의 종류 (List,Map,Set)
 *                             ----- 이중 for
 *      => 쓰레드 부분
 *   => 오라클
 *      => JOIN / SUBQuery / View
 *      => Index(******************************)
 *      => Proceduce VS Function VS Trigger
 *      => 데이터형 (BLOB , BFILE)
 *   => HTML / CSS
 *      시멘텍 / GET / POST
 *   => JSP
 *      GET/POST
 *      Cookie/Session
 *      MVC
 *   => Front-END : VueJS / ReactJS 차이점 => 장점 단점
 *      자바스크립트 : var/let/const , Arrow함수 , 클로저 => ajax/axios
 *   => 면접관 : 5명 => 3문제 (15문제)
 *   => 프로젝트 => 인성 면접 (자기소개서)
 */
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
/*
 *    1. RuntimeException : NumberFormatException/NullPointerException/ClassCastException
 *    2. SQLException
 *    3. IOException
 *    4. Exception
 */
public class CommonException {
  @ExceptionHandler(RuntimeException.class)
  public void runtimeException(RuntimeException ex)
  {
	  System.out.println("==================runtimeException===============");
	  System.out.println(ex.getMessage());
	  System.out.println("=================================================");
  }
  @ExceptionHandler(SQLException.class)
  public void sqlException(SQLException ex)
  {
	  System.out.println("==================sqlException===================");
	  System.out.println(ex.getMessage());
	  System.out.println("=================================================");
  }
  @ExceptionHandler(IOException.class)
  public void ioException(IOException ex)
  {
	  System.out.println("==================IOException====================");
	  System.out.println(ex.getMessage());
	  System.out.println("=================================================");
  }
  @ExceptionHandler(Exception.class)
  public void exception(Exception ex)
  {
	  System.out.println("==================runtimeException===============");
	  System.out.println(ex.getMessage());
	  System.out.println("=================================================");
  }
}









