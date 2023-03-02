package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface FoodMapper {
	@Select("select cno, title, poster, subject from project_category")
	public List<CategoryVO> categoryListData();
	
	@Select("select fno, cno, name, tel, address, type, poster, score "
			+ "from project_food "
			+ "where cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
	
	@Select("select title, subject from project_category "
			+ "where cno=#{cno}")
	public CategoryVO categoryInfoData(int cno);
	
	@Select("select * from project_food "
			+ "where fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	@Select("select fno, name, poster, num "
			+ "from (select fno, name, poster, rownum as num "
			+ "from (select fno, name, poster "
			+ "from food_location where address like '%'||#{addr}||'%' order by fno asc)) "
			+ "where num between#{start} and #{end}")
	public List<FoodVO> foodSearchData(Map map);
	
	@Select("select ceil(count(*)/20.0) "
			+ "from food_location "
			+ "where address like '%'||#{addr}||'%'")
	public int foodSearchTotalPage(Map map);
	
	@Select("select * from food_location "
			+ "where fno=#{fno}")
	public FoodVO foodLocationDetailData(int fno);
}
