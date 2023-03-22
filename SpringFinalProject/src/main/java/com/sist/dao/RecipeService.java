package com.sist.dao;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.mapper.ChefMapper;
import com.sist.mapper.RecipeMapper;
import com.sist.vo.*;

@Service
public class RecipeService {
	@Autowired
	private RecipeMapper rMapper;
	@Autowired
	private ChefMapper cMapper;

	//recipeMapper//////////////////////////////////////////////////////
//	@Select("select no, title, poster, chef, num "
//			+ "from (select no, title, poster, chef, rownum as num "
//			+ "from (select /*+index_asc(recipe recipe_no_pk)*/no, title, poster, chef "
//			+ "from recipe)) "
//			+ "where num between #{start} and #{end}")
	public List<RecipeVO> recipeListData(Map map){
		return rMapper.recipeListData(map);
	}

	public int recipeTotalPage() {
		return rMapper.recipeTotalPage();
	}

	public String recipeRowCount() {
		return rMapper.recipeRowCount();
	}


	//chefMapper/////////////////////////////////////////////////////
//	@Select("select chef, poster, mem_cont1, mem_cont3,mem_cont7, mem_cont2,num "
//			+ "from(select chef, poster, mem_cont1, mem_cont3,mem_cont7, mem_cont2, rownum as num "
//			+ "from(select chef, poster, mem_cont1, mem_cont3,mem_cont7, mem_cont2 "
//			+ "from chef)) "
//			+ "where num between #{start} and #{end}")
	public List<ChefVO> chefListData(Map map){
		return cMapper.chefListData(map);
	}

//	@Select("select ceil(count(*)/50.0) from chef")
	public int chefTotalPage() {
		return cMapper.chefTotalPage();
	}

//	@Select("select no, title, poster, chef, rownum "
//			+ "FROM recipe "
//			+ "where chef=#{chef} and rownum<=20")
	public List<RecipeVO> chefMakeRecipeData(String chef){
		return cMapper.chefMakeRecipeData(chef);
	}
	
	/*@Select("SELECT COUNT(*) FROM recipeDetail "
	  +"WHERE no=#{no}")*/
	public int recipeDetailCount(int no)
	{
	return rMapper.recipeDetailCount(no);
	}
	
	/*@Select("SELECT * FROM recipeDetail "
		  +"WHERE no=#{no}")*/
	public RecipeDetailVO recipeDetailData(int no)
	{
	return rMapper.recipeDetailData(no);
	}
/*
*  @Select("SELECT no,goods_name,goods_price,goods_poster,rownum "
+"FROM (SELECT no,goods_name,goods_price,goods_poster "
+"FROM goods_all "
+"WHERE goods_name LIKE '%'||#{goods_name}||'%' "
+"ORDER BY TO_NUMBER(REPLACE(REPLACE(goods_price,',',''),'원','')) ASC) "
+"WHERE rownum<=3")
public List<GoodsVO> goodsListData(String goods_name);
*/
	public List<GoodsVO> goodsListData(String goods_name)
	{
	return rMapper.goodsListData(goods_name);
	}
 }
