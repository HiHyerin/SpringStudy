package com.sist.vo;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
// MyBatis => 변수명 = 컬럼명 :mybatis 쓰기 편함
// 변수명 안맞으면
// <resultMap> <result property="regdate" column="hiredate">

@Setter
@Getter
public class EmpVO {
	private int empno, sal, deptno, rank;
	private String ename, job;
	private Date regdate;
	private String dname, loc;
	private int grade;
}
