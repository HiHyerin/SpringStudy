package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.SeoulDAO;
import com.sist.dao.SeoulVO;
@Controller // 브라우저와 연결
public class SeoulController {
	@Autowired
	private SeoulDAO dao;

	@RequestMapping("seoul/location.do")
	public String seoul_list(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		if(page==null)
			page = "1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap<>();
		int rowSize = 20;
		int start = (rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		map.put("start", start); // #{start} -> seoulMapper의 키값과 같아야 한다.
		map.put("end", end);// #{end}

		List<SeoulVO> list = dao.seoulListData(null);
		int totalpage = dao.seoulTotalPage();

		// location.jsp로 값을 전송
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("list", list);
		return "seoul/location";
	}
}
