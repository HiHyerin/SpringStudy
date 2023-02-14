package com.sist.di1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app1.xml");
		Sawon sa1 = (Sawon)app.getBean("sa1"); 
		System.out.println("사번:"+sa1.getSabun());
		System.out.println("이름:"+sa1.getName());
		System.out.println("직위:"+sa1.getJob());
		System.out.println("부서:"+sa1.getDept());
		System.out.println("연봉:"+sa1.getPay());
	}
}
