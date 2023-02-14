package com.sist.main;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String path="C:\\springDev\\springStudy\\SpringBasicProject6_DI\\src\\main\\java\\com\\sist\\main\\app.xml";
        ApplicationContext app=
        		new ClassPathXmlApplicationContext(path);
        Sawon sa=(Sawon)app.getBean("sa");
        System.out.println("이름:"+sa.getName());
	}

}