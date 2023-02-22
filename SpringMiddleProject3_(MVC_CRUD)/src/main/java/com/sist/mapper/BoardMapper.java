package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.dao.BoardVO;

import oracle.jdbc.logging.annotations.DefaultLevel;

// MyBatis 작업하는곳
public interface BoardMapper {
   // 목록 출력 => 페이징
   @Select("select no,subject,name,to_char(regdate,'yyyy-MM-dd') as dbday,hit,num "
        + "from (select no,subject,name,regdate,hit,rownum as num "
        + "from (select /*+ index_desc(spring_board sb_no_pk) */no,subject,name,regdate,hit "
        + "from spring_board)) "
        + "where num between #{start} and #{end}") // $ 테이블 컬럼명 // ? 를 사용하면 안된다
   // #{start => key} => map.get("start"), map.get("end)
   public List<BoardVO> boardListData(Map map);
   @Select("select ceil(count(*)/10.0) from spring_board")
   public int boardTotalPage();
   /*
    *   1. 매개변수는 반드시 1개만 설정할 수 있다 (int start, int end)
    *   2. 여러개 매개변수가 있는 경우
    *        VO(vo에 있는 변수일 경우), Map (VO에 없는 변수일 경우)
    *   3. 리턴형 => resultType => SQL문장을 실행한 결과값
    *      ROW 여러개 => List 선언
    *      ROW 1개   => VO 선언
    *      
    *   SELECT pwd FROM spring_board => List<String>
    *   SELECT pwd FROM spring_board where no =1 => String (조건으로 1개만 가져올 경우)
    */
   
   // 데이터 추가
   @Insert("insert into spring_board(no,name,subject,content,pwd) "
        + "values(sb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
   // #{name} => vo.getName()
   public void boardInsert(BoardVO vo);
   
   // 상세보기
   @Update("update spring_board set "
        + "hit=hit+1 "
        + "where no=#{no}")
   public void hitIncrement(int no);
   
   @Select("select no,name,subject,content,to_char(regdate,'yyyy-mm-dd') as dbday,hit "
        + "from spring_board "
        + "where no=#{no}")
   public BoardVO boardDetailData(int no);
   
   
   @Select("select pwd from spring_board where no=#{no}")
   public String boardGetPassword(int no);
   
   // 데이터 수정
   @Update("update spring_board set "
   		+ "name=#{name},subject=#{subject},content=#{content} "
   		+ "where no=#{no}")
   public void boardUpdate(BoardVO vo);
   
   
   // 데이터 삭제
   @Delete("delete from spring_board where no=#{no}")
   public void boardDelete(int no);
   
   // 데이터 검색
   @Select("select count(*) from spring_board "
   		+ "where ${fs} like '%'||#{ss}||'%'")
   public int boardFindCount(Map map);
   
   /*	$, #의 차이 230221 15:04
    	Where name like '%홍%'
    		 ------		-----
    		 ${fs}		#{} => 실제 데이터값
    		 
    */
   
   @Select("select no, name, subject, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit from spring_board "
	   		+ "where ${fs} like '%'||#{ss}||'%'")
	   public List<BoardVO> boardFindData(Map map);
   
}