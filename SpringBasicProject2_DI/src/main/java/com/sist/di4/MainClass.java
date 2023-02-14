package com.sist.di4;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class MainClass {
	/*
	 	Spring4 => XML, Annotation => 정보 노출(보안취약) => 실무
	 	Spring5 => 자바로 환경설정(.class) => 보안에 주력 => 차세대 ===> Spring-Boot
	 	
	 	= 모든 클래스를 등록하는 것이 아니다(기능(컴포넌트)을 가지고 있는 클래스 => 여러 클래스에서 호출)
	 		1) 등록에서 제외 : 데이터형(자바 기본데이터형, 사용자 정의 데이터형:~VO)
	 		2) 생성/소멸 부분은 스프링 자체 담당
	 		3) 특별한 경우가 아니면 싱글턴 (한개의 메모리 주소를 이용해서 사용)
	 */
	/*
	 	DI : 값 주입 / 메소드 호출
	 	P, Property : setter
	 	1) setter DI => setXxx()에 값을 채워라
	 		<bean>
	 			<property name="변수명" value="">
	 					  ============
	 					  name="name" value="a"	
	 					  => setName("a")
	 		</bean>
	 		
	 		<bean
	 			p:name="값" ==> setName("값")
	 			
	 	2) 생성자 DI, Constructor, c:..
	 		<bean>
	 			<constructor-arg value="1" index="0"/>
	 		</bean>
	 		
	 		class A{
	 			public A(String name){}
	 		}
	 		
	 		<bean c:_0="a">
	 		<bean c:name="a">
	 		
	 		메소드 호출이 가능
	 			= 객체 생성 : init-method="메소드명만"
	 			= 객체 소멸 : destroy-method="메소드명만"
	 			
	 		XML에 등록
	 		1) 사용자 정의 클래서
	 			= 패키지 단위로 등록 => Annotation
	 		2) 라이브러리 클래스 등록 => MyBatis, OXM, MVC(ViewResolver)
	 			= <bean>을 이용해서 필요한 클래스만 등록
	 			
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// EmpDAO dao = new EmpDAO("oracle.jdbc.driver.OracleDriver"); // null => 스프링에 등록된 클래스 객체를 얻어와서 사용
		GenericApplicationContext app=new GenericXmlApplicationContext("app4.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao"); // 스프링에 등록된 객체 얻기 
        List<EmpVO> list=dao.empListData();
        //dao.init();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "
        			+vo.getHiredate().toString()+" "+vo.getSal());
        }
        app.close();
	}
}
