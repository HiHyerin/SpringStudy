package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.JejuFoodVO;
import com.sist.vo.JejuLocationVO;
@Repository
public class JejuDAO {
	@Autowired
	private JejuMapper mapper;
	
	// 목록(여행지)
//		@Select("select no, tktle, poster, num "
//				+ "from (select no, tktle, poster, rownum as num "
//				+ "from (select no, tktle, poster "
//				+ "from jejuLocation order by no asc)) "
//				+ "where num between #{start} and #{end}")
		public List<JejuLocationVO> jejuLocationListData(Map map){
			return mapper.jejuLocationListData(map);
		}
		
//		@Select("select ceil(count(*)/20.0 from jejuLocation")
		public int jejuTotalPage() {
			return mapper.jejuTotalPage();
		}
		
//		   @Select("select * from jejuLocation where no=#{no}")
		   public JejuLocationVO jejuDetailData(int no) {
			   return mapper.jejuDetailData(no);
		   }
		   
//		   @Select("select no, title, poster, score, rownum "
//		   		+ "from jejuFood "
//		   		+ "where rownum<=4 and addr like '%'||#{addr}||'%'")
		   public List<JejuFoodVO> jejuFoodData(Map map){ //인근맛집
			   return mapper.jejuFoodData(map);
		   }
}
