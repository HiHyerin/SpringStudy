package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		EmpDAO edao = (EmpDAO)app.getBean("eDao");
		List<EmpVO> eList = edao.empListData();
		for(EmpVO vo : eList) {
			System.out.println(vo.getEmpno()+" "
					+ vo.getEname()+" "
					+ vo.getJob());
		}
		
		System.out.println("==============================");
		DeptDAO ddao = (DeptDAO)app.getBean("dDao");
		List<DeptVO> dList = ddao.empListData();
		for(DeptVO vo:dList) {
			System.out.println(vo.getDeptno()+" "
					+ vo.getDname()+" "
					+ vo.getLoc());
		}

	}

}
