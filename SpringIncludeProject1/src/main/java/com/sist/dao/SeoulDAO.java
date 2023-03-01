package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;
import com.sist.vo.SeoulLocationVO;
@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
//	@Select("select no, title, poster, num "
//			+ "from (select no, title, poster, rownum as num "
//			+ "from select /*+ index_asc(seoul_location sl_no_pk)*/no, title, poster "
//			+ "from seoul_location)) "
//			+ "where num between #{start} and #{end}")
	public List<SeoulLocationVO> seoulLocationListData(Map map){
		return mapper.seoulLocationListData(map);
	}

//	@Select("select ceil(count(*)/20.0) from seoul_location")
	public int seoulTotalPage() {
		return mapper.seoulTotalPage();
	}
	
	
	
//	@Select("select no, title, poster, num "
//			+ "from (select no, title, poster, rownum as num "
//			+ "from (select no, title, poster "
//			+ "from seoul_nature order by no asc)) "
//			+ "where num between #{start} and #{end}")
	public List<SeoulLocationVO> seoulNatureListData(Map map){
		return mapper.seoulNatureListData(map);
	}

//	@Select("select ceil(count(*)/20.0) from seoul_naure")
	public int seoulNatureTotalPage() {
		return mapper.seoulNatureTotalPage();
	}
		
		
//	@Select("select no, title, poster, num "
//			+ "from (select no, title, poster, rownum as num "
//			+ "from (select no, title, poster "
//			+ "from seoul_shop order by no asc)) "
//			+ "where num between #{start} and #{end}")
	public List<SeoulLocationVO> seoulShopListData(Map map){
		return mapper.seoulShopListData(map);
	}

//	@Select("select ceil(count(*)/20.0) from seoul_shop")
	public int seoulShopTotalPage() {
		return mapper.seoulShopTotalPage();
	}
	
}
