package com.sist.web;

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

import com.sist.dao.SeoulDAO;
import com.sist.vo.SeoulVO;
@Controller
public class SeoulController {
	@Autowired
	private SeoulDAO dao;
	// <a href="../seoul/list.do">
	@GetMapping("seoul/list.do")
	public String seoulListData(String page, Model model, HttpServletRequest request ) {
		if(page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap<>();
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		List<SeoulVO> list = dao.seoulLocationListData(map);
		for(SeoulVO vo:list) {
			String title = vo.getTitle();
			if(title.length()>19) {
				title = title.substring(0, 16)+"...";
				vo.setTitle(title);
			}
			vo.setTitle(title);
		}

		int totalpage = dao.seoulTotalPage();
		final int BLOCK = 5;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;

		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		// 쿠키관련
		List<SeoulVO> sList = new ArrayList<SeoulVO>();
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i = cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("seoul")) {
					String no = cookies[i].getValue();
					SeoulVO vo = dao.seoulDetailData(Integer.parseInt(no));
					sList.add(vo);
				}
			}
		}
		model.addAttribute("sList", sList);
		return "seoul/list";
	}

	
	@GetMapping("seoul/detail_before.do")
	public String seoul_detail_before(String no, HttpServletResponse response, RedirectAttributes ra) {
		Cookie cookie = new Cookie("seoul"+no, no);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		// 브라우저로 전송
		response.addCookie(cookie);
		ra.addAttribute("no", no);
		return "redirect:detail.do";
	}
	//<a href="../seoul/detail.do">
	@GetMapping("seoul/detail.do")
	public String seoulDetailData(int no, Model model) {
		SeoulVO vo = dao.seoulDetailData(no);

		model.addAttribute("vo", vo);
		return "seoul/detail";
	}

}
