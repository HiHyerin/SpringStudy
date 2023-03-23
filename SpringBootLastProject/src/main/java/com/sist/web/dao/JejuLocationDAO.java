package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.JejuLocationEntity;

@Repository
public interface JejuLocationDAO extends JpaRepository<JejuLocationEntity, Integer> {
	@Query(value="select * from jeju_location "
			+ "order by no asc limit :start,20", nativeQuery = true)
	public List<JejuLocationEntity> jejuLocationListData(@Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/20.0) from jeju_location", nativeQuery = true)
	public int jejuLocationTotalPage();
}
