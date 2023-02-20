package com.sist.myapp;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.sist.sawon.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext app = 
				new GenericXmlApplicationContext("app.xml");
		Sawon sa = app.getBean("sa1",Sawon.class);
		sa.print();
		app.close();
	}

}
