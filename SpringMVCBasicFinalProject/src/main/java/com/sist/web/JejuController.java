package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class JejuController {
	@Autowired
	private JejuDAO dao;
	
	@GetMapping("jeju/list.do")
	public String jeju_list(String page, Model model) {
		if(page==null)
			page = "1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap<>();
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		List<JejuLocationVO> list = dao.jejuLocationListData(map);
		for(JejuLocationVO vo:list) {
			String title = vo.getTitle();
			if(title.length()>19) {
				title = title.substring(0,16)+"...";
				vo.setTitle(title);
			}
			vo.setTitle(title);
		}
		
		int totalpage = dao.jejuTotalPage();
		
		final int BLOCK = 5;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		return "jeju/list";
	}
	
	// <a href="../jeju/detail.do?no=${vo.no }"> 
	@GetMapping("jeju/detail.do")
	public String jeju_detail(int no, Model model) {
		JejuLocationVO vo = dao.jejuDetailData(no);
		String poster = vo.getInfo();
		int i = poster.indexOf("^");
		
		if(i>=0) {
			poster = poster.substring(0,poster.indexOf("^"));
			vo.setInfo(poster);
		}
		String addr = vo.getAddr();
		String[] addrs = addr.split(" ");
		Map map = new HashMap<>();
		map.put("addr", addrs[1].trim());
		List<JejuFoodVO> list = dao.jejuFoodData(map); // 인근맛집
		model.addAttribute("list", list);
		model.addAttribute("vo",vo);

		return "jeju/detail";
	}
	
	
}
