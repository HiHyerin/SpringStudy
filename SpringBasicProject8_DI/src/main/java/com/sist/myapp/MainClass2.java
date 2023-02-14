package com.sist.myapp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.fonfig.ModelConfig;
import com.sist.model.*;
public class MainClass2 {
	public static void main(String[] args) {
		/*
		 * ApplicationContext app = new ClassPathXmlApplicationContext("app2.xml");
		 */
		AnnotationConfigApplicationContext app = 
				new AnnotationConfigApplicationContext(ModelConfig.class);
		
		AModel a = (AModel)app.getBean("am");
		a.board();
		
		BModel b = (BModel)app.getBean("BModel"); // id를 쓰지 않으면 자동 id지정(클래스명)
		b.member();
		
		CModel c = new CModel();
		c.food();
	}
}
