package com.sist.sawon;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Getter;
import lombok.Setter;

/*
 	스프링 역할 => 클래스 관리
 				------ 컴포넌트 여러개를 모아서 관리(컨테이너)
 	
 	스프링 => 컨테이너 (이미 제작 - 라이브러리)
 			BeanFactory
 			  |
 			ApplicationContext : 클래스를 Map에 저장(id, new 클래스()) = DI(클래스 찾아주는 역할)
 			  |														------------------getBean(id)
 			  |				   : 클래스와 클래스간 연결관계 없이 독립적으로 동작(POJO - 상속도 implements도 없음) -> 결합성이 낮은 프로그램(유지보수 유용)
 		=============================================================
 		|                              |							 |
GenericApplicationContext	AnnotationConfigApplicationContext	WebApplicationContext(MVC)
 -> 컨테이너 종료					-> 자바로 스프링 설정
 
 
 * 컨테이너 : 클래스 관리 (객체 생성~객체 소멸)
 			1) 객체 생성(메모리 할당)
 				= new (스프링에선 사용 불가)
 				= 리플렉션 : 클래스 이름으로 메모리 할당 => Class.forName()
 				객체 생성 후 id, 객체 주소 저장 <bean id="" class=""/>
 				클래스에서 제외 (~VO(데이터형))
 			2) 필요한 데이터를 설정 : DB연결, 채팅 서버 연결..
 								 필요한 멤버변수의 값을 설정
 								 ---------------
 								 = setXxx()
 								 = 생성자
 								 ---------------- DI
 								 
 			3) 메소드 호출 : 객체 생성 시 호출 : init-method
 						   객체 소멸 시 호출 : destroy-method
 			
 */


/*
 	<bean id="sa" class="com.sist.sawon.Sawon">
 		String id ="sa"
 		String cls = "com.sist.sawon.Sawon"
 		
 		Class clsName = Class.forName(cls); 클래스 정보 읽기
 		Object obj = clsName.newInstance() // 객체생성(메모리할당)
 		map.put(id,obj) => 저장(싱글턴, 저장 후에는 주소값 변경이 더이상 없다)  ------------------------------- 여기까지 스프링 내부에서 작업해줌
 		---------------------
 		 ㄴ 가져오려면 application get bean 사용
 		 app.getBean("sa") -> 프로그램에 필요한 객체를 얻어 온다
 */

/*
 	스프링 동작 과정
 	1. 스프링에서 xml을 읽는 경우
 		- setter DI, 생성자 DI 가능
 	2. annotation을 읽는 경우
 		- setter DI, 생성자 DI 불가 (값 주입이 어렵다, 라이브러리만 주입)
 	
 	3. 생명주기
 		1) 생성자 호출 (메모리 할당) - 생성자 DI 
 		2) setter DI
 		3) 프로그래머 활용
 		4) 객체 소멸
 */
public class Sawon implements InitializingBean,DisposableBean, BeanNameAware, BeanFactoryAware{
	private String name;
	private String sex;
	
	// 생성자 호출
	public Sawon() {
		System.out.println("1.스프링에서 메모리 할당 : Sawon 객체 생성...Class.forName()");
	}
	
	////////////////////////////////////////////
	// setter DI
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
		System.out.println("2. setName()을 호출 : name을 채워준다(주입=DI) => setName("+name+")");
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
		System.out.println("2. setSex()을 호출 : sex을 채워준다(주입=DI) => setSex("+sex+")");
	}
	


	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName() Call..:"+ name + " -> app.getBean(\"sa\")");
		
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() : 객체소멸");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() : SetterDI 완료 시 호출(데이터주입 완료)");
		
	}
	
	public void print() {
		System.out.println("===프로그래머 활용===");
		System.out.println("name:"+name);
		System.out.println("sex:"+sex);
	}

}
