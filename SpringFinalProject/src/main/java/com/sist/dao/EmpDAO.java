package com.sist.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.EmpMapper;
import com.sist.vo.EmpVO;
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
