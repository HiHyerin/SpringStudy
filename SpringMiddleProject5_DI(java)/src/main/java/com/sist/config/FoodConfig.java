package com.sist.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 환경설정
@Configuration

// application-context.xml파일 대체?(bean configuration file)
@ComponentScan(basePackages = "com.sist.*")
//<context:component-scan base-package="com.sist.*"/>

@MapperScan(basePackages = "com.sist.mapper")
//<context:component-scan base-package="com.sist.mapper" factory-ref="ssf"/>
public class FoodConfig {
	@Bean("ds")
	/*
	 		<!-- db.properties 읽기 -->
			<util:properties id="db" location="classpath:db.properties"/>
			<bean id="ds" class="org.apache.commons.dbcp.BasicDataSource" 
				p:driverClassName="#{db['driver']}"
				p:url="#{db['url']}"
				p:username="#{db['username']}"
				p:password="#{db['password']}"
				p:maxActive="#{db['maxActive']}"
				p:maxIdle="#{db['maxIdle']}"
				p:maxWait="#{db['maxWait']}"
			/>
			
			<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
				p:dataSource-ref="ds"
			/>
	 */
	public BasicDataSource basicDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		ds.setMaxActive(10);
		ds.setMaxIdle(10);
		ds.setMaxWait(-1);
		
		return ds;
	}
	
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(basicDataSource());
		return ssf.getObject();
	}
}
