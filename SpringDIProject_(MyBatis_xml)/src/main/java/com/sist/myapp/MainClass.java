package com.sist.myapp;
import com.sist.dao.*;
import com.sist.model.Model;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;
import com.sist.vo.RecipeVO;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {
	
	
	/*
	 * private FoodDAO fdao; private GoodsDAO gdao; private RecipeDAO rdao;
	 * 
	 * 
	 * public void setFdao(FoodDAO fdao) { this.fdao = fdao; }
	 * 
	 * 
	 * 
	 * public void setGdao(GoodsDAO gdao) { this.gdao = gdao; }
	 * 
	 * 
	 * 
	 * public void setRdao(RecipeDAO rdao) { this.rdao = rdao; }
	 	-> 모델 있으면 모델에 있어야 할 내용
	 */ 

	private Model model;

	public void setModel(Model model) {
		this.model = model;
	}

	public static void main(String[] args) {
//		MainClass mc = new MainClass(); // fdao, gdao, rdao => null
										// 주소값이 있는 dao롤 사용하려면 spring에서 생성된 객체 사용
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("app.xml"); // spring에 등록된 dao 가져오기
		
		MainClass mc = (MainClass)app.getBean("mc");
		System.out.println("=====MENU=====");
		System.out.println("1.레시피");
		System.out.println("2. 맛집");
		System.out.println("3. 상품");
		System.out.println("==============");
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴선택 : ");
		int no = scan.nextInt();
//		if(no == 1) {
//			List<RecipeVO> list = mc.rdao.recipeListData();
//			for(RecipeVO vo:list) {
//				System.out.println(vo.getNo()+"."+vo.getTitle()+"("+vo.getChef()+")");
//			}
//		}
//		
//		if(no == 2) {
//			List<FoodVO> list = mc.fdao.foodListData();
//			for(FoodVO vo:list) {
//				System.out.println(vo.getFno()+"."+vo.getName()+"("+vo.getType()+")");
//			}
//		}
//		
//		if(no == 3) {
//			List<GoodsVO> list = mc.gdao.goodsListData();
//			for(GoodsVO vo:list) {
//				System.out.println(vo.getNo()+"."+vo.getGoods_name()+"("+vo.getGoods_price()+")");
//			}
//		} => 모델로 이동
		
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
