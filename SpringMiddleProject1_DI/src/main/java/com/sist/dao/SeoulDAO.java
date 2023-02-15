package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
public class SeoulDAO {
	private SeoulMapper mapper;
	
	// 스프링에서 구현된 클래스 주소를 얻어 온다
	public void setMapper(SeoulMapper mapper) {
		this.mapper = mapper;
	}
	
	
	public List<SeoulLocationVO> seoulListData(){
		return mapper.seoulListData();
	}
	public SeoulLocationVO seoulDetailData(int no) {
		return mapper.seoulDetailData(no);
	}
	
}
