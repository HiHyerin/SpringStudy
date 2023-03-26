package com.sist.jeju.dao;

import java.util.List;
import java.util.jar.JarEntry;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.jeju.entity.*;

import groovyjarjarpicocli.CommandLine.Parameters;
@Repository
public interface JejuDAO extends JpaRepository<JejuEntity, Integer> {
	
	@Query(value="select * from jj_hotel where grade in ('5성급','4성급','3성급','비즈니스') order by grade desc",nativeQuery = true)
	public List<JejuEntity> JejuListData();
	
	// 디테일
	public JejuEntity findByHno(@Param("hno") Integer hno);
	
	// 검색
	@Query(value="select * from jj_hotel "
			+ "where name like concat('%',:name,'%') order by hno limit :start,20", nativeQuery = true)
	public List<JejuEntity> hotelFindData(@Param("name") String addr, @Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/20.0) from jj_hotel "
			+ "where name like concat('%',:name,'%')", nativeQuery = true)
	public int hotelFindTotalPage(String name);
	
}
