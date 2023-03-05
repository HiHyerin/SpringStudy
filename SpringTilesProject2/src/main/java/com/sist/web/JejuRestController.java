package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.JejuDAO;
import com.sist.vo.JejuFoodVO;

@RestController
public class JejuRestController {
	@Autowired
	private JejuDAO dao;
	
	@GetMapping(value="jeju/food_list_vue.do", produces="text/palin;charset=UTF-8")
	public String jeju_food_list_vue(String page) {
		if(page==null)
			page = "1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap<>();
		map.put("start", (curpage*20)-19); // foodmapper에 #{start}
		map.put("end", curpage*20); // foodmapper에 #{end}
		List<JejuFoodVO> list = dao.jejuFoodListData(map);
		int totalpage = dao.jejuFoodTotalPage();
		JSONArray arr = new JSONArray(); // List
		int i=0;
		for(JejuFoodVO vo:list) {
			JSONObject obj = new JSONObject(); // VO
			obj.put("no", vo.getNo());
			obj.put("title", vo.getTitle());
			obj.put("poster", vo.getPoster());
			if(i==0) {
				obj.put("curpage", curpage);
				obj.put("totalpage", totalpage);
			}
			arr.add(obj);
			i++;
		}
		return arr.toJSONString();
	}
	
	@GetMapping(value="jeju/food_detail_vue.do", produces="text/palin;charset=UTF-8")
	public String jeju_food_detail_vue(int no) {
		JejuFoodVO vo = dao.jejuDetailData(no);
		JSONObject obj = new JSONObject();
		obj.put("title", vo.getTitle());
		obj.put("score", vo.getScore());
		obj.put("addr", vo.getAddr());
		obj.put("tel", vo.getTel());
		obj.put("type", vo.getType());
		obj.put("parking", vo.getParking());
		obj.put("time", vo.getTime());
		obj.put("menu", vo.getMenu());
		obj.put("poster", vo.getPoster());
		return obj.toJSONString();
	}
}
