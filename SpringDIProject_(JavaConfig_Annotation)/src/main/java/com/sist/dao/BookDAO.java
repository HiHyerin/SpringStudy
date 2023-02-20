package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BookMapper;
import com.sist.vo.BookVO;

@Repository("bdao")
public class BookDAO {
	// 매퍼가져오기
	@Autowired
	private BookMapper mapper;
	
//	@Select("select no, price, publisher, author, title, rownum "
//			+"from (select no, price, publisher, author, title from books order by no asc) "
//			+"where type=#{type}") // 매퍼에서 가져온거
	public List<BookVO> bookCategoryListData(String type){
		return mapper.bookCategoryListData(type);
	}
//	
//	@Select("select distinct type from book")
	public List<String> bookCategory(){
		return mapper.bookCategory();
	}
}
