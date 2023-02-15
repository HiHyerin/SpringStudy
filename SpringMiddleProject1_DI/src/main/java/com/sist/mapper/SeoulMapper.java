package com.sist.mapper;
import java.util.*;

import com.sist.dao.SeoulLocationVO;

public interface SeoulMapper {
	// 매개변수를 두 개 이상 사용하면 오류(무조건 한개만)
	/* 여러개의 매개변수를 사용하고 싶으면 (230215 10:27)
	   	  1. ~VO
	   	  2. Map
	 */
	public List<SeoulLocationVO> seoulListData(Map map);
	public SeoulLocationVO seoulDetailData(Map map);
	//    ---------------	--------------	------
	//  	resultType			id			parameterType
}
