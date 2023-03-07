package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

import lombok.Delegate;
public interface BoardMapper {
   @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
         +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
         +"FROM (SELECT /*+INDEX_DESC(spring_board sb_no_pk)*/no,subject,name,regdate,hit "
         +"FROM spring_board)) "
         +"WHERE num BETWEEN #{start} AND #{end} ")
   public List<BoardVO> boardListData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_board")
   public int boardTotalPage();
   
   @SelectKey(keyProperty = "no",resultType = int.class , before = true,
         statement = "SELECT NVL(MAX(no)+1,1) as no FROM spring_board") //시퀀스
   @Insert("INSERT INTO spring_board VALUES("
         +"#{no},#{name},#{subject},#{content},#{pwd},SYSDATE,0)")
   public void boardInsert(BoardVO vo);
   
   @Update("update spring_board set "
             + "hit=hit+1 "
             + "where no=#{no}")
   public void boardHitIncrement(int no);
   
   @Select("select no,name,subject,content,to_char(regdate,'yyyy-mm-dd') as dbday,hit "
          + "from spring_board "
          + "where no=#{no}")
   public BoardVO boardDetailData(int no);
   
   @Select("select pwd from spring_board "
   		+ "where no=#{no}")
   public String boardGetPassword(int no);
   
   @Update("update spring_board set "
   		+ "name=#{name}, subject=#{subject}, content=#{content} "
   		+ "where no=#{no}")
   public void boardUpdate(BoardVO vo); 
   
   @Delete("delete from spring_board "
   		+ "where no=#{no}")
   public void boardDelete(int no);
   
   
}