package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
/*
 	private int no, price;
	private String condition, publisher, author, title, type;
 */
public interface BookMapper {
	@Select("select no, price, publisher, author, title, type, rownum "
			+"from (select no, price, publisher, author, title, type from books order by no asc) "
			+"where type=#{type}")
	public List<BookVO> bookCategoryListData(String type);
	
	@Select("select distinct type from books")
	public List<String> bookCategory();
}
