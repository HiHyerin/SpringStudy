package com.sist.jeju.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.jeju.dao.JejuDAO;
import com.sist.jeju.dao.JejuFoodDAO;
import com.sist.jeju.entity.JejuEntity;
import com.sist.jeju.entity.JejuFoodEntity;

@Controller
@RequestMapping("jeju/")
public class JejuController {
	@Autowired
	private JejuDAO dao;
	
	@Autowired
	private JejuFoodDAO fDao;
	
	
	@GetMapping("hotel_detail")
	public String hotel_detail(int hno, Model model) {
		JejuEntity vo = dao.findByHno(hno);
		model.addAttribute("vo", vo);
		model.addAttribute("main_content", "jeju/hotel_detail");
		return "main";
	}
	
	@GetMapping("food_detail")
	public String food_detail(int no, Model model) {
		JejuFoodEntity vo = fDao.findByNo(no);
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(vo.getMenu(),"^" );
		while(st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		model.addAttribute("main_content", "jeju/food_detail");
		return "main";
	}
	
	@RequestMapping("hotel_find")
	public String hotel_find(String name, String page, Model model) {
		if(name == null)
			name ="제주";
		if(page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		int rowSize = 20;
		int start = (curpage*rowSize)-rowSize; // 0부터 시작
		List<JejuEntity> list = dao.hotelFindData(name, start);
		
		int totalpage = dao.hotelFindTotalPage(name);
		final int Block=10;
		int startPage=((curpage-1)/Block*Block)+1;
		int endPage=((curpage-1)/Block*Block)+Block;
		if(endPage>totalpage)
			endPage = totalpage;
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		model.addAttribute("name", name);
		model.addAttribute("main_content", "jeju/hotel_find");
		
		return "main";
	}
	@GetMapping("hotel")
	public String jeju_hotel(Model model) {
		List<JejuEntity> list = dao.JejuListData();
		model.addAttribute("list", list);
		model.addAttribute("main_content", "jeju/hotel");
		return "main";
	}
	
	@RequestMapping("food_list")
	public String jeju_food_list(Model model, String page, String title) {
		if(page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		int rowSize = 20;
		int start = (curpage*rowSize)-rowSize; // 0부터 시작
		int totalpage = 0;
		List<JejuFoodEntity> list = new ArrayList();
		if(title == null) {
			list = fDao.JejuFoodAllListData(start);
			totalpage = fDao.jejuFoodTotalPage();
		}else {
			list = fDao.JejuFoodFindListData(start, title);
			totalpage = fDao.jejuFoodFindPage(title);
		}
		final int Block=10;
		int startPage=((curpage-1)/Block*Block)+1;
		int endPage=((curpage-1)/Block*Block)+Block;
		if(endPage>totalpage)
			endPage = totalpage;
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		model.addAttribute("title", title);
		model.addAttribute("main_content", "jeju/food_list");
		return "main";
	}
}
