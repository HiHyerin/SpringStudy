package com.sist.spring2;

public class MainClass {
	public static void main(String[] args) {
		Hello hello = new HelloImpl();
		String msg = hello.sayHello("Ω…√ª¿Ã");
		System.out.println(msg);
	}
}
