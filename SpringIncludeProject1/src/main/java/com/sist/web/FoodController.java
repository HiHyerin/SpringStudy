package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.FoodDAO;
import com.sist.dao.ReplyDAO;
import com.sist.dao.ReplyOrmDAO;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
import com.sist.vo.ReplyVO;
@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	@Autowired
	private ReplyDAO rdao;
	//private ReplyOrmDAO rdao; -- 고급 프로시저
	
	// include, forward : request를 공유
	// ../food/food_list.do?cno=${vo.cno }
	@GetMapping("food/food_list.do")
	public String food_list(int cno, Model model) { // DispatcherServlet에서 호출 => 매개변수에 값을 채워서 호출
		List<FoodVO> fList=dao.foodListData(cno);
		for(FoodVO vo:fList) {
			String address = vo.getAddress();
			address = address.substring(0,address.lastIndexOf("지"));
			vo.setAddress(address.trim());

			String poster = vo.getPoster();
			poster = poster.substring(0,poster.indexOf("^"));
			poster = poster.replace("#", "&");
			vo.setPoster(poster);
		}
		CategoryVO vo = dao.categoryInfoData(cno);
		model.addAttribute("vo", vo);

		model.addAttribute("fList", fList);
		model.addAttribute("main_jsp", "../food/food_list.jsp"); // 출력(인클루드되는 대상)
		return "main/main"; // 데이터를 보내는 곳
	}

	// <a href="../food/food_detail.do?fno=${fvo.fno }">
	@GetMapping("food/food_detail.do")
	public String food_detail(int fno,int type, Model model) {
		//dao연동
		FoodVO vo = dao.foodDetailData(fno);
		model.addAttribute("vo", vo);

		String[] addrs = vo.getAddress().split(" ");
		model.addAttribute("addr", addrs[1].trim());
		////////////
		model.addAttribute("main_jsp", "../food/food_detail.jsp");
		// 댓글 읽기////////////////// replyDao
		List<ReplyVO> rList = rdao.replyListData(fno, type);
//		Map map = new HashMap<>();//ReplyMapper랑 이름 같아야함
//		map.put("pRno", fno);
//		map.put("pType", type);
//		List<ReplyVO> rList = rdao.replyListData(map);
		// type (1:맛집, 2:제주, 3: 서울)
		model.addAttribute("rList",rList);
		//////////////////////////
		return "main/main";
	}
}
