package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface FoodMapper {

	@Select("select fno, name, tel, address, type from project_food "
			+"where cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
}
