package com.sist.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.ChefVO;
import com.sist.vo.RecipeVO;

public interface ChefMapper {
	@Select("select chef, poster, mem_cont1, mem_cont3,mem_cont7, mem_cont2,num "
			+ "from(select chef, poster, mem_cont1, mem_cont3,mem_cont7, mem_cont2, rownum as num "
			+ "from(select chef, poster, mem_cont1, mem_cont3,mem_cont7, mem_cont2 "
			+ "from chef)) "
			+ "where num between #{start} and #{end}")
	public List<ChefVO> chefListData(Map map);

	@Select("select ceil(count(*)/50.0) from chef")
	public int chefTotalPage();

	//쉐프의 작품 출력
	@Select("select no, title, poster, chef, rownum "
			+ "FROM recipe "
			+ "where chef=#{chef} and rownum<=20")
	public List<RecipeVO> chefMakeRecipeData(String chef);
}
