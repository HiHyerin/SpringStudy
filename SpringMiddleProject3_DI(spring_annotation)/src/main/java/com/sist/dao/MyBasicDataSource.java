package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

// app.xml에 있는 bean을 자바로 코딩하고 있는 중
/*
 	 <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
 	p:driverClassName="oracle.jdbc.OracleDriver"
 	p:url="jdbc:oracle:thin:@localhost:1521:XE"
 	p:username="hr"
 	p:password="happy"
 	p:maxActive="10"
 	p:maxIdle="10"
 	p:maxWait="-1"
 />
 */
@Component("ds")
public class MyBasicDataSource extends BasicDataSource {
	public MyBasicDataSource() {
		setDriverClassName("oracle.jdbc.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
		setMaxActive(10);
		setMaxIdle(10);
		setMaxWait(-1);
	}
}
