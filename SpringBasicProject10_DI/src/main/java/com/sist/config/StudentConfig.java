package com.sist.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.sist.dao.StudentDAO;
import com.sist.myapp.MainClass2;

@Configuration
public class StudentConfig {
	/*application-context
	 * <bean id="mc" class="com.sist.myapp.MainClass"
			p:dao-ref="dao"
		/>
	*/
	@Bean("mc")
	public MainClass2 mainClass() throws Exception{
		MainClass2 mc= new MainClass2();
		mc.setDao(studentDAO());
		return mc;
	}

	
	/*application-datasource
	 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
			p:driverClassName="oracle.jdbc.driver.OracleDriver"
			p:url="jdbc:oracle:thin:@localhost:1521:XE"
			p:username="hr"
			p:password="happy"
		/>
		 
		 */
	
	@Bean("ds")
	public BasicDataSource basicDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
		
	/*
		<!-- DataSource정보를 MyBatis로 전송 : SqlSessionFactoryBean -->
		<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
			p:configLocation="classpath:Config.xml"
			p:dataSource-ref="ds"
		/>
		 
		 */
	
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(basicDataSource());
		Resource res = new ClassPathResource("Config.xml");
		ssf.setConfigLocation(res);
		return ssf.getObject();
	}
	
	/*
	<bean id="dao" class="com.sist.dao.StudentDAO"
		p:sqlSessionFactory-ref="ssf"
	/>
		 
	 */
	@Bean("dao")
	public StudentDAO studentDAO() throws Exception{
		StudentDAO dao = new StudentDAO();
		dao.setSqlSessionFactory(sqlSessionFactory());
		return dao;
	}
}
