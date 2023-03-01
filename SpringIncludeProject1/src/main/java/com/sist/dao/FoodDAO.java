package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;

//	@Select("select cno, title, subject, poster "
//			+ "from project_category")
	public List<CategoryVO> categoryListData(){

		return mapper.categoryListData();
	}

//	@Select("select fno,cno,name,address,poster,tel,type "
//			+ "from project_food "
//			+ "where cno=#{cno}")
	public List<FoodVO> foodListData(int cno){
		return mapper.foodListData(cno);
	}

//	@Select("select title, subject from project_category where cno=#{cno}")
	public CategoryVO categoryInfoData(int cno) {
		return mapper.categoryInfoData(cno);
	}

//	@Select("select * from project_food where fno=#{fno}")
	public FoodVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	}
}
