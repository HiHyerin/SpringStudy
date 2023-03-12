package com.sist.vo;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EmpVO {
	private int empno, sal, deptno, comm;
	private String ename, job, dbday;
	private Date hiredate;
	private DeptVO dvo = new DeptVO(); //조인
}
