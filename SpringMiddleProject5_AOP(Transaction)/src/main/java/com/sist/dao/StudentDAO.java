package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/*
 	aop => 트랜잭션, 로그파일, 보안(스프링에서 이미 제작)
 	============================================
 	JointPoint : before/after/afger-Returning/after-throwing/around => 호출되는 위치 지정
 	PointCut : 메서드 적용
 	
 	=> 1. DI
 	   2. aop
 	   3. orm(mybatis)
 	   4. mvc
 */
import com.sist.mapper.*;
@Repository
public class StudentDAO {
	@Autowired
	private StudentMapper mapper;
	
	public List<StudentVO> studentListData(){
		return mapper.studentListData();
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void studentInsert(StudentVO vo1, StudentVO vo2) {
		mapper.studentInsert(vo1);
		mapper.studentInsert(vo2);
	}
	
	
}
