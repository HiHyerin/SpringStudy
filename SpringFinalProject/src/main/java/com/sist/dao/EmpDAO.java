package com.sist.dao;
import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper; // 스프링에서만 구현 => new Mapper() => 메모리 할당
//	@Results({
//		@Result(property = "dvo.dname", column = "dname"),
//		@Result(property = "dvo.loc", column = "loc")
//	})
//	@Select("select empno, ename, job, to_char(hiredate,'YYYY-MM-DD') as dbday, sal, dname, loc "
//			+ "from emp, dept "
//			+ "where emp.deptno = dept.deptno "
//			+ "order by sal desc")
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
	
}
