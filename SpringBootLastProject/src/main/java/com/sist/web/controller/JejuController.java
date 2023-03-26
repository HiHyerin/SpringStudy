package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public List<JejuProductEntity> jejuProductList(String page, String title){
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start=(rowSize*curpage)-rowSize;
		List<JejuProductEntity> pList = new ArrayList();
		if(title == null) {
			pList = pDao.jejuProductList(start);
		}else {
			pList = pDao.jejuProductFind(start, title);
		}
		 
		return pList;
	}
	
	@GetMapping("jeju/product_page_react")
	public JejuPageVO jejuPageProductData(String page, String title) {
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int totalpage = 0; 
				
		if(title == null) {
			totalpage = pDao.jejuProductTotalPage();
		}else {
			totalpage = pDao.jejuProductFindTotalPage(title);
		}
		
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
	// 검색
	@GetMapping("jeju/food_find_react")
	public List<JejuFindVO> food_find(String page, String title){
		List<JejuFindVO> list = new ArrayList<JejuFindVO>();
		if(page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		int start = (curpage*12)-12;
		List<JejuFoodEntity> fList = fDao.jejuFindData(title, start);
		int totalpage = fDao.jejuFindTotalPage(title);
		int i = 0;
		for(JejuFoodEntity fvo:fList) {
			JejuFindVO vo = new JejuFindVO();
			vo.setNo(fvo.getNo());
			vo.setPoster(fvo.getPoster());
			vo.setTitle(fvo.getTitle());
			if(i==0) {
				vo.setCurpage(curpage);
				vo.setTotalpage(totalpage);
			}
			list.add(vo);
			i++;
		}
		
		return list;
	}
	//쿠키//////////////////////////
	@GetMapping("jeju/jeju_cookie_react")
	public List<JejuFoodEntity> jeju_cookie(HttpServletRequest request){
		List<JejuFoodEntity> list = new ArrayList<JejuFoodEntity>();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("jeju")) {
					String no = cookies[i].getValue();
					JejuFoodEntity vo = fDao.findByNo(Integer.parseInt(no));
					list.add(vo);
				}
			}
		}
		return list;
	}
	
}
