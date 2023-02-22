package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.SeoulDAO;
import com.sist.vo.*;
@Controller
public class SeoulController {
	@Autowired
	private SeoulDAO dao;
	// <a href="../seoul/list.do">
	@GetMapping("seoul/list.do")
	public String seoulListData(String page, Model model ) {
		if(page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap<>();
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		List<SeoulVO> list = dao.seoulLocationListData(map);
		for(SeoulVO vo:list) {
			String title = vo.getTitle();
			if(title.length()>19) {
				title = title.substring(0, 16)+"...";
				vo.setTitle(title);
			}
			vo.setTitle(title);
		}
		
		int totalpage = dao.seoulTotalPage();
		final int BLOCK = 5;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "seoul/list";
	}
	
	//<a href="../seoul/detail.do"> 
	@GetMapping("seoul/detail.do")
	public String seoulDetailData(int no, Model model) {
		SeoulVO vo = dao.seoulDetailData(no);
		
		model.addAttribute("vo", vo);
		return "seoul/detail";
	}
	
}
