package com.sist.anno;

import org.springframework.stereotype.Repository;

@Repository("mysql")
public class MySQL implements MyDAO{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("MySQL에 연결");
	}

}
