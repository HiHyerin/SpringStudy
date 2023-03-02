package com.sist.web;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class FoodController {
   @Autowired
   private FoodDAO dao;
   
   @GetMapping("food/food_list.do")
   public String food_list(int cno,Model model)
   {
      List<FoodVO> list=dao.foodListData(cno);
      for(FoodVO vo: list)
      {
         String address=vo.getAddress();
         address=address.substring(0,address.lastIndexOf("지"));
         vo.setAddress(address.trim());
         
         String poster=vo.getPoster();
         poster=poster.substring(0,poster.indexOf("^"));
         vo.setPoster(poster);
      }
      
      model.addAttribute("list",list);
      
      CategoryVO vo=dao.categoryInfoData(cno);
      model.addAttribute(vo);
      return "food/food_list"; // include되는 파일 지정
   }
   
   //<a href="../food/detail_before.do?fno=${fvo.fno }">
   @GetMapping("food/detail_before.do")
   public String food_detail_before(int fno, RedirectAttributes ra, HttpServletResponse response) {
	   Cookie cookie = new Cookie("food"+fno, String.valueOf(fno)); // cookie는 String만 저장 가능
	   cookie.setMaxAge(60*60*24);
	   // 브라우저로 전송
	   response.addCookie(cookie);
	   
	   ra.addAttribute("fno", fno);
	   return "redirect:../food/detail.do";
   }
   
   @GetMapping("food/detail.do")
   // 사용자가 보낸 데이터(request.getParameter()), List, String[], VO
   // 내장객체 : HttpServletRequest(cookie), HttpServletResponse(cookie, upload), Model(jsp로 전송시), HttpSession(로그인 처리, 장바구니), RedirectAttributes(redirect에서 값 전송)
   public String food_detail(int fno, Model model, HttpServletRequest request) {
	   FoodVO vo = dao.foodDetailData(fno);
	   String[] addrs=vo.getAddress().split(" ");
	   model.addAttribute("addr", addrs[1].trim());
	   model.addAttribute("vo",vo);
	   
	   //쿠키전송
	   Cookie[] cookies = request.getCookies(); // 쿠키는 내장객체가 아니기 때문에 request를 이용해서 가져와야한다.
	   List<FoodVO> cList = new ArrayList<FoodVO>();
	   if(cookies!=null) {
		   for(int i = cookies.length-1;i>=0;i--) {
			   if(cookies[i].getName().startsWith("food")) {
				   String no = cookies[i].getValue();
				   FoodVO fvo = dao.foodDetailData(Integer.parseInt(no));
				   cList.add(fvo);
			   }
		   }
	   }
	   model.addAttribute("cList", cList);
	   model.addAttribute("count",cList.size());
	   return "food/detail";
   }
   
   @GetMapping("food/food_search.do")
   public String food_search() {
	   return "food/food_search";
   }
   
   @GetMapping("food/location_detail_before.do")
   public String food_location_detail_befor(int fno, HttpServletResponse response, RedirectAttributes ra) {
	   Cookie cookie = new Cookie("location"+fno, String.valueOf(fno));
	   cookie.setPath("/");
	   cookie.setMaxAge(60*60*24);
	   response.addCookie(cookie);
	   ra.addAttribute("fno", fno);
	   return "redirect:../food/location_detail.do";
   }
   
   @GetMapping("food/location_detail.do") // 화면만 변경해주고 데이터는 vue.js로 
   public String food_location_detail(int fno, Model model) {
	   model.addAttribute("fno",fno);
	   return "food/location_detail";
   }
}