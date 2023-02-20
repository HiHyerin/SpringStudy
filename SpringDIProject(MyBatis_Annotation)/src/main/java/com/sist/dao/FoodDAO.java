package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper; // 현재 null -> 스프링에서 구현한 클래스를 받아서 사용
	public List<FoodVO> foodListData(){
		return mapper.foodListData();
	}
}
