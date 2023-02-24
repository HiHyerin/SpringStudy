package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
//	@Select("select no, subject, name, to_char(regdate,'YYYY-MM-DD') as dbday, hit, filecount, num "
//			+ "from (select no, subject, name, regdate, hit, filecount, rownum as num "
//			+ "from (select /*+ index_desc(spring_databoard sd_no_pk)*/no, subject, name, regdate, hit, filecount "
//			+ "from spring_databoard)) "
//			+ "where num between #{start} and #{end}")
	public List<DataBoardVO> dataBoardListData(Map map){
		return mapper.dataBoardListData(map);
	}
	
	//총페이지
//	@Select("select ceil(count(*)/10.0) from spring_databoard")
	public int databoardTotalPage() {
		return mapper.databoardTotalPage();
	}
	
	//2. 데이터 추가
	// 시퀀스 만들기(selectkey)
//	@SelectKey(keyProperty = "no", resultType = int.class, before = true, 
//			statement = "select nvl(Max(no)+1,1) as no from spring_databoard")
//	
//	@Insert("insert into spring_databoard(no,name,subject,content, pwd, filename, filesize, filecount) "
//			+ "values(#{no}, #{name}, #{subject}, #{content}, #{pwd}, #{filename}, #{filesize}, #{filecount})")
	public void databoardInsert(DataBoardVO vo) {
		mapper.databoardInsert(vo);
	}
	
	
	//3. 상세보기
//	@Update("update spring_databoard SET "
//			+ "hit=hit+1 "
//			+ "where no=#{no}")
//	public void hitIncrement(int no) {
//		
//	}
	
//	@Select("select no, name, subject, content, to_char(regdate,'YYYY-MM-DD') as dbday, hit,"
//			+ "filename, filesize, filecount "
//			+ "from spring_databoard "
//			+ "where no=#{no}")
	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement(no);// 조회수 증가
		return mapper.databoardDetailData(no);
	}
	
	// 4. 삭제
//	@Select("select pwd from spring_databoard where no=#{no}")
//	public String databoardGetPassword(int no);
	
//	@Select("select filename, filesize, filecount from spring_databoard where no=#{no}")
	public DataBoardVO databoardFileinfoData(int no) {
		return mapper.databoardFileinfoData(no);
	}
	
//	@Delete("delete from spring_databoard where no=#{no}")
	public boolean databoardDelete(int no, String pwd) {
		boolean bCheck = false;
		String db_pwd = mapper.databoardGetPassword(no);
		if(db_pwd.equals(pwd)) {
			bCheck = true;
			mapper.databoardDelete(no);
		}
		return bCheck;
	}
	
	// 수정 데이터
	public DataBoardVO databoardUpdateData(int no) {
		return mapper.databoardDetailData(no);
	}
	
	public boolean pwdCheck(int no, String pwd) {
		boolean bCheck=false;
		String db_pwd = mapper.databoardGetPassword(no);
		if(db_pwd.equals(pwd))
			bCheck=true;
		return bCheck;
	}
	
//	@Update("update spring_databoard set "
//			+ "name=#{name}, subject=#{subject}, content=#{content} "
//			+ "where no=#{no}")
	public void databoardUpdate(DataBoardVO vo) {
		mapper.databoardUpdate(vo);
	}
	
	//<select id="databoardFindData" resultType="DataBoardVO" parameterType="hashmap"> => mapper.xml
		public List<DataBoardVO> databoardFindData(Map map){
			return mapper.databoardFindData(map);
		}
	
	public int FindCount(Map map) {
		return mapper.FindCount(map);
	}
	
}
