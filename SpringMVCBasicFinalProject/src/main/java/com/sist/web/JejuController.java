package com.sist.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.JejuDAO;
import com.sist.vo.JejuFoodVO;
import com.sist.vo.JejuLocationVO;

@Controller
public class JejuController {
	@Autowired
	private JejuDAO dao;

	@GetMapping("jeju/list.do")
	public String jeju_list(String page, Model model, HttpServletRequest request) {
		if(page==null)
			page = "1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap<>();
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		List<JejuLocationVO> list = dao.jejuLocationListData(map);
		for(JejuLocationVO vo:list) {
			String title = vo.getTitle();
			if(title.length()>19) {
				title = title.substring(0,16)+"...";
				vo.setTitle(title);
			}
			vo.setTitle(title);
		}

		int totalpage = dao.jejuTotalPage();

		final int BLOCK = 5;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;

		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		
		
		// 쿠키관련
		List<JejuLocationVO> cList = new ArrayList<JejuLocationVO>();
		 Cookie[] cookies=request.getCookies(); // request를 통해 cookie를 가져온다
		 if(cookies != null) {
			 for(int i = cookies.length-1;i>=0;i--) {
				 if(cookies[i].getName().startsWith("jeju")) {
					 String no = cookies[i].getValue();
					 JejuLocationVO vo = dao.jejuDetailData(Integer.parseInt(no));
					 cList.add(vo);
				 }
			 }
		 }
		model.addAttribute("cList",cList);
		return "jeju/list";
	}

	// <a href="../jeju/detail_before.do?no=${vo.no }">
	/*
	 	String no = request.getParameter("no")
	 	Integer.parseInt(no)
	 */
//	@GetMapping("jeju/detail_before.do")
//	public String jeju_detail_before(int no, HttpServletResponse response) { // response : 쿠키 보낼 때 필요
//		return "redirect:detail.do?no="+no; // RedirectAttributes ra 쓰면 밑에처럼
//	}
	@GetMapping("jeju/detail_before.do")
	public String jeju_detail_before(String no, HttpServletResponse response, RedirectAttributes ra) { // response : 쿠키 보낼 때 필요
		Cookie cookie = new Cookie("jeju"+no, no);
		cookie.setPath("/"); // 경로
		cookie.setMaxAge(60*60*24); // 기간
		//브라우저로 전송
		response.addCookie(cookie);
		ra.addAttribute("no",no);
		return "redirect:detail.do"; //
	}
	
	
	// <a href="../jeju/detail.do?no=${vo.no }">
	@GetMapping("jeju/detail.do")
	public String jeju_detail(int no, Model model) {
		JejuLocationVO vo = dao.jejuDetailData(no);
		String poster = vo.getInfo();
		int i = poster.indexOf("^");

		if(i>=0) {
			poster = poster.substring(0,poster.indexOf("^"));
			vo.setInfo(poster);
		}
		String addr = vo.getAddr();
		String[] addrs = addr.split(" ");
		Map map = new HashMap<>();
		map.put("addr", addrs[1].trim());
		List<JejuFoodVO> list = dao.jejuFoodData(map); // 인근맛집
		model.addAttribute("list", list);
		model.addAttribute("vo",vo);

		return "jeju/detail";
	}


}
