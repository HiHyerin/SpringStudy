package com.sist.model;

import java.sql.Date;

import javax.xml.crypto.Data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpVO {
	private int empno, sal;
	private String ename, job;
	private Date hiredate;
	
}
