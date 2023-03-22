package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.FoodLocationEntity;

import groovyjarjarpicocli.CommandLine.Parameters;

@Repository
public interface FoodLocationDAO extends JpaRepository<FoodLocationEntity, Integer>{
	@Query(value="select * from food_location "
			+ "where address like concat('%',:address,'%') order by fno limit :start,20", nativeQuery = true)
	public List<FoodLocationEntity> foodFindData(@Param("address") String address, @Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/20.0) from food_location "
			+ "where address like concat('%',:address,'%')", nativeQuery = true)
	public int foodFindTotalPage(String address);
	
	public FoodLocationEntity findByFno(@Param("fno") Integer fno); // 상세보기
	
	@Query(value="select * from food_location order by fno limit 0,20", nativeQuery = true)
	public List<FoodLocationEntity> foodTop20();
}
