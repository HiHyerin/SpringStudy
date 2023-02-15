package com.sist.dao;
import com.sist.vo.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;

@Repository("ddao")
public class DeptDAO {
	@Autowired
	private DeptMapper mapper;
	
	public List<DeptVO> deptListData(){
		return mapper.deptListData();
	}
}
