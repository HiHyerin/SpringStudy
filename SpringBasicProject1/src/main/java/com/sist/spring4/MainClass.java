package com.sist.spring4;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:\\springDev\\springStudy\\SpringBasicProject1\\src\\main\\java\\com\\sist\\spring4\\app.xml";
		ApplicationContext app = new ClassPathXMLApplicationContext(path);
		AModel a = (AModel)app.getBean("a");
		a.display();
		
		BModel b = (BModel)app.getBean("b");
		b.display();
	}

}
