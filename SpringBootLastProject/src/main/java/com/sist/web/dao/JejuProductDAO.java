package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.JejuProductEntity;

@Repository
public interface JejuProductDAO extends JpaRepository<JejuProductEntity, Integer>{
	@Query(value="select * from jeju_product "
			+ "order by pno asc limit :start,12", nativeQuery = true)
	public List<JejuProductEntity> jejuProductList(@Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/12.0) from jeju_product", nativeQuery = true)
	public int jejuProductTotalPage();
	
	//검색
	@Query(value = "select * from jeju_product "
			+ "where title like concat('%', :title, '%') "
			+ "limit :start, 12", nativeQuery = true)
	public List<JejuProductEntity> jejuProductFind(@Param("start") Integer start, @Param("title") String title);
	
	@Query(value = "select ceil(count(*)/12.0) from jeju_product "
			+ "where title like concat('%', :title, '%') ", nativeQuery = true)
	public int jejuProductFindTotalPage(@Param("title") String title);
}
