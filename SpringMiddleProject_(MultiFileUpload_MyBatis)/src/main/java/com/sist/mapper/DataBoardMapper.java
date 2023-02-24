package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.dao.*;

/*
 	mapper의 기능
 	1. 목록 출력 (페이징, 총페이지) -> 인라인뷰
 	2. 데이터 추가 => 파일업로드 => List
 	3. 데이터 수정
 	4. 데이터 삭제 => 파일 삭제
 	5. 데이터 상세보기 => 다운로드 => 리턴형 void(controller : String, void)
 	6. 데이터 검색(오늘의 핵심) => mybatis 동적쿼리
 								trim, foreach, choose, when...
 */
public interface DataBoardMapper {
	//1. 목록
	@Select("select no, subject, name, to_char(regdate,'YYYY-MM-DD') as dbday, hit, filecount, num "
			+ "from (select no, subject, name, regdate, hit, filecount, rownum as num "
			+ "from (select /*+ index_desc(spring_databoard sd_no_pk)*/no, subject, name, regdate, hit, filecount "
			+ "from spring_databoard)) "
			+ "where num between #{start} and #{end}")
	public List<DataBoardVO> dataBoardListData(Map map);
	
	//총페이지
	@Select("select ceil(count(*)/10.0) from spring_databoard")
	public int databoardTotalPage();
	
	//2. 데이터 추가
	// 시퀀스 만들기(selectkey) 
	@SelectKey(keyProperty = "no", resultType = int.class, before = true, 
			statement = "select nvl(Max(no)+1,1) as no from spring_databoard")
	
	@Insert("insert into spring_databoard(no,name,subject,content, pwd, filename, filesize, filecount) "
			+ "values(#{no}, #{name}, #{subject}, #{content}, #{pwd}, #{filename}, #{filesize}, #{filecount})")
	//======> selectkey + insert 함께 써야한다(따로쓰면 안됨, 한문장임)
	public void databoardInsert(DataBoardVO vo);
	
	
	//3. 상세보기
	@Update("update spring_databoard SET "
			+ "hit=hit+1 "
			+ "where no=#{no}")
	public void hitIncrement(int no);
	
	@Select("select no, name, subject, content, to_char(regdate,'YYYY-MM-DD') as dbday, hit,"
			+ "filename, filesize, filecount "
			+ "from spring_databoard "
			+ "where no=#{no}")
	public DataBoardVO databoardDetailData(int no);
	
	
	// 4. 삭제
	@Select("select pwd from spring_databoard where no=#{no}")
	public String databoardGetPassword(int no);
	
	@Select("select filename, filesize, filecount from spring_databoard where no=#{no}")
	public DataBoardVO databoardFileinfoData(int no);
	
	@Delete("delete from spring_databoard where no=#{no}")
	public void databoardDelete(int no);
	
	
	@Update("update spring_databoard set "
			+ "name=#{name}, subject=#{subject}, content=#{content} "
			+ "where no=#{no}")
	public void databoardUpdate(DataBoardVO vo);
	
	//<select id="databoardFindData" resultType="DataBoardVO" parameterType="hashmap"> => mapper.xml
	public List<DataBoardVO> databoardFindData(Map map);


	@Select({
			"<script>"
			+ "select count(*) from spring_databoard "
			+ "where "
			+ "<trim prefixOverrides=\"OR\">"
			+ "<foreach collection=\"fsArr\" item=\"fd\">"
			+ "<trim prefix=\"OR\">"
			+ "<choose>"
			+ "<when test=\"fd=='N'.toString()\">"
			+ "name LIKE '%'||#{ss}||'%'"
			+ "</when>"
			+ "<when test=\"fd=='S'.toString()\">"
			+ "subject LIKE '%'||#{ss}||'%'"
			+ "</when>"
			+ "<when test=\"fd=='C'.toString()\">"
			+ "content LIKE '%'||#{ss}||'%'"
			+ "</when>"
			+ "</choose>"
			+ "</trim>"
			+ "</foreach>"
			+ "</trim>"
			+ "</script>"
			})
	
	public int FindCount(Map map);

}







 