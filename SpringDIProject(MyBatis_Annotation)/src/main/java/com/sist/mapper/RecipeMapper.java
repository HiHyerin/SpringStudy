package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.RecipeVO;

public interface RecipeMapper {

	@Select("select no, title, chef, rownum "
			+ "from (select no,title,chef from recipe order by no asc) " 
			+ "where rownum<=30")
	
	public List<RecipeVO> recipeListData();
}


