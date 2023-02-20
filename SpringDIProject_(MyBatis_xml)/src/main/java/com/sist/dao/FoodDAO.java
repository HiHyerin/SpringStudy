package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.vo.*;

public class FoodDAO extends SqlSessionDaoSupport {
	/*
	<select id="foodListData" resultType="FoodVO">
		select fno, name, type, rownum
		from (select fno, name, type from food_location order by fno ASC)
		where <![CDATA[
			rownum<=30
		]]>
	</select>
	
		MYBATIS
		Map
		map.put("foodListData", "select fno, name, type, rownum~~
	 */
	public List<FoodVO> foodListData(){
		return getSqlSession().selectList("foodListData");
	}
}
