package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.JejuMapper;
import com.sist.vo.JejuFoodVO;
import com.sist.vo.JejuLocationVO;
@Repository
public class JejuDAO {
	@Autowired
	private JejuMapper mapper;

//	@Select("select no, title, poster, num "
//			+ "from (select no, title, poster, rownum as num "
//			+ "from (select no, title, poster "
//			+ "from jejuLocation order by no asc)) "
//			+ "where num between #{start} and #{end}")
	public List<JejuLocationVO> jejuLocationListData(Map map){
		return mapper.jejuLocationListData(map);
	}

//	@Select("select ceil(count(*)/20.0) from jejuLocation")
	public int jejuTotalPage() {
		return mapper.jejuTotalPage();
	}

//	@Select("select no, title, poster, num "
//			+ "from (select no, title, poster, rownum as num "
//			+ "from (select no, title, poster "
//			+ "from jejuFood order by no asc)) "
//			+ "where num between #{start} and #{end}")
	public List<JejuFoodVO> jejuFoodListData(Map map){
		return mapper.jejuFoodListData(map);
	}

//	@Select("select ceil(count(*)/20.0) from jejuFood")
	public int jejuFoodTotalPage() {
		return mapper.jejuFoodTotalPage();
	}
	
//	@Select("select * from jejuFood "
//			+ "where no=#{no}")
	public JejuFoodVO jejuDetailData(int no) {
		return mapper.jejuDetailData(no);
	}
}
