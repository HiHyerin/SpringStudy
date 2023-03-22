package com.sist.jeju.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.jeju.entity.BoardEntity;

@Repository
public interface BoardDAO extends JpaRepository<BoardEntity, Integer>{
	@Query(value="select * from board order by no desc limit :start,10", nativeQuery = true)
	public List<BoardEntity> boardListData(@Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/10.0) from board", nativeQuery = true)
	public int boardTotalPage();
	
	public BoardEntity findByNo(int no);
	// update, insert, delete => 이미 만들어져 있다.
}
