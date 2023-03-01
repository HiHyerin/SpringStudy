package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;

public interface FoodMapper {
	@Select("select cno, title, subject, poster "
			+ "from project_category")
	public List<CategoryVO> categoryListData();

	@Select("select fno,cno,name,address,poster,tel,type,score "
			+ "from project_food "
			+ "where cno=#{cno}")
	public List<FoodVO> foodListData(int cno);

	@Select("select title, subject from project_category where cno=#{cno}")
	public CategoryVO categoryInfoData(int cno);

	@Select("select * from project_food where fno=#{fno}")
	public FoodVO foodDetailData(int fno);

}
