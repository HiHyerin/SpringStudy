package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
public interface EmpMapper {
	@Select("SELECT empno, ename, job, TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,"
			+"sal,deptno "
			+"from emp")
	public List<EmpVO> empListData(); //자동구현
}
