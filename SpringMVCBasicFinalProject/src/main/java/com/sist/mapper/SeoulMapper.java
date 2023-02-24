package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.SeoulVO;

public interface SeoulMapper {
	@Select("select no, title, poster, num "
			+ "from (select no, title, poster, rownum as num "
			+ "from (select no, title, poster "
			+ "from seoul_location order by no asc)) "
			+ "where num between #{start} and #{end}")
	public List<SeoulVO> seoulLocationListData(Map map);

	@Select("select ceil(count(*)/20.0) from seoul_location")
	public int seoulTotalPage();

	////////////////////////////////////////////////////////////

	@Select("select * from seoul_location where no=#{no}")
	public SeoulVO seoulDetailData(int no);
}
