package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
//	@Select("select cno, title, poster, subject from project_category")
	public List<CategoryVO> categoryListData(){
		return mapper.categoryListData();
	}
	
//	@Select("select fno, cno, name, tel, address, type, poster "
//			+ "from project_food "
//			+ "where cno=#{cno}")
	public List<FoodVO> foodListData(int cno){
		
		return mapper.foodListData(cno);
	}
	
//	@Select("select title, subject from project_category "
//			+ "where cno=#{cno}")
	public CategoryVO categoryInfoData(int cno) {
		
		return mapper.categoryInfoData(cno);
	}
	
//	@Select("select * from project_food "
//			+ "where fno=#{fno}")
	public FoodVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	}
	
//	@Select("select fno, name, poster, num "
//			+ "from (select fno, name, poster, rownum as num "
//			+ "from (select fno, name, poste "
//			+ "from food_location where address like '%'||#{addr}||'%' order by fno asc)) "
//			+ "where num between#{start} and #{end}")
	public List<FoodVO> foodSearchData(Map map){
		return mapper.foodSearchData(map);
	}
	
//	@Select("select ceil(count(*)/20.0) "
//			+ "from food_location "
//			+ "where address like '%'||#{addr}||'%'")
	public int foodSearchTotalPage(Map map) {
		return mapper.foodSearchTotalPage(map);
	}
	
//	@Select("select * from food_location "
//			+ "where fno=#{fno}")
	public FoodVO foodLocationDetailData(int fno) {
		return mapper.foodLocationDetailData(fno);
	}
	
}
