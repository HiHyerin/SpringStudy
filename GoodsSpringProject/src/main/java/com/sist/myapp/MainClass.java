package com.sist.myapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.GoodsConfig;
import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;
@Component
public class MainClass {
	@Autowired
	private GoodsDAO dao;
	public static void main(String[] args) {
//		ApplicationContext app =
//				new ClassPathXmlApplicationContext("app.xml");
		
		AnnotationConfigApplicationContext app =
				new AnnotationConfigApplicationContext(GoodsConfig.class);
		
		System.out.println("=====메뉴=====");
		System.out.println("1.Goods_all");
		System.out.println("2.Goods_best");
		System.out.println("3.Goods_new");
		System.out.println("4.Goods_special");
		System.out.println("==============");
		
		String[] table= {"","all","best","new","special"};
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴선택: ");
		int menu = scan.nextInt();
		
		Map map = new HashMap<>();
		map.put("Goods_tbl", "Goods_"+table[menu]);
		
		MainClass mc = app.getBean("mainClass",MainClass.class);
		
		List<GoodsVO> list = mc.dao.goodsListData(map);
		for(GoodsVO vo:list) {
			System.out.println(vo.getNo()+"."+vo.getGoods_name()+"("+vo.getGoods_price()+")");
		}
		

	}

}
