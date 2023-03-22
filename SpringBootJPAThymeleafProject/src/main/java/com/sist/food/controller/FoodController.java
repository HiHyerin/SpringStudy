package com.sist.food.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.food.dao.*;
import com.sist.food.entity.*;
@Controller
public class FoodController {
	@Autowired
	private CategoryDAO dao;
	@GetMapping("/main")
	public String food_main(Model model) {
		List<CategoryEntity> list = dao.categoryListData();
		model.addAttribute("list", list);
		model.addAttribute("main_content", "main/home");
		return "main";
	}
	@GetMapping("/food/category")
	public String food_category(Model model) {
		List<CategoryEntity> list = dao.categoryListData();
		model.addAttribute("list", list);
		return "food/category";
	}
}
