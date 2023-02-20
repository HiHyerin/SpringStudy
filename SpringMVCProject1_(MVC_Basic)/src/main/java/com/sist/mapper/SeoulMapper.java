package com.sist.mapper;
import com.sist.dao.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface SeoulMapper {
	@Select("select no,title,poster,num "
		  + "from (select no,title,poster,rownum as num "
		  + "from (select no,title,poster "
		  + "from seoul_location order by no asc)) "
		  + "where num between #{start} and #{end}") //map의 키이름과 동일해야 한다
	//vo가 가지고 있지 않는 start, end => Map 사용!! (매개변수는 1개)
	public List<SeoulVO> seoulListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_location")
    public int seoulTotalPage();

}
