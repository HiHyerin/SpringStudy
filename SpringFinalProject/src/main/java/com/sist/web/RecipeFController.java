package com.sist.web;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.RecipeService;
import com.sist.vo.RecipeDetailVO;
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
	
	 @GetMapping("recipe/recipe_detail.do")
    public String recipe_detail(int no,Model model)
    {
    	// Model 전송 객체 => request를 대체
    	int count=service.recipeDetailCount(no);
    	if(count>0)
    	{
    		RecipeDetailVO vo=service.recipeDetailData(no);
    		String ss=vo.getData();
    		ss=ss.replace("구매", "");
    		vo.setData(ss);
    		model.addAttribute("vo", vo);
    		String[] foodmake=vo.getFoodmake().split("\n");
    		List<String> tList=new ArrayList<String>();
    		List<String> iList=new ArrayList<String>();
    		for(String fm:foodmake)
    		{
    			StringTokenizer st=new StringTokenizer(fm,"^");
    			tList.add(st.nextToken());
    			iList.add(st.nextToken());
    		}
    		model.addAttribute("tList1", tList);
    		model.addAttribute("iList1", iList);
    	}
    	model.addAttribute("count", count);
    	return "recipe/recipe_detail";
    }
}
