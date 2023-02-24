package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.*;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	/*
	 	Model, => jsp로 값을 전송 (Model을 전송객체) => 화면에 출력할 데이터 전송(forward => return "경로명/파일명"
	 	RedirectAttributes, ?대신 사용
	 		return "redirect:detail.do?no=1"
	 	HttpServletRequest, : cookie 읽기
	 	HttpServletResponse, : cookie 전송, File Download
	 	HttpSession : 회원가입...
	 	
	 	일반데이터 : page, no..., 검색어 => String, 해당 데이터형으로 받을 수 있다.
	 	커맨드 객체 : ~vo
	 	checkbox => String[]
	 	List->name=a[0], name[1]...
	 */
	@GetMapping("food/list.do")
	public String food_list(String page, Model model) { // Model, RedirectAttributes, HttpServletRequest, HttpServletResponse, HttpSession
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page); //현재 페이지
		Map map = new HashMap<>();
		map.put("start",(curpage*20)-19);
		map.put("end", curpage*20);
		List<FoodVO> list = dao.foodListData(map);
		//////////////////////////////////////////////
		int totalpage = dao.foodTotalPage();
		final int BLOCK=10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage = totalpage;
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		
		return "food/list";
	}
	
	// <form method = "post" action="find.do">
		@PostMapping("food/find.do")
		public String food_find(String[] types, String ss, Model model) {
			Map map = new HashMap<>(); // Map은 mybatis에서 값 여러개를 보낼 때 사용
			map.put("typeArr", types); 
			//		--------	----- -> list.jsp
			// 		 ㄴ food-mapper랑 맞춰야함
			map.put("ss", ss);// food-mapper랑 맞춰야함
			//dao 연동 = 검색데이터 읽기
			List<FoodVO> list = dao.foodFindData(map);
			int count = dao.foodFindCount(map);
			model.addAttribute("count", count);
			model.addAttribute("list",list);
			return "food/find";
		}
}
