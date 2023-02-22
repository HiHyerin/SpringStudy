package com.sist.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;

@Repository
public class BoardDAO {
	@Autowired // mapper를 구현한 클래스의 객체 주소값을 스프링으로부터 받아온다.(자동 주입)
	private BoardMapper mapper;

	/*@Select("select no, subject, name, TO_CHAR(regdate,'YYYY-MM_DD') as dbday, hit, num "
	+ "from(select no, subject, name,regdate, hit, rownum as num) "
	+ "from (select /*+index_desc(spring_board sb_no_pk) no, subject, name,regdate, hit "
	+ "from spring_board)) "
	+ "where num between #{start} and #{end}") */

	public List<BoardVO> boardListData(Map map){
		return mapper.boardListData(map);
	}

//	@Select("select ceil(count(*)/10.0) from spring_board")
	public int boardTotalPage() {
		return mapper.boardTotalPage();
	}


	/*@Insert("insert into spring_board(no,name,subject,content,pwd) "
			+ "values(sb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
	// #{name} => vo.getName() */
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}

	// 상세보기
//		@Update("update spring_board set "
//				+ "hit=hit+1 "
//				+ "where no=#{no}")
//		public void hitIncrement(int no) {
//			mapper.hitIncrement(no);
//		}

//		@Select("select no, name, subject, content, to_char(regdate,'YYYY-MM-DD') as dbday, hit "
//				+ "from spring_board"
//				+ "where no=#{no}")
		public BoardVO boardDetailData(int no) {
			mapper.hitIncrement(no);
			return mapper.boardDetailData(no);
		}
		public BoardVO boardUpdatelData(int no) {
			return mapper.boardDetailData(no);
		}
		
//		@Update("update spring_board set "
//		   		+ "name=#{name},subject=#{subject},content=#{content} "
//		   		+ "where no=#{no}")
//	   public void boardUpdate(BoardVO vo) => 일치하지 않아도 됨
		// 매퍼는 매개변수 하나만 가능, dao는 상관 없다.
		public boolean boardUpdate(BoardVO vo) {
			boolean bCheck = false;
			String db_pwd = mapper.boardGetPassword(vo.getNo());
			if(db_pwd.equals(vo.getPwd())) {
				bCheck = true;
				mapper.boardUpdate(vo);
			}
			return bCheck;
		}
		
//		 @Select("select pwd from spring_board where no=#{no}")
//		   public String boardGetPassword(int no);
		
//		@Delete("delete from spring_board where no=#{no}")
//		   public void boardDelete(int no);
		
		public boolean boardDelete(int no, String pwd) {
			boolean bCheck = false;
			// 비밀번호 읽기
			String db_pwd = mapper.boardGetPassword(no);
			if(db_pwd.equals(pwd)) {
				bCheck = true;
				mapper.boardDelete(no);
			}
			return bCheck;
		}
		
//		 @Select("select count(*) from spring_board "
//			   		+ "where ${fs} like '%'||#{ss}||'%'")
//			   public int boardFindCount(Map map); [mapper에 있는 문장]
		
		public int boardFindCount(Map map) {
			
			return mapper.boardFindCount(map); // @select 문장 실행 결과를 가져온다
		}
			   
//	   @Select("select no, name, subject, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit from spring_board "
//		   		+ "where ${fs} like '%'||#{ss}||'%'")
//		   public List<BoardVO> boardFindData(Map map); [mapper에 있는 문장]
		public List<BoardVO> boardFindData(Map map){
			return mapper.boardFindData(map); // @select 문장 실행 결과를 가져온다
		}
}
