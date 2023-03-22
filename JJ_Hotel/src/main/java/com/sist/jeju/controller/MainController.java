package com.sist.jeju.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.jeju.dao.JejuDAO;
import com.sist.jeju.dao.JejuFoodDAO;
import com.sist.jeju.entity.JejuEntity;
import com.sist.jeju.entity.JejuFoodEntity;
@Controller
public class MainController {
	@Autowired
	private JejuDAO dao;
	
	@Autowired
	private JejuFoodDAO fDao;
	
	@GetMapping("/")
	public String jeju_main(Model model) {
		List<JejuEntity> list = dao.JejuListData();
		List<JejuFoodEntity> fList = fDao.JejuFoodListData();
		
		model.addAttribute("fList", fList);
		model.addAttribute("list", list);
		model.addAttribute("main_content", "main/home");
		return "main";
	}
}
