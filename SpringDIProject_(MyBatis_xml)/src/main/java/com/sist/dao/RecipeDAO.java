package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.vo.*;
public class RecipeDAO extends SqlSessionDaoSupport {
	/* recipe-mapper.xml
 	<select id="recipeListData" resultType="RecipeVO">
		select no, title, chef, rownum
		from (select no,title,chef from recipe order by no asc)
		where rownum&lt;=30
	</select>
	 */
	public List<RecipeVO> recipeListData(){
		return getSqlSession().selectList("recipeListData");
		// list일 땐 selectList, 하나 일 떈 selectOne
		/*
		 	resultType="RecipeVO"일 떄
		 	List<RecipeVO> => selectList
		 	RecipeVO => selectOne
		 */
	}
}
