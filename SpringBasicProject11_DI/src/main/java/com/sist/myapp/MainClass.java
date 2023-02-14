package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	private EmpDAO dao;
	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("application-datasource.xml");
				//설정파일이 xml이면 ApplicationContext
				// 자바면 다른거
		MainClass mc = (MainClass)app.getBean("mc");
		List<EmpVO> list = mc.dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+ vo.getJob());
		}
		
		EmpVO vo = mc.dao.empDetailData(7788);
		System.out.println(vo.getEmpno()+" "
				+vo.getEname()+" "
				+ vo.getJob());
	}

}
