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
	
	////////////////////////////////////////////////////////////
	// 주소별 검색
//		@Select("select fno, name, poster, score, num "
//				+ "from (select fno, name, poster, score, rownum as num "
//				+ "from (select fno, name, poster, score "
//				+ "from food_location "
//				+ "where address LIKE '%'||#{adress}||'%' order by fno asc)) "
//				+ "where num between #{start} and #{end}")
		public List<FoodVO> foodLocationFindData(Map map){
			return mapper.foodLocationFindData(map);
		}
		
		// 상세보기
//		@Select("select * from food_location "
//				+ "where fno=#{fno}")
		public FoodVO foodLocationDetailData(int fno) {
			return mapper.foodLocationDetailData(fno);
		}
		
		// 총페이지
//		@Select("select ceil(count(*)/20.0) "
//				+ "from food_location "
//				+ "where address like '%'||#{address}||'%'")
		public int foodFindTotalPage(String address) {
			return mapper.foodFindTotalPage(address);
		}
		////////////////////////////////////////////////////////////
		
		////////////////////////////////////////////////////////////
		//Top-N
//		@Select("select fno, name, address, rownum "
//				+ "from (select fno, name, address "
//				+ "from project_food order by hit desc) "
//				+ "where rownum<=7")
		public List<FoodVO> foodTop7(){
			return mapper.foodTop7();
		}
}
