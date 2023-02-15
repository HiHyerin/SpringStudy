package com.sist.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 *  public class A
 *  {
 *     @Autowired =>FIELD
 *     private B b;
 *  
 *     @Autowired => CONSTRUCTOR
 *     public A(B b)
 *     {
 *     }
 *  
 *     @Autowired => PARAMETER, METHOD
 *     public void setB(B b)
 *     {
 *     }
 *  
 *  }
 */

@Component("ssf")
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{
   //p:dataSource-ref="ds" => setter에 값을 채워라
   //@Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
   // source => override
   @Autowired
   public void setDataSource(DataSource dataSource) {
      // TODO Auto-generated method stub
      super.setDataSource(dataSource);
   }
   /*
    * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
      p:dataSource-ref="ds" 
      /> 
    */
   
   
}