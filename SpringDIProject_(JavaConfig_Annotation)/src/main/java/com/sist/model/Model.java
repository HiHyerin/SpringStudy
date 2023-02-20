package com.sist.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.BookVO;
@Component
public class Model {
	@Autowired
	private BookDAO dao;
	
	public void bookCategory() {
		List<String> list = dao.bookCategory();
		int i = 1;
		for(String bn : list) {
			System.out.println(i+"."+bn);
			i++;
		}
	}
	
	public void bookListData(String type) {
		List<BookVO> list = dao.bookCategoryListData(type);
		for(BookVO vo:list) {
			System.out.println(vo.getTitle()+"{"+vo.getPrice()+"}");
		}
	}
}
