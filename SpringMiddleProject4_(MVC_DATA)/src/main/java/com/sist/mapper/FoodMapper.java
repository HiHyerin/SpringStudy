package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
public interface FoodMapper {
	@Select("select cno, title, poster, subject "
			+ "from project_category "
			+ "where cno between #{start} and #{end}")
	public List<CategoryVO> categoryListData(Map map);
	
	@Select("select fno, name, poster, address,tel,type,score "
			+ "from project_food "
			+ "where cno=#{cno}")
	public List<FoodVO>foodListData(int cno);
	
	@Select("select title, subject from project_category "
			+ "where cno=#{cno}")
	public CategoryVO categoryInfoData(int cno);
}
