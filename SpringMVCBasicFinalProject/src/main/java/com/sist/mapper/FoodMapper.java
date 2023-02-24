package com.sist.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
public interface FoodMapper {
	 // 동적쿼리 (<if>, <choose>, <forEach> : IN, <trim>, <where>, <set>) => 다중 조건문
	// MyBatis => 핵심, Join, SubQuery, Procedure, Function, Trigger
	@Select({
	 "<script>"
	 +"select cno, title, poster, subject "
	 + "from project_category "
	 + "where "
	 + "<if test = 'cno==1'>"
	 + "cno between 1 and 12"
	 + "</if>"
	 + "<if test = 'cno==2'>"
	 + "cno between 13 and 18"
	 + "</if>"
	 + "<if test = 'cno==3'>"
	 + "cno between 19 and 30"
	 + "</if>"
	 + "</script>"
 }) // 원래 컨트롤러 에서 썼던것들
	public List<CategoryVO> categoryListData(Map map);




	// 카테고리별 목록 출력
	@Select("select fno, name, poster, address,tel,type,score "
			+ "from project_food "
			+ "where cno=#{cno}")
	public List<FoodVO>foodListData(int cno);


	@Select("select title, subject from project_category "
			+ "where cno=#{cno}")
	public CategoryVO categoryInfoData(int cno);


	// 상세보기
	@Select("select * from project_food "
			+ "where fno=#{fno}")
	public FoodVO foodDetailData(int fno);

	//검색
	@Select({
		"<script>"
		+ "select fno, name, poster, num "
		+ "from (select fno, name, poster, rownum as num "
		+ "from (select fno, name, poster "
		+ "from food_location "
		+ "<if test=\"ss!='all'\">"
		+ "where address like '%'||#{ss}||'%'"
		+"</if>"
		+ "order by fno asc)) "
		+ "where num between #{start} and #{end}"
		+ "</script>"

	})
	public List<FoodVO> foodFindData(Map map);
}
