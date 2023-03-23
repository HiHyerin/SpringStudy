package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.RecipeDAO;
import com.sist.web.entity.JejuPageVO;
import com.sist.web.entity.RecipeEntity;

@RestController
@CrossOrigin("http://localhost:3000")
public class RecipeController {
	@Autowired
	private RecipeDAO rDao;
	
	@GetMapping("recipe/recipe_list_react")
	public List<RecipeEntity> recipe_list(String page){
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int rowSize = 20;
		int start=(rowSize*curpage)-rowSize;
		List<RecipeEntity> list = rDao.recipeListData(start);
		
		return list;
		
	}
	
	@GetMapping("recipe/recipe_page_react")
	public JejuPageVO recipePageData(String page) {
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int totalpage = rDao.recipeTotalPage();
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage = totalpage;
		
		JejuPageVO vo = new JejuPageVO();
		vo.setCurpage(curpage);
		vo.setEndPage(endPage);
		vo.setStartPage(startPage);
		vo.setTotalpage(totalpage);
		
		return vo;
	}
				
}
