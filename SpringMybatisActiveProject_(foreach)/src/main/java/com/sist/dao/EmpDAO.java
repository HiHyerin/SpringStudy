package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	
	public List<String> empNameListData(){
		return mapper.empNameListData();
	}
	public List<EmpVO> empInfoData(Map map){
		return mapper.empInfoData(map);
	}
}
