package com.sist.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// XML, Container 호출
/*
 	1) 스프링에 등록할 클래스 제작 => Model, DAO, Manager...(기능을 가지고 있는 클래스)
 	2) 제외 : 사용자 정의 데이터형 => VO, DTO, Bean
 	3) XML을 이용해서 등록
 	4) ====================== 스프링 라이브러리에서 처리(ApplicationContext)
 	5) 등록된 클래스를 ApplicationContext에서 얻어와서 구현
 	6) ApplicationContext에서 등록된 클래스를 소멸
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		// ClassPath => src/main/java
		AModel a = (AModel)app.getBean("a");
		a.display();
		System.out.println("a="+a);
		
		AModel b = (AModel)app.getBean("a");
		b.display();
		System.out.println("b="+b);
	}

}
