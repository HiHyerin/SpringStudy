package com.sist.anno;

import org.springframework.stereotype.Repository;

@Repository("oracle")
public class Oracle implements MyDAO {

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("오라클 연결");
	}

}
