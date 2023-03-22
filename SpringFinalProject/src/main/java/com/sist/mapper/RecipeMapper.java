package com.sist.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.GoodsVO;
import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;
public interface RecipeMapper {
	@Select("select no, title, poster, chef, num "
			+ "from (select no, title, poster, chef, rownum as num "
			+ "from (select /*+index_asc(recipe recipe_no_pk)*/no, title, poster, chef "
			+ "from recipe)) "
			+ "where num between #{start} and #{end}")
	public List<RecipeVO> recipeListData(Map map);

	@Select("select ceil(count(*)/20.0) from recipe")
	public int recipeTotalPage();

	@Select("select to_char(count(*),'999,999') from recipe")
	public String recipeRowCount();
	// '999,999' => 컴마 찍는거
	
	 @Select("SELECT COUNT(*) FROM recipeDetail "
			  +"WHERE no=#{no}")
	   public int recipeDetailCount(int no);
	   
	   @Select("SELECT * FROM recipeDetail "
			  +"WHERE no=#{no}")
	   public RecipeDetailVO recipeDetailData(int no);
	   // 
	   @Select("SELECT no,goods_name,goods_price,goods_poster,rownum "
			  +"FROM (SELECT no,goods_name,goods_price,goods_poster "
			  +"FROM goods_all "
			  +"WHERE REGEXP_LIKE(goods_name,#{goods_name}) "
			  +"ORDER BY TO_NUMBER(REPLACE(REPLACE(goods_price,',',''),'원','')) ASC) "
			  +"WHERE rownum<=3")
	   public List<GoodsVO> goodsListData(String goods_name);

}
