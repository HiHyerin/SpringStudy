package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;

@Controller // Controller는 반드시 메모리 할당을 해줘야 한다
			// 브라우저와 연결
public class SeoulController {  // 모델의 역할
	@Autowired
	private SeoulDAO dao;
	
	@RequestMapping("seoul/location.do")
	public String seoul_list(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start); //#{start}
		map.put("end", end); //#{end}
		List<SeoulVO> list=dao.seoulListData(map);
		int totalpage=dao.seoulTotalPage();
		
		// location.jsp로 값을 전송
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("list", list);
		return "seoul/location"; //.jsp는 붙이면안된당!!  설정에서 붙여주기로했다
		/*
	 		p:prefix="/"    => 경로명 (접두어)
	 		p:suffix=".jsp" => 확장자 (접미어)
	 		
	 		return "seoul/list";
	 		========================>/seoul/list.jsp
		*/
	}
}





















