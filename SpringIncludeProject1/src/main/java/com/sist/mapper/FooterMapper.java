package com.sist.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.DataBoardVO;
import com.sist.vo.NoticeVO;
public interface FooterMapper {
	@Select("select no, name, subject, to_char(regdate,'YYYY-MM-DD') as dbday, rownum "
			+ "from (select no, name, subject, regdate "
			+ "from project_notice order by no desc) "
			+ "where rownum<=5")
	public List<NoticeVO> noticeDataTop5();

	@Select("select no, name, subject, to_char(regdate,'YYYY-MM-DD') as dbday, rownum "
			+ "from (select no, name, subject, regdate "
			+ "from spring_databoard order by no desc) "
			+ "where rownum<=5")
	public List<DataBoardVO> databoardDataTop5();


}
