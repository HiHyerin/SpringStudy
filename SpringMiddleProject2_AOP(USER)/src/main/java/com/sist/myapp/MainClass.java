package com.sist.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.model.EmpDAO;

import lombok.Setter;

public class MainClass {
	@Setter
	private EmpDAO dao;
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		MainClass mc = (MainClass) app.getBean("mc");
		mc.dao.empListData();

	}

}
