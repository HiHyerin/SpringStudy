package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.web.entity.*;
@Repository
public interface JejuFoodDAO extends JpaRepository<JejuFoodEntity, Integer>{
	@Query(value="select * from jeju_food "
			+ "limit 0,6", nativeQuery = true)
	public List<JejuFoodEntity> jejuFoodTop6Data();
	
	@Query(value="select * from jeju_food "
			+ "order by no asc limit :start,20", nativeQuery = true)
	public List<JejuFoodEntity> jejuFoodListData(@Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/20.0) from jeju_food", nativeQuery = true)
	public int jejuFoodTotalPage();
	
	
	public JejuFoodEntity findByNo(@Param("no") Integer no);
	
	// 검색
	@Query(value="select * from jeju_food "
			+ "where title like concat('%', :title, '%') "
			+ "limit :start, 12", nativeQuery = true)
	public List<JejuFoodEntity> jejuFindData(@Param("title") String title, @Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/12.0) from jeju_food "
			+ "where title like concat('%', :title, '%') ", nativeQuery = true)
	public int jejuFindTotalPage(@Param("title") String title);
	
	
}