package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.mapper.SeoulMapper;

import lombok.Setter;

public class SeoulDAO {
	@Setter
	private SeoulMapper mapper;
	
	//@Select("select no, title, msg, address from ${seoul_btl}")
	public List<SeoulVO> seoulListData(Map map){
		return mapper.seoulListData(map);
	}
	
	//@Select("select no, title, msg, address From ${seoul_tbl} "
			//+ "where no=#{no}")
	public SeoulVO seoulDetailData(Map map) {
		return mapper.seoulDetailData(map);
	}
}
