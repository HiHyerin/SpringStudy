package com.sist.mapper;
import java.util.*;

import com.sist.dao.SeoulLocationVO;

public interface SeoulMapper {
	public List<SeoulLocationVO> seoulListData();
	public SeoulLocationVO seoulDetailData(int no);
	//    ---------------	--------------	------
	//  	resultType			id			parameterType
}
