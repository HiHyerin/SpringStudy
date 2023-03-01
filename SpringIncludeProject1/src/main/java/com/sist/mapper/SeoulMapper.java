package com.sist.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.SeoulLocationVO;

public interface SeoulMapper {
	@Select("select no, title, poster, num "
			+ "from (select no, title, poster, rownum as num "
			+ "from (select /*+ index_asc(seoul_location sl_no_pk)*/no, title, poster "
			+ "from seoul_location)) "
			+ "where num between #{start} and #{end}")
	public List<SeoulLocationVO> seoulLocationListData(Map map);

	@Select("select ceil(count(*)/20.0) from seoul_location")
	public int seoulTotalPage();
	
	
	
	@Select("select no, title, poster, num "
			+ "from (select no, title, poster, rownum as num "
			+ "from (select no, title, poster "
			+ "from seoul_nature order by no asc)) "
			+ "where num between #{start} and #{end}")
	public List<SeoulLocationVO> seoulNatureListData(Map map);

	@Select("select ceil(count(*)/20.0) from seoul_nature")
	public int seoulNatureTotalPage();
	
	
	@Select("select no, title, poster, num "
			+ "from (select no, title, poster, rownum as num "
			+ "from (select no, title, poster "
			+ "from seoul_shop order by no asc)) "
			+ "where num between #{start} and #{end}")
	public List<SeoulLocationVO> seoulShopListData(Map map);

	@Select("select ceil(count(*)/20.0) from seoul_shop")
	public int seoulShopTotalPage();
}


