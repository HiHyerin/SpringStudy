package com.sist.myapp;
import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.sist.config.EmpConfig;
import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext app =
				new AnnotationConfigApplicationContext(EmpConfig.class);
		EmpDAO dao = (EmpDAO)app.getBean("dao");
		List<EmpVO> list = dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					+ vo.getEname()+" "
					+ vo.getJob() + " "
					+ vo.getHiredate().toString() + " "
					+ vo.getSal());
		}
	}

}
