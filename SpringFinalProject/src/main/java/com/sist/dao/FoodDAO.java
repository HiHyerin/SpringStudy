package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
//	@Select("select cno, title, poster "
//			+ "from project_category order by cno asc")
	public List<CategoryVO> categoryListData(){
		return mapper.categoryListData();
	}
	
//	@Select("select title, subject from project_category "
//			+ "where cno=#{cno}")
	public CategoryVO categoryInfoData(int cno) {
		return mapper.categoryInfoData(cno);
	}
	
//	@Select("select fno, name, poster, score, tel, address, type "
//			+ "from project_food "
//			+ "where cno=#{cno}")
	public List<FoodVO> foodListData(int cno){
		return mapper.foodListData(cno);
	}
	
//	@Update("update porject_food set "
//			+ "hit=hit+1 "
//			+ "where fno=#{fno}")
//	public void foodHitIncrement(int fno);
	
//	@Select("select * from project_food "
//			+ "where fno=#{fno}")
	public FoodVO foodDetailData(int fno) {
		mapper.foodHitIncrement(fno);;
		return mapper.foodDetailData(fno);
	}
	public FoodVO foodCookieDetailData(int fno) {
		mapper.foodHitIncrement(fno);;
		return mapper.foodDetailData(fno);
	}
}
