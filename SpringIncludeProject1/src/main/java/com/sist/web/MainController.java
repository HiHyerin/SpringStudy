package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.FoodDAO;
import com.sist.vo.CategoryVO;
@Controller
public class MainController {
	@Autowired
	private FoodDAO dao;

	@GetMapping("main/main.do")
	public String main_main(Model model) {
		List<CategoryVO> cList = dao.categoryListData();
		model.addAttribute("cList", cList);
		model.addAttribute("main_jsp", "../main/home.jsp");
		return "main/main";
	}
}
