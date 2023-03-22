package com.sist.web.dao;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.CategoryDataMapping;
import com.sist.web.entity.CategoryEntity;
@Repository
public interface CategoryDAO extends JpaRepository<CategoryEntity, Integer> {
	@Query(value="select cno, title, poster from project_category", nativeQuery = true) // 페이지 나눌 떄 주로 사용
	public List<CategoryDataMapping> categoryListData();
	
	public CategoryEntity findByCno(@Param("cno") Integer cno); // 상세보기
	
	@Query(value="select * from project_category "
			+ "where cno between :start and :end", nativeQuery = true)
	public List<CategoryEntity> categoryChangeData(@Param("start") Integer start, @Param("end") Integer end); 
}
