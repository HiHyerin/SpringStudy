package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;
import java.util.*;
// 메모리 할당 요청
@Repository("dao")
public class SeoulDAO {
	// 그전엔 setter을 썼는데 그거 대신 autowired
	@Autowired // 자동 주입
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulListData(){
		return mapper.seoulListData();
	}
}
