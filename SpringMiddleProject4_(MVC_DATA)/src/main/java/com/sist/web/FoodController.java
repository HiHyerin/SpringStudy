package com.sist.web;
import java.util.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller   //모델 역할
/*
 *   Spring 4.3 ==> RequestMapping(Get/Post)
 *                   = GetMapping : default, <a>, sendRedirect(), location.href
 *                   = PostMapping : <form> ajax => type ="post"
 */
public class FoodController {
   @Autowired
   private FoodDAO dao;
   
   @GetMapping("food/category.do")
   public String food_category(String sno,Model model)
   {
      if(sno==null) // 값이 없을 땐 string처리 후 parseint
         sno="1";
      int no=Integer.parseInt(sno);
      int start=0;
      int end=0;
      if(no==1)
      {
         start=1;
         end=12;
      }
      else if(no==2)
      {
         start=13;
         end=18;
         
      }
      else if(no==3)
      {
         start=19;
         end=30;
      }
      Map map =new HashMap();
      map.put("start", start);
      map.put("end", end);
      List<CategoryVO> list=dao.categoryListData(map);
      model.addAttribute("list",list);
      
      return "food/category";
   }
   
//   <a href="list.do?cno=${vo.cno }">
   @GetMapping("food/list.do")
   public String food_list(int cno, Model model) {
	   List<FoodVO> list = dao.foodListData(cno);
	   for(FoodVO vo:list) {
		   String address = vo.getAddress();
		   address = address.substring(0,address.lastIndexOf("지"));
		   vo.setAddress(address.trim());
		   
		   String poster = vo.getPoster();
		   poster = poster.substring(0,poster.indexOf("^"));
		   poster = poster.replace("#", "&");
		   vo.setPoster(poster);
	   }
	   
	   CategoryVO vo = dao.categoryInfoData(cno);
	   model.addAttribute("list",list);
	   model.addAttribute("vo",vo);
	   
	   return "food/list";
   }
   
   
}