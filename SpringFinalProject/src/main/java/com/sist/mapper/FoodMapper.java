package com.sist.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;

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

	////////////////////////////////////////////////////////

	// 맛집명을 가지고 온다 (한글자 이상, 중복x)
	@Select("select distinct name from food_location "
			+ "where length(name)>1 and name !='라구'")
	public List<String> foodGetNameData();

	// 맛집 정보 읽기
	@Select("select fno, name, poster, score, rownum "
			+ "from (select fno, name, poster, score "
			+ "from food_location order by fno asc) "
			+ "where name=#{name} and rownum=1")
	public FoodVO foodInfoData(String name);

}
