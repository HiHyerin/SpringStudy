package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {
	public void select() {
		System.out.println("delete() Call..");
	}
	
	public void delete() {
		System.out.println("delete() Call..");
	}
	
	public String find(String name) {
		System.out.println("find() Call..");
		return name;
	}
}
