package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.GoodsVO;

public interface GoodsMapper {
	@Select("SELECT no, goods_name, goods_price, rownum"
			+ "FROM (select  no, goods_name, goods_price from goods_all order by no ASC) "
			+ "WHERE rownum<=30")
//	<select id="goodsListData" resultType="GoodsVO"> 와 같은 의미
//		id 가 method명 , resultType이 리턴형으로 바뀜
	
	public List<GoodsVO> goodsListData();
}
