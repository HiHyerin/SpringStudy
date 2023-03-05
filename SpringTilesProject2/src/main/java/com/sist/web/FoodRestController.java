package com.sist.web;

import org.apache.ibatis.annotations.Select;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	
	@RequestMapping(value="food/food_search_vue.do", produces="text/plain;charset=UTF-8")
	// JavaScript, HTML, 일반 문자열 => text/html, JSON => text/plain
	public String food_search(String page, String addr) {
		if(addr==null){
			addr="역삼";
		}
		if(page==null)
			page = "1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap<>();
		map.put("start", (curpage*20)-19); // foodmapper에 #{start}
		map.put("end", curpage*20); // foodmapper에 #{end}
		map.put("addr", addr);
		List<FoodVO> list = dao.foodSearchData(map);
		int totalpage = dao.foodSearchTotalPage(map);
		// JavaScript에서 인식하는 프로그램으로 변경
		JSONArray arr = new JSONArray(); // List
		int i = 0;
		for(FoodVO vo : list) {
			JSONObject obj = new JSONObject(); // VO
			obj.put("fno", vo.getFno());
			obj.put("name", vo.getName());
			String poster = vo.getPoster();
			poster = poster.substring(0, poster.indexOf("^"));
			poster = poster.replace("#", "&");
			obj.put("poster", poster);
			// {fno:1, name:"", poster:""}
			if(i==0) {
				obj.put("curpage", curpage);
				obj.put("totalpage", totalpage);
			}
			arr.add(obj);
			i++;
		}
//		@Select("select fno, name, poster, num "
//				+ "from (select fno, name, poster, rownum as num "
		System.out.println(arr.toJSONString());
		return arr.toJSONString(); // 목록 출력(여러개 출력) : jsonArray
	}
	
	@GetMapping(value="food/location_detail_vue.do",produces="text/plain;charset=UTF-8")
	public String food_location_detail(int fno) {
		FoodVO vo = dao.foodLocationDetailData(fno);
		JSONObject obj = new JSONObject();
		obj.put("fno", vo.getFno());
		obj.put("name", vo.getName());
		obj.put("poster", vo.getPoster());
		obj.put("tel", vo.getTel());
		obj.put("address", vo.getAddress());
		obj.put("parking", vo.getParking());
		obj.put("time", vo.getTime());
		obj.put("price", vo.getPrice());
		obj.put("type", vo.getType());
		obj.put("menu", vo.getMenu());
		return obj.toJSONString(); // vo출력(한개 출력) : jsonObject
	}
	
	@GetMapping(value="food/category_vue.do", produces="text/plain;charset=UTF-8")
	public String category_vue(int no) {
		Map map = new HashMap<>();
		map.put("no", no);
		List<CategoryVO> list = dao.categoryVueData(map);
		
		// JavaScript에서 인식 []
		JSONArray arr = new JSONArray(); // [] , JSONObject : {} => [{},{},{},{},...]
		for(CategoryVO vo:list) {
			JSONObject obj = new JSONObject();
			obj.put("cno", vo.getCno());
			obj.put("title", vo.getTitle());
			obj.put("poster", vo.getPoster()); //{"cno":1, "title":..., "poster":...}
			arr.add(obj);
			
		}
		return arr.toJSONString();
	}
	
	@GetMapping(value="food/food_list_vue.do", produces="text/plain;charset=UTF-8")
	public String food_list_vue(int no) {
		List<FoodVO> list = dao.foodListData(no);
		CategoryVO cvo = dao.categoryInfoData(no);
		JSONArray arr = new JSONArray();
		// fno, cno, name, tel, address, type, poster, score
		int i=0;
		for(FoodVO vo:list	) {
			JSONObject obj = new JSONObject();
			obj.put("fno", vo.getFno());
			obj.put("name", vo.getName());
			obj.put("tel", vo.getTel());
			String address = vo.getAddress();
			address = address.substring(0,address.lastIndexOf("지"));
			obj.put("address", address.trim());
			obj.put("type", vo.getType());
			obj.put("score", vo.getScore());
			String poster = vo.getPoster();
			poster = poster.substring(0,poster.indexOf("^"));
			poster = poster.replace("#", "&");
			obj.put("poster", vo.getPoster());
			if(i==0) {
				obj.put("title", cvo.getTitle());
				obj.put("subject", cvo.getSubject());
			}
			arr.add(obj);
			i++;
		}
		return arr.toJSONString();
	}
	
	@GetMapping(value="food/food_detail_vue.do", produces="text/plain;charset=UTF-8")
	// text/html, text/plain, text/xml(x) =>
	/*
	private int fno, cno, good, soso, bad, count;
	private double score;
	private String poster,name,address,tel,type,price,parking,menu,time;
	 */
	public String food_detail_vue(int fno) {
		FoodVO vo = dao.foodDetailData(fno);
		// vo를 javaScript로 변환해주는 작업
		JSONObject obj = new JSONObject();
		obj.put("fno", vo.getFno());
		obj.put("address", vo.getAddress());
		obj.put("score", vo.getScore());
		obj.put("name", vo.getName());
		obj.put("tel", vo.getTel());
		obj.put("type", vo.getType());
		obj.put("price", vo.getPrice());
		obj.put("parking", vo.getParking());
		obj.put("menu", vo.getMenu());
		obj.put("time", vo.getTime());
		obj.put("poster", vo.getPoster());
		
		return obj.toJSONString();
	}
	
	

}
