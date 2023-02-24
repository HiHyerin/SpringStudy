package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.*;
/*
종류별
상황별
재료별
방법별
전체밑반찬메인반찬국/탕찌개디저트면/만두밥/죽/떡퓨전김치/젓갈/장류양념/소스/잼양식샐러드스프빵과자차/음료/술기타
전체일상초스피드손님접대술안주다이어트도시락영양식간식야식푸드스타일링해장명절이유식기타
전체소고기돼지고기닭고기육류채소류해물류달걀/유제품가공식품류쌀밀가루건어물류버섯류과일류콩/견과류곡류기타
전체볶음끓이기부침조림무침비빔찜절임튀김삶기굽기데치기회기타
 */

@Controller
public class RecipeController {
	@Autowired
	private RecipeDAO dao;
	
	@GetMapping("recipe/recipe.do")
	public String recipe_list(Model model) {
		String[] menu = {
				"밑반찬","탕","찌개","디저트","면","만두밥","죽","젓갈","장류","양념","양식","샐러드","스프","빵",
				"소고기","돼지고기","닭고기","육류", "채소","해물","달걀","가공식품","밀가루","건어물","버섯",
				"볶음","끓이기","부침","조림","무침","비빔","튀김","회"
		};
		model.addAttribute("menu", menu);
		return "recipe/recipe";
	}
	
	//<form method=post action="find.do">
	@PostMapping("recipe/find.do")
	//<input type="checkbox" name="menu" value="${m }">${m }&nbsp;
		//						  ------
	public String recipe_find(String[] menu, Model model) {
		//							  ------- 위 문장 name과 같아야함
		// a b c = s="a|" a|b|c
		String s="";
		for(String m:menu) {
			s+=m+"|";
		}
		s=s.substring(0,s.lastIndexOf("|"));
		
		List<RecipeVO> list = dao.recipeFindData(s);
		model.addAttribute("list", list);
		
		return "recipe/find";
	}

}
