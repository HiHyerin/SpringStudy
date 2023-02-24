package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
//	@Select("select fno, name, poster, num "
//			+ "from(select fno, name, poster, rownum as num "
//			+ "from(select fno, name, poster "
//			+ "from food_location order by fno asc)) "
//			+ "where num between #{start} and #{end}")
	public List<FoodVO> foodListData(Map map){
		return mapper.foodListData(map);
	}
	
//	@Select("select ceil(count(*)/20.0) from food_location")
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	
//	<select id="foodFindData" resultType="FoodVO" parameterType="hashmap">
	public List<FoodVO> foodFindData(Map map){
		return mapper.foodFindData(map);
	}
//	<select id="foodFindCount" resultType="int" parameterType="hashmap">
	public int foodFindCount(Map map) {
		return mapper.foodFindCount(map);
	}
	
}
