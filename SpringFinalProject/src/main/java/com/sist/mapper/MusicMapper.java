package com.sist.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.MusicVO;

public interface MusicMapper {
	@Select("select no, title, singer, poster, album "
			+ "from melon_cjw order by no asc")
	public List<MusicVO> musicAllData();

	@Select("select * from melon_cjw "
			+ "where no=#{no}")
	public MusicVO musicDetailData(int no);
}
