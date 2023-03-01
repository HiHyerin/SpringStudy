package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.SeoulDAO;
import com.sist.vo.SeoulLocationVO;
@Controller // 클래스 찾아서 메모리 할당
public class SeoulController {
	@Autowired // 스프링이 관리하는 클래스 객체 주소 주입
	private SeoulDAO dao;
	@GetMapping("seoul/location.do") // if => 어노테이션(index:찾기) => 사용자 요청에 따라 메소드 찾기
	public String seoul_location(String page, Model model) {
		//페이지처리////////////////////////////////////////////////
		if(page==null)
			page = "1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap<>();
		map.put("start", (curpage*20)-19);
	    map.put("end", curpage*20);

		List<SeoulLocationVO> sList = dao.seoulLocationListData(map);
		int totalpage = dao.seoulTotalPage();

		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;

		model.addAttribute("sList", sList);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		///////////////////////////////////////////////////////////


		//////////////////////////////////////////////////////////
		model.addAttribute("main_jsp", "../seoul/location.jsp");
		return "main/main";
	}
	
	//../seoul/nature.do
	@GetMapping("seoul/nature.do")
	public String seoul_nature(String page, Model model) {
		//페이지처리////////////////////////////////////////////////
		if(page==null)
			page = "1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap<>();
		map.put("start", (curpage*20)-19);
	    map.put("end", curpage*20);

		List<SeoulLocationVO> sList = dao.seoulNatureListData(map);
		int totalpage = dao.seoulNatureTotalPage();

		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;

		model.addAttribute("sList", sList);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		///////////////////////////////////////////////////////////
		model.addAttribute("main_jsp", "../seoul/nature.jsp");
		return "main/main";
	}
	
	//<li><a href="../seoul/shop.do">쇼핑</a></li>
	@GetMapping("seoul/shop.do")
	public String seoul_shop(String page, Model model) {
		//페이지처리////////////////////////////////////////////////
				if(page==null)
					page = "1";
				int curpage = Integer.parseInt(page);
				Map map = new HashMap<>();
				map.put("start", (curpage*20)-19);
			    map.put("end", curpage*20);

				List<SeoulLocationVO> sList = dao.seoulShopListData(map);
				int totalpage = dao.seoulShopTotalPage();

				final int BLOCK = 10;
				int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
				int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
				if(endPage>totalpage)
					endPage=totalpage;

				model.addAttribute("sList", sList);
				model.addAttribute("curpage", curpage);
				model.addAttribute("totalpage", totalpage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				///////////////////////////////////////////////////////////
				model.addAttribute("main_jsp", "../seoul/shop.jsp");
				return "main/main";
	}
	
}
