package com.sist.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;
public interface EmpMapper {
	/*
	 	select empno, ename, job, dname, loc
	 	from emp, dept
	 	where emp.deptno = dept.deptno

	 	=> ResultSet rs = ps.executeQuery()
	 	while(rs.next()){
	 		EmpVO vo = new EmpVO();
	 		vo.setEmpno(rs.getInt("empno"))
	 		...
	 		...
	 		vo.setDname(rs.getString("dname")) => empvo에 setter가 존재하지 않음
	 		  => vo.getDVO().setDname(rs.getString("dname")
	 		   + vo.getDVO().setLoc
	 	}

	 */
	// join
	@Results({
		@Result(property = "dvo.dname", column = "dname"),
		@Result(property = "dvo.loc", column = "loc")
	})
	@Select("select empno, ename, job, to_char(hiredate,'YYYY-MM-DD') as dbday, sal, dname, loc "
			+ "from emp, dept "
			+ "where emp.deptno = dept.deptno "
			+ "order by sal desc")
	public List<EmpVO> empListData();
}
