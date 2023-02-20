package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.sawon.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("app.xml");
		
		SawonSystem ss = (SawonSystem)app.getBean("ss");
		ss.print();
	}

}
