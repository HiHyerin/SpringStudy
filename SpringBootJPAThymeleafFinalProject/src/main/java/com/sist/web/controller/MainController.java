package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.CategoryDataMapping;

@Controller
public class MainController {
	@Autowired
	private CategoryDAO dao;
	
	@GetMapping("/")
	public String main_page(Model model) {
		List<CategoryDataMapping> list = dao.categoryListData();
		model.addAttribute("list", list);
		model.addAttribute("main_html", "main/home");
		return "main";
	}
}
