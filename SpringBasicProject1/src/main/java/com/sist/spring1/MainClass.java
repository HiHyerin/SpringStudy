package com.sist.spring1;
/*
 	MainClass는 Hello클래스에 의존한다.
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello = new Hello();
		// new를 사용하면 결합성이 높아짐
		String msg = hello.sayHello("홍길동");
		System.out.println(msg);

	}

}
