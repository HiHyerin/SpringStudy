package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface FoodMapper {
	@Select("select cno, title, poster "
			+ "from project_category order by cno asc")
	public List<CategoryVO> categoryListData();
	
	@Select("select title, subject from project_category "
			+ "where cno=#{cno}")
	public CategoryVO categoryInfoData(int cno);
	
	@Select("select fno, name, poster, score, tel, address, type "
			+ "from project_food "
			+ "where cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
	///////////////////////////////////////////////////////
	@Update("update project_food set "
			+ "hit=hit+1 "
			+ "where fno=#{fno}")
	public void foodHitIncrement(int fno); // 인기순 출력하려고
	
	@Select("select * from project_food "
			+ "where fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
