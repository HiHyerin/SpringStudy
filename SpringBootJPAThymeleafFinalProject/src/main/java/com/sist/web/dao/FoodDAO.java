package com.sist.web.dao;
import com.sist.web.entity.*;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface FoodDAO extends JpaRepository<FoodEntity, Integer>{
	// 리스트
	public List<FoodEntity> findByCno(@Param("cno") Integer cno);

	// 상세보기
	public FoodEntity findByFno(@Param("fno") Integer fno);
}
//findByCno == where cno
//CRUD => save(): insert/update, delete():delete????