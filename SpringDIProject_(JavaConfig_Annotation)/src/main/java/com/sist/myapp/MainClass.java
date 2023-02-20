package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import java.util.*;

import com.sist.config.BookConfig;

import com.sist.config.BookConfig;
import com.sist.model.*;
import com.sist.service.JejuService;
import com.sist.vo.JejoFoodVO;
import com.sist.vo.JejuLocationVO;
@Component
public class MainClass {
	@Autowired
	private Model model;
	@Autowired
	private JejuService js;
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app = 
				new AnnotationConfigApplicationContext(BookConfig.class);
		
		MainClass mc = (MainClass) app.getBean("mainClass");
//		System.out.println("=======카테고리=======");
//		mc.model.bookCategory();
//		System.out.println("====================");
//		Scanner scan = new Scanner(System.in);
//		System.out.print("카테고리 선택: ");
//		int no = scan.nextInt();
//		String[] cate= {
//				"",
//				"순수과학",
//				"역사",
//				"언어",
//				"총류",
//				"기술과학",
//				"종교",
//				"문학",
//				"예술",
//				"철학",
//				"사회과학"
//		};
//		System.out.println("=========실행결과==========");
//		mc.model.bookListData(cate[no]);
		
		
		
		
		System.out.println("======제주 명소======");
		//JejuService js = (JejuService)app.getBean("jejuService");
		/*
		 	@Autowired
			private JejuService js; 이걸 쓰면 위에 생략
		 */
		List<JejuLocationVO> list = mc.js.locationListData();
		for(JejuLocationVO vo:list) {
			System.out.println(vo.getTitle()+"("+vo.getPrice()+")");
		}
		System.out.println("======제주 맛집======");
		List<JejoFoodVO> list2 = mc.js.foodListData();
		for(JejoFoodVO vo:list2) {
			System.out.println(vo.getTitle()+"("+vo.getScore()+")");
		}
	}
}
