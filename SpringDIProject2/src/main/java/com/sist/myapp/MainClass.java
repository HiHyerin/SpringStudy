package com.sist.myapp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		
		///////////////////////////////////////////////////////
		/*MyDAO dao = new MyDAO("oracle.jdbc.driver.OracleDriver");
		dao.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dao.setUser("hr");
		dao.setPassword("happy");*/
		///////////////////////////////////////////////////////
		// 계속 쓰기 번거로우니까 spring에 떠넘긴다(app.xml에 넣었음)
		
		ApplicationContext app =
				new ClassPathXmlApplicationContext("app.xml"); // 값 주입??
		MyDAO dao = (MyDAO)app.getBean("dao");
		// 연결
		dao.getConnection();

	}

}
