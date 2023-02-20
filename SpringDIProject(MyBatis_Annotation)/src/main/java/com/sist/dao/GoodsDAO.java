package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;
@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	public List<GoodsVO> goodsListData(){
		return mapper.goodsListData();
	}
}
