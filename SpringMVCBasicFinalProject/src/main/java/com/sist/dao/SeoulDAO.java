package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;
import com.sist.vo.SeoulVO;
@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
//	@Select("select no, title, poster, num "
//			+ "from (select no, title, poster, rownum as num "
//			+ "from (select no, title, poste "
//			+ "from seoul_location order by no acs)) "
//			+ "where num between #{start} and #{end}")
	public List<SeoulVO> seoulLocationListData(Map map){
		return mapper.seoulLocationListData(map);
	}

//	@Select("select ceil(count(*)/20.0) from seoul_location")
	public int seoulTotalPage() {
		return mapper.seoulTotalPage();
	}

	//////////////////////////////////////////////////////
//	@Select("select * from seoulLocation where no=#{no}")
	public SeoulVO seoulDetailData(int no) {
		return mapper.seoulDetailData(no);
	}
}
