package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
    private StudentDAO dao;
    
	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext(new String[]{"application-context.xml","application-datasource.xml"});
        MainClass mc=(MainClass)app.getBean("mc");
        
        /*StudentVO vo=new StudentVO();
        vo.setName("심청이");
        vo.setKor(95);
        vo.setEng(85);
        vo.setMath(88);
        mc.dao.studentInsert(vo);
        System.out.println("저장 완료");*/
        List<StudentVO> list=mc.dao.studentListData();
        for(StudentVO vo:list)
        {
        	System.out.println(vo.getHakbun()+" "
        			+vo.getName()+" "
        			+vo.getKor()+" "
        			+vo.getEng()+" "
        			+vo.getMath()+" "
        			+vo.getTotal()+" "
        			+vo.getAvg());
        }
        StudentVO vo=mc.dao.studentDetailData(2);
        System.out.println(vo.getHakbun()+" "
    			+vo.getName()+" "
    			+vo.getKor()+" "
    			+vo.getEng()+" "
    			+vo.getMath()+" "
    			+vo.getTotal()+" "
    			+vo.getAvg());
        
	}

}