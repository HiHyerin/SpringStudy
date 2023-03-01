package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FooterMapper;
import com.sist.vo.DataBoardVO;
import com.sist.vo.NoticeVO;

@Repository
public class FooterDAO {
	@Autowired
	private FooterMapper mapper;

//	@Select("select no, name, subject, to_char(regdate,'YYYY-MM-DD') as dbday, rownum "
//			+ "from (select no, name, subject, regdate "
//			+ "from project_notice order by no desc) "
//			+ "where rownum<=5")
	public List<NoticeVO> noticeDataTop5(){
		return mapper.noticeDataTop5();
	}

//	@Select("select no, name, subject, to_char(regdate,'YYYY-MM-DD') as dbday, rownum "
//			+ "from (select no, name, subject, regdate "
//			+ "from spring_databoard order by no desc) "
//			+ "where rownum<=5")
	public List<DataBoardVO> databoardDataTop5(){
		return mapper.databoardDataTop5();
	}
}
