package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	/*
	 	@Select("select cno, title, poster, subject "
			+ "from project_category "
			+ "where cno between #{start} and #{end}")
		public List<CategoryVO> categoryListData(Map map);
	 */
	
	public List<CategoryVO> categoryListData(Map map){
		return mapper.categoryListData(map);
	}
	
//	@Select("select fno, name, poster, address,tel,type "
//			+ "from project_food "
//			+ "where cno=#{cno}")
	public List<FoodVO>foodListData(int cno){
		return mapper.foodListData(cno);
	}
	
	
//	@Select("select title, subject from project_category "
//			+ "where cno=#{cno}")
	public CategoryVO categoryInfoData(int cno) {
		return mapper.categoryInfoData(cno);
	}
	
	
}
