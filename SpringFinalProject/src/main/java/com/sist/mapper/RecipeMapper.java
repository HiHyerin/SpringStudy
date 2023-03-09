package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
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
	
	
}
