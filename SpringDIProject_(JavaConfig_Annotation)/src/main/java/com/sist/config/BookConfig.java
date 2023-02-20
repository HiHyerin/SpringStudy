package com.sist.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // app.xml대신 사용 (스프링 셋팅 파일)
// 어노테이션 메모리 할당 요청
@ComponentScan(basePackages = {"com.sist.*"})

// 인터페이스 구현
@MapperScan(basePackages = {"com.sist.mapper"})
@PropertySource("classpath:/db.properties")
// <util:properties id="db" location="classpath:db.properties"/>
public class BookConfig {
	@Value("${db.driver}")
	private String driver;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	
	@Bean("ds")
//	<bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
	public BasicDataSource basicDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	@Bean("ssf")
//	<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
//	p:configLocation="classpath:Config.xml"
//	p:dataSource-ref="ds"
///>
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(basicDataSource());
		return ssf.getObject();
	}
	
}
