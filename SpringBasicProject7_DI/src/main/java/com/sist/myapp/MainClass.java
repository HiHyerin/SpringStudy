package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.config.EmpConfig;
import com.sist.dao.*;
public class MainClass {
	// 클래스와 클래스간의 상호연결 => xml(xml에서 값 주입)
	// DAO객체를 주입한다~~ 하면 => 스프링에서 생성 후 주입 (자동주입요청:@Autowired)
	private EmpDAO dao;
	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* ApplicationContext app = new ClassPathXmlApplicationContext("app.xml"); */
		AnnotationConfigApplicationContext app =
				new AnnotationConfigApplicationContext(EmpConfig.class);
		MainClass mc = (MainClass)app.getBean("mc");
		List<EmpVO> list = mc.dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					+ vo.getEname()+" "
					+ vo.getJob());
		}
	}

}
