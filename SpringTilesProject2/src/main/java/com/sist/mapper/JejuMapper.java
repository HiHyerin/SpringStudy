package com.sist.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.JejuFoodVO;
import com.sist.vo.JejuLocationVO;
public interface JejuMapper {
	@Select("select no, title, poster, num "
			+ "from (select no, title, poster, rownum as num "
			+ "from (select no, title, poster "
			+ "from jejuLocation order by no asc)) "
			+ "where num between #{start} and #{end}")
	public List<JejuLocationVO> jejuLocationListData(Map map);

	@Select("select ceil(count(*)/20.0) from jejuLocation")
	public int jejuTotalPage();

	@Select("select no, title, poster, num "
			+ "from (select no, title, poster, rownum as num "
			+ "from (select no, title, poster "
			+ "from jejuFood order by no asc)) "
			+ "where num between #{start} and #{end}")
	public List<JejuFoodVO> jejuFoodListData(Map map);

	@Select("select ceil(count(*)/20.0) from jejuFood")
	public int jejuFoodTotalPage();
	
	@Select("select * from jejuFood "
			+ "where no=#{no}")
	public JejuFoodVO jejuDetailData(int no);
}
