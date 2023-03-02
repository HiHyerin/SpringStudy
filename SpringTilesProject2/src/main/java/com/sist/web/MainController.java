package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class MainController {
  @Autowired
  private FoodDAO dao;
  
  @GetMapping("main/main.do")
  public String main_page(Model model)
  {
	  List<CategoryVO> list=dao.categoryListData();
	  model.addAttribute("list", list);
	  return "main";
  }
}