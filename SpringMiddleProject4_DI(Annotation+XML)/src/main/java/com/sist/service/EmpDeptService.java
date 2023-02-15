package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Service
public class EmpDeptService {
	@Autowired
	private EmpMapper eMapper;
	@Autowired
	private DeptMapper dMapper;
	
	
	public List<DeptVO> deptListData(){
		return dMapper.deptListData();
	}
	public List<EmpVO> empListData(){
		return eMapper.empListData();
	}
}
