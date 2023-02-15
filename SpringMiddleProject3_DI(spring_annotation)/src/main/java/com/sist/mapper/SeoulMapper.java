package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.SeoulVO;
public interface SeoulMapper {
	@Select("select no, title, address from seoul_location")
	public List<SeoulVO> seoulListData();
}
