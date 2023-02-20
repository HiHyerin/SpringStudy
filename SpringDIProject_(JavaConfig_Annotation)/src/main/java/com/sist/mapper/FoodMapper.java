package com.sist.mapper;
	//private int no;
	//private String title, addr, score;

import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.sist.vo.*;
public interface FoodMapper {
	@Select("select no, title, addr, score, rownum from jejuFood Where rownum>=30")
	public List<JejoFoodVO> foodListData();
	
}
