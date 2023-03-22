package com.sist.jeju.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.jeju.entity.JejuFoodEntity;

@Repository
public interface JejuFoodDAO extends JpaRepository<JejuFoodEntity, Integer>{
	
	@Query(value= "select * from jeju_food limit 0,15",nativeQuery = true)
	public List<JejuFoodEntity> JejuFoodListData();
	
	// 디테일
	public JejuFoodEntity findByNo(@Param("no") Integer no);
	
	@Query(value= "select * from jeju_food order by no desc limit :start,20",nativeQuery = true)
	public List<JejuFoodEntity> JejuFoodAllListData(@Param("start") Integer start);
	
	@Query(value= "select * from jeju_food "
			+ "where title like concat('%',:title,'%') order by no desc limit :start,20",nativeQuery = true)
	public List<JejuFoodEntity> JejuFoodFindListData(@Param("start") Integer start, @Param("title") String title);
	
	@Query(value="select ceil(count(*)/20.0) from jeju_food", nativeQuery = true)
	public int jejuFoodTotalPage();
	
	@Query(value="select ceil(count(*)/20.0) from jeju_food "
			+ "where title like concat('%',:title,'%')", nativeQuery = true)
	public int jejuFoodFindPage(@Param("title") String title);

}
