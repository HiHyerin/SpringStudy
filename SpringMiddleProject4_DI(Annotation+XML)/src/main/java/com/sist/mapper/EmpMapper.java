package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;
public interface EmpMapper {

	@Select("select empno, ename, job, sal, hiredate from emp")
	public List<EmpVO> empListData();
	
}
