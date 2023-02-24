package com.sist.dao;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EmpVO {
	private int empno, sal, mgr, deptno;
	private String ename, job;
	private Date hiredate;
}
