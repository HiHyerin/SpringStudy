package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class RecipeFController {
	@Autowired
	private RecipeService service;
	
	@GetMapping("recipe/recipe_list.do")
	public String recipe_list() {
		
		return "recipe/recipe_list";
	}
	
	@GetMapping("recipe/chef_list.do")
	public String chef_list() {
		return "recipe/chef_list";
	}
}
