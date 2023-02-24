package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.RecipeVO;
public interface RecipeMapper {
	@Select("select title, chef, poster, rownum "
			+ "from recipe "
			+ "where rownum<40 and regexp_like(title, #{menu})")// 복잡한근 xml, 간단한건 여기
	
	public List<RecipeVO> recipeFindData(String menu);
	// regexp_like : 이걸 쓰면 foreach를 쓸 필요가 없음
	/*
	 	where ename='a' or ename='b' or ename='c'
	  
	 	select * from emp
	 	where ename in('a','b','c') == 
	 	-------------------
	 	select * from emp
	 	where regxp_like(ename,'a|b|c')
	 */
}
