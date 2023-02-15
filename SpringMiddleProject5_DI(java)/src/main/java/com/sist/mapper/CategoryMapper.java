package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface CategoryMapper {

	@Select("select cno, title, subject from project_category order by cno")
	public List<CategoryVO> categoryListData();
}
