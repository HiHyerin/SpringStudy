package com.sist.dao;
import com.sist.mapper.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	
//	@Select("select title, chef, poster, rownum "
//			+ "from recipe"
//			+ "+where rownum<40 and regexp_like(title, #{menu}")// 복잡한근 xml, 간단한건 여기
	
	public List<RecipeVO> recipeFindData(String menu){
		
		return mapper.recipeFindData(menu);
	}
}
