package com.sist.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.mapper.FoodMapper;
import com.sist.mapper.LocationMapper;
import com.sist.vo.JejoFoodVO;
import com.sist.vo.JejuLocationVO;

@Service
public class JejuService {
	@Autowired

	private FoodMapper fMapper;
//	@Select("select no, title, addr, score, rownum from jejuFood Where rownum>=30")
	public List<JejoFoodVO> foodListData(){
		return fMapper.foodListData();
	}
	
	@Autowired

	private LocationMapper lMapper;
//	@Select("select title, addr, price FROM jejuLocation")
	public List<JejuLocationVO> locationListData(){
		return lMapper.locationListData();
	}
}
