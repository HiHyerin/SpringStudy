package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
import java.util.*;
@RestController
@CrossOrigin("http://localhost:3000")
public class JejuController {
	@Autowired
	private JejuFoodDAO fDao;
	
	@Autowired
	private JejuLocationDAO lDao;
	
	@Autowired
	private JejuProductDAO pDao;
	
	@GetMapping("jeju/food_top6")
	public List<JejuFoodEntity> jeju_top6(){
		List<JejuFoodEntity> list = fDao.jejuFoodTop6Data();
		return list;
	}
	
	@GetMapping("jeju/food_list_react")
	public List<JejuFoodEntity> jeju_food_list(String page){
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int rowSize = 20;
		int start=(rowSize*curpage)-rowSize;
		List<JejuFoodEntity> list = fDao.jejuFoodListData(start);
		return list;
	}
	
	@GetMapping("jeju/food_page_react")
	public JejuPageVO jejuPageData(String page) {
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int totalpage = fDao.jejuFoodTotalPage();
		
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
	
	
	////////////////////////////////////////////
	@GetMapping("jeju/location_list_react")
	public List<JejuLocationEntity> jeju_location_list(String page){
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int rowSize = 20;
		int start=(rowSize*curpage)-rowSize;
		List<JejuLocationEntity> list = lDao.jejuLocationListData(start);
		return list;
	}
	
	@GetMapping("jeju/location_page_react")
	public JejuPageVO jejuPageLocationData(String page) {
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int totalpage = lDao.jejuLocationTotalPage();
		
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
	
	@GetMapping("jeju/food_detail_react")
	public JejuFoodEntity food_detail(int no) {
		JejuFoodEntity vo = fDao.findByNo(no);
		return vo;
	}
	
	//////////////////////////////////////////////
	@GetMapping("jeju/product_list_react")
	public List<JejuProductEntity> jejuProductList(String page){
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start=(rowSize*curpage)-rowSize;
		List<JejuProductEntity> list = pDao.jejuProductList(start);
		return list;
	}
	
	@GetMapping("jeju/product_page_react")
	public JejuPageVO jejuPageProductData(String page) {
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int totalpage = pDao.jejuProductTotalPage();
		
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
