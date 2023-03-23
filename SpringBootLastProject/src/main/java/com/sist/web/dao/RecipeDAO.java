package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.RecipeEntity;

@Repository
public interface RecipeDAO extends JpaRepository<RecipeEntity, Integer> {
	@Query(value="select * from recipe limit :start,20", nativeQuery = true)
	public List<RecipeEntity> recipeListData(@Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/20.0) from recipe", nativeQuery = true)
	public int recipeTotalPage();
}
