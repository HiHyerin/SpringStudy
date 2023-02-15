package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.FoodConfig;
import com.sist.service.FoodService;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;

import java.util.*;
@Component
public class MainClass {
	@Autowired
	private FoodService fs;
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app =
				new AnnotationConfigApplicationContext(FoodConfig.class);
		
		MainClass mc = (MainClass)app.getBean("mainClass");
		List<CategoryVO> cList = mc.fs.categoryListData();
		for(CategoryVO vo:cList) {
			System.out.println(vo.getCno()+"."+vo.getTitle());
		}
		
		System.out.println("=======================");
		Scanner scan = new Scanner(System.in);
		System.out.print("카테고리 번호 선택(1~30): ");
		int cno = scan.nextInt();
		List<FoodVO> fList = mc.fs.foodListData(cno);
		for(FoodVO vo:fList) {
			System.out.println(vo.getFno()+"."+vo.getName()+"("+vo.getAddress()+")");
		}
		
		
	}
}
