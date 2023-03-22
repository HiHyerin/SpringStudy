package com.sist.board.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.board.entity.BoardEntity;

@Repository
public interface BoardDAO extends JpaRepository<BoardEntity, Integer>{// integer은 id값에 따라 달라짐
	public BoardEntity findByNo(@Param("no") Integer no); // 상세보기
	// findByNo == select * from board where no=
	// findByName, findByLikNameLike(String name) findByNameOrSubject => where name= or subject=
	// 자동 : save, remove
	// 검색 : findBy(Column명)
	// @Query
	@Query(value="SELECT no, name, subject, content, pwd, regdate, hit "
			+ "FROM board ORDER BY no DESC "
			+ "LIMIT :start,10",nativeQuery = true)
	public List<BoardEntity> boardListData(@Param("start") int start);

	@Query(value="select ceil(count(*)/10.0) from board", nativeQuery = true)
	public int boardTotalPage();

	// save(insert, update)
	// delete
}
