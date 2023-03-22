package com.sist.food.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.food.entity.CategoryEntity;

@Repository
public interface CategoryDAO extends JpaRepository<CategoryEntity,Integer> {
	@Query(value="SELECT cno, title, subject, poster, link from project_category",nativeQuery = true)
	public List<CategoryEntity> categoryListData();
}
