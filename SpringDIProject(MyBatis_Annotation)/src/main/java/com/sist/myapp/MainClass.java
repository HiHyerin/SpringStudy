package com.sist.myapp;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.model.Model;

@Component
// id=사용자 정의
public class MainClass {
	@Autowired
	private Model model; 
	// setter를 생성(하고 app.xml에서 <bean>태그로 받아와야함)하던가 @Autowired 어노테이션 설정
	
	
	
	public static void main(String[] args) {
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("app.xml"); // spring에 등록된 dao 가져오기
		MainClass mc = (MainClass)app.getBean("mainClass");
		// @component("mc")라고 써져있으면 app.getBean("mc")로 가져올 수 있지만
		// @Component하고  아이디?는 설정 안해놓으면 자동으로 클래스 이름에서 첫자만 소문자로 app.getBean("mainClass")fh TJdigksek.
		System.out.println("=====MENU=====");
		System.out.println("1.레시피");
		System.out.println("2. 맛집");
		System.out.println("3. 상품");
		System.out.println("==============");
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴선택 : ");
		int no = scan.nextInt();
		
		if(no==1) {
			mc.model.recipeListData();
		}
	    if(no==2)
	    {
	       mc.model.goodsListData();
	    }
	    if(no==3)
	    {
	       mc.model.foodListData();
	    }
	}
}
