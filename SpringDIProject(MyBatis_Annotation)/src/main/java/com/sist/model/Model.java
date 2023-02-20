package com.sist.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Component
public class Model {
	@Autowired
	private FoodDAO fdao;
	@Autowired
	private RecipeDAO rdao;
	@Autowired
	private GoodsDAO gdao;
	
	public void setRdao(RecipeDAO rdao) {
		this.rdao = rdao;
	}
	
	public void recipeListData() {
		List<RecipeVO> list = rdao.recipeListData();
		for(RecipeVO vo:list) {
			System.out.println(vo.getNo()+"."+vo.getTitle()+"("+vo.getChef()+")");
		}
	}
	public void foodListData() {
		List<FoodVO> list = fdao.foodListData();
		for(FoodVO vo:list) {
			System.out.println(vo.getFno()+"."+vo.getName()+"("+vo.getType()+")");
		}
	}
	public void goodsListData() {
		List<GoodsVO> list = gdao.goodsListData();
		for(GoodsVO vo:list) {
			System.out.println(vo.getNo()+"."+vo.getGoods_name()+"("+vo.getGoods_price()+")");
		}
	}
	
}
