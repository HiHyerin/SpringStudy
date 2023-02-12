package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository //DAO라는 의미 => Spring(메모리할당)
public class EmpDAO {
	// Mapper = interface => 구현된 클래스를 받는다
	
	@Autowired //자동구현 클래스? 
	private EmpMapper mapper;
	
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
}
