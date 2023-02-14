package com.sist.myapp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass2 {
	private DeptDAO dao;
	
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}


	public static void main(String[] args) {
		String[] xml = {"application-context.xml","application-datasource.xml"};
		ApplicationContext app =
				new ClassPathXmlApplicationContext(xml);
		MainClass2 mc2 = (MainClass2)app.getBean("mc2");
		List<DeptVO> list = mc2.dao.deptListData();
		for(DeptVO vo:list) {
			System.out.println(vo.getDeptno()+" "
					+vo.getDname()+" "
					+vo.getLoc());
		}
		
		DeptVO vo = mc2.dao.deptDetailData(20);
		System.out.println(vo.getDeptno()+" "
					+vo.getDname()+" "
					+vo.getLoc());
		
	}
}
