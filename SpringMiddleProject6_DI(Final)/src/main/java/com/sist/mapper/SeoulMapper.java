package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface SeoulMapper {
	@Select("select no, title, address From ${seoul_tbl}")
	public List<SeoulVO> seoulListData(Map map);
	// ${seoul_tbl} = map의 키 이름
}
