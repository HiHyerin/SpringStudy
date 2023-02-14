package com.sist.myapp;
/*
 	Spring 에서 해주는 역할
 	------------------- 클래스 관리자(객체의 생명주기 =>  생성~소멸) => 컨테이너
 	모든 클래스가 아니다(XML에 등록된 클래스만..)
 	
 */
public class BModel {
	public void display() {
		System.out.println("BModel:display() Call..");
	}
}
