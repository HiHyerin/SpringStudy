package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MusicMapper;
import com.sist.vo.MusicVO;
@Repository
public class MusicDAO {
	@Autowired
	private MusicMapper mapper;

//	@Select("select no, title, singer, poster, album "
//			+ "from music_cjw order by no asc")
	public List<MusicVO> musicAllData(){
		return mapper.musicAllData();
	}

//	@Select("select * from melon_cjw "
//			+ "where no=#{no}")
	public MusicVO musicDetailData(int no) {
		return mapper.musicDetailData(no);
	}
}
