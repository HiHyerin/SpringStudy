package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.anno.MyDAO;

@Component("main")
public class MainClass2 {
	@Autowired

	@Qualifier("mysql") 	// 여러 객체가 있을 때 특정 객체를 지정
	// @autowired+@qualifier("mysql") = @Resource(name="mysql") => 실무에서 주로 사용
	private MyDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		MainClass2 mc = (MainClass2)app.getBean("main");
		mc.dao.connect();
		

	}

}
