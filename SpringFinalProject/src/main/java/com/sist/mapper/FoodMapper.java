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
	
	// 주소별 검색
	@Select("select fno, name, poster, score, num "
			+ "from (select fno, name, poster, score, rownum as num "
			+ "from (select fno, name, poster, score "
			+ "from food_location "
			+ "where address LIKE '%'||#{address}||'%' order by fno asc)) "
			+ "where num between #{start} and #{end}")
	public List<FoodVO> foodLocationFindData(Map map);
	
	// 상세보기
	@Select("select * from food_location "
			+ "where fno=#{fno}")
	public FoodVO foodLocationDetailData(int fno);
	
	// 총페이지
	@Select("select ceil(count(*)/20.0) "
			+ "from food_location "
			+ "where address like '%'||#{address}||'%'")
	public int foodFindTotalPage(String address);
	
	///////////////////////////////////////////////////////////////////////
	
	// 인기맛집7
	@Select("select fno, name, address, score, rownum "
			+ "from (select fno, name, address, score "
			+ "from project_food order by hit desc) "
			+ "where rownum<=7")
	public List<FoodVO> foodTop7();
	
}
