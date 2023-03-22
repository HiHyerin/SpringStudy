package com.sist.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.food.dao.FoodMapper;
import com.sist.food.vo.CategoryVO;
@Service
public class FoodServiceImp1 implements FoodService{
	@Autowired
	private FoodMapper mapper;


	@Override
	public List<CategoryVO> categoryListData(){
		return mapper.categoryListData();
	}
}
