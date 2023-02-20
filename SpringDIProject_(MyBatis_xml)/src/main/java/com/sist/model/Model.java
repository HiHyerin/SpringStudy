package com.sist.model;

import java.util.List;

import com.sist.dao.FoodDAO;
import com.sist.dao.GoodsDAO;
import com.sist.dao.RecipeDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;
import com.sist.vo.RecipeVO;

public class Model {
	private FoodDAO fdao;
	private GoodsDAO gdao;
	private RecipeDAO rdao;
	
	
	public void setFdao(FoodDAO fdao) {
		this.fdao = fdao;
	}



	public void setGdao(GoodsDAO gdao) {
		this.gdao = gdao;
	}



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
