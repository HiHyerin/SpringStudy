package com.sist.myapp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.model.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("app.xml");
		AModel a = (AModel)app.getBean("a");
		a.board();
		
		BModel b = (BModel)app.getBean("b");
		b.member();
		
		CModel c = (CModel)app.getBean("c");
		c.food();
	}

}
