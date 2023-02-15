package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.SeoulConfig;
import com.sist.dao.SeoulDAO;
import java.util.*;
import com.sist.vo.*;
@Component
public class MainClass {
	@Autowired
	private SeoulDAO dao;
	public static void main(String[] args) {
//		ApplicationContext app = 
//				new ClassPathXmlApplicationContext("app.xml");
		
		AnnotationConfigApplicationContext app = 
				new AnnotationConfigApplicationContext(SeoulConfig.class);
		System.out.println("=====메뉴=====");
		System.out.println("1.명소");
		System.out.println("2.자연&관광");
		System.out.println("3.쇼핑");
		System.out.println("4.호텔");
		System.out.println("5.게스트하우스");
		System.out.println("==============");
		
		String[] table = {"","location","nature","shop","hotel","guest"};
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴 선택 : ");
		int menu = scan.nextInt();
		
		Map map = new HashMap<>();
		map.put("seoul_tbl", "seoul_"+table[menu]); // #{seoul_tbl}로 넘어감
		
		MainClass mc = app.getBean("mainClass",MainClass.class); // 형변환 시켜도 되고 지금처럼 써도되고
							//		---------
							//		자동 아이디(앞에 소문자)
		List<SeoulVO> list = mc.dao.seoulListData(map);
		for(SeoulVO vo:list) {
			System.out.println(vo.getNo()+"."+vo.getTitle()+"("+vo.getAddress()+")");
		}

	}

}
