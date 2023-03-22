package com.sist.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.food.dao.*;
import com.sist.food.entity.*;
@Controller
public class FoodController {
	@Autowired
	private CategoryDAO dao;
	
	@GetMapping("/")
	public String categoryListData(Model model) {
		List<CategoryEntity> list = dao.categoryListData();
		model.addAttribute("list",list);
		return "category";
	}
}
