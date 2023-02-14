package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class FoodDAO extends SqlSessionDaoSupport{
	public List<FoodVO> foodListData(){
		
		return getSqlSession().selectList("foodListData");
		/* selectList = while
		 	while(rs.next()){
		 	FoodVO vo = new FoodVO();
		 	vo.setFno(rs.getInt("fno"))
		 	...
		 	...
		 	list.add(vo);
		 */
	}
	
	public FoodVO foodDetailData(int fno) {
		return getSqlSession().selectOne("foodDetailData",fno);
		/*
		 	FoodVO vo = new FoodVO();
		 	vo.setFno(rs.getInt("fno"))
		 	..
		 	..
		 */
	}
}
