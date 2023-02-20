package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.vo.*;
public class GoodsDAO extends SqlSessionDaoSupport {
	/*
 	<select id="goodsListData" resultType="GoodsVO">
		SELECT no, goods_name, goods_price, rownum
		FROM (SELECT no, goods_name, goods_price FROM goods_all order by no ASC)
		WHERE rownum&lt;=30
	</select>
	 */
	public List<GoodsVO> goodsListData(){
		return getSqlSession().selectList("goodsListData");
	}
}
