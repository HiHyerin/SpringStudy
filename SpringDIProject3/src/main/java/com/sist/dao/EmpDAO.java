package com.sist.dao;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sist.vo.*;
public class EmpDAO extends SqlSessionDaoSupport{
	public List<EmpVO> empListData(){
		return getSqlSession().selectList("empListData");
		// <EmpVO> List<EmpVO> org.apache.ibatis.session.SqlSession.selectList(String statement)
		// 리턴형이 empVO인 이유는 mapper에서 resultType을 EmpVO로 설정해뒀기 때문에..(형변환을 안해도 된돠)
	}
}
