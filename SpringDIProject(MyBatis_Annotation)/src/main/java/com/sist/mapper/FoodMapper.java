package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("select fno, name, type, rownum "
			+ "from (select fno, name, type from food_location order by fno ASC) "
			+ "where rownum<=30")
	
	public List<FoodVO> foodListData();
	
}
