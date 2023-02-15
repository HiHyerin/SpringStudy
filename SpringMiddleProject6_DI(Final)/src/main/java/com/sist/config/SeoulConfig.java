package com.sist.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.sist.*")
@MapperScan(basePackages = "com.sist.mapper")
public class SeoulConfig {
	
	@Bean("ds")
	public BasicDataSource basicDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		ds.setMaxActive(10); // 최대 사용할 수 있는 connection 객체
		ds.setMaxIdle(10); // 사용가능한 connection 객체
		ds.setMaxWait(-1); // connection전체 사용중에 있을 때 대기시간
		
		return ds;
	}
	
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(basicDataSource());
		return ssf.getObject();
	}

}
