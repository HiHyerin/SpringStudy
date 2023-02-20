package com.sist.myapp;
/*
 	어노테이션
 	1. 메모리 할당 (객체생성)
 		@Component
 			|
 		---------------------------------------------------------
 		|			|			|			|					|
 	@Repository  @Service	@Controller  @RestController	@ControllerAdvice
 	
 	-------------------------------------------------------------------------
 	=> 기능별로 구분
	 	@Repository  : DAO 클래스인걸 알려줌
	 	@Service	
	 	@Controller  
	 	@RestController	
	 	@ControllerAdvice
 	-----------------------------------
 	
 	2. 주입 DI (메모리 할당x)
 		@Qualifier : 특정 객체를 지정
 		@Inject : 주입
 		@Autowired : 자동주입 => 스프링에 의해서 객체를 찾아 자동으로 메모리 주소를 넘겨준다(객체주소)
 		@PostConstructor : init-method
 		@PreDestroy : destroy-method
 		
 		
 	3. 공통모듈 : AOP
 		@Aspect
 			@Before
 			@After
 			@Around
 			@After-Returning
 			@After-Throwing
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.vo.*;
import com.sist.manager.*;


@Component // 스프링에 관리요청(객체생성 => DI => 객체소멸) => 메모리할당(DL => id 안쓰면 자동으로 id생성 => mainClass)

public class MainClass {
	@Autowired
	private MovieManager mm; // 생성된 주소값을 스프링으로부터 받아온다.
							 // 지역변수는 제어 할 수 없다
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
//		MainClass mc = (MainClass)app.getBean("mainClass");
//		while(true) {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("==========메뉴==========");
//		System.out.println("1. 일일박스오피스");
//		System.out.println("2. 실시간 예매율");
//		System.out.println("3. 좌석점유율");
//		System.out.println("4. 온라인상영관 일일");
//		System.out.println("5. 종료");
//		System.out.println("======================");
//		System.out.print("메뉴선택: ");
//		int no = scan.nextInt();
//		if(no==5) break;
//		List<MovieVO> list = mc.mm.movieListData(no);
//		for(MovieVO vo:list) {
//			System.out.println(vo.getRank()+" "+vo.getTitle()+" "+vo.getGenre()+" "+vo.getDirector());
//		}
//		}
		
		// naver news
		NewsManager n = (NewsManager)app.getBean("newsManager");
		Scanner scan = new Scanner(System.in);
		System.out.print("검색어 입력:");
		String fd = scan.next();
		
		List<NewsVO> list = n.newsListData(fd);
		for(NewsVO vo:list) {
			System.out.println(vo.getTitle());
			System.out.println(vo.getDescription());
			System.out.println(vo.getPubDate());
			System.out.println("====================================");
		}

	}

}
