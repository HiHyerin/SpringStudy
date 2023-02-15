package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.SeoulVO;
public interface SeoulMapper {
	
	// <select>
	@Select("select no, title, msg, address from ${seoul_tbl}")
	public List<SeoulVO> seoulListData(Map map);
	
	
	
	
	@Select("select no, title, msg, address From ${seoul_tbl} "
			+ "where no=#{no}")
	public SeoulVO seoulDetailData(Map map);
	// xml없애고 여기에 다 써
}
