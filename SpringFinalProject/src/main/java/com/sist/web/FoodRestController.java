package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sist.vo.*;
import com.sist.dao.*;
@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	
	
	/*
	 	axios.get("http://localhost:8080/web/food/category_info.do",{
	 		  ---- GetMapping
			params:{
				cno:_this.cno => 매개변수
			}
		}).then(function(response){
			console.log(response.data)
			_this.cate_info = response.data  => return값
		})
	 */
	@GetMapping(value="food/food_main_vue.do", produces = "text/plain;charset=utf-8")
	public String food_main_vue() {
		List<CategoryVO> list = dao.categoryListData();
		JSONArray arr = new JSONArray();
		for(CategoryVO vo:list) { // vo를 array로 변환
			JSONObject obj = new JSONObject();
			obj.put("cno", vo.getCno());
			obj.put("title", vo.getTitle());
			obj.put("poster", vo.getPoster());
			arr.add(obj);
		}
		return arr.toJSONString();
	}
	
	//쿠키/////////////////////////////////////////////////////
	@GetMapping(value="food/cookie_data_vue.do", produces = "text/plain;charset=utf-8")
	public String food_cookie_data(HttpServletRequest request) {
		// new Cookie(key, value)
		// getName() = key
		// getValue() = value
		Cookie[] cookies = request.getCookies();
		List<FoodVO> list = new ArrayList<FoodVO>();
		if(cookies != null) {
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("spring_food")) { 
					String fno = cookies[i].getValue();
					FoodVO vo = dao.foodCookieDetailData(Integer.parseInt(fno));
					list.add(vo);
				} // key 값이 "spring_food"이라면 값을 가져와라
			}
		}
		
		// JSON 변환 //////////////////////////////////////
		JSONArray arr = new JSONArray();
		int i=0;
		for(FoodVO vo:list) {
			if(i>9) break;
			JSONObject obj = new JSONObject();
			obj.put("fno", vo.getFno());
			obj.put("name", vo.getName());
			String poster = vo.getPoster();
			poster = poster.substring(0, poster.indexOf("^"));
			poster = poster.replace("#", "&");
			obj.put("poster", poster);
			arr.add(obj);
			i++;
		}
		return arr.toJSONString();
	}
	///////////////////////////////////////////////////////////
	
	@GetMapping(value="food/category_info_vue.do", produces = "text/plain;charset=utf-8")
	public String category_info_vue(int cno) {
		CategoryVO vo = dao.categoryInfoData(cno);
		JSONObject obj = new JSONObject();
		obj.put("title", vo.getTitle());
		obj.put("subject", vo.getSubject());
		return obj.toJSONString();
	}
	
	@GetMapping(value="food/food_list_vue.do", produces = "text/plain;charset=utf-8")
	public String category_list_vue(int cno) {
		List<FoodVO> list = dao.foodListData(cno);
		JSONArray arr = new JSONArray();
		for(FoodVO vo:list) {
			JSONObject obj = new JSONObject(); // vo => {}
			obj.put("fno", vo.getFno());
			obj.put("name", vo.getName());
			obj.put("score", vo.getScore());
			obj.put("tel", vo.getTel());
			obj.put("type", vo.getType());
			String addr = vo.getAddress();
			addr = addr.substring(0, addr.lastIndexOf("지"));
			obj.put("address", addr.trim());
			String poster = vo.getPoster();
			poster = poster.substring(0, poster.indexOf("^"));
			poster = poster.replace("#", "&");
			obj.put("poster", poster);
			arr.add(obj);
		}
		return arr.toJSONString();
	}
	
	@GetMapping(value="food/food_detail_vue.do", produces = "text/plain;charset=utf-8")
	public String food_detail_vue(int fno) {
		FoodVO vo = dao.foodDetailData(fno);
		String address = vo.getAddress();
		String addr1 = address.substring(0,address.lastIndexOf("지"));
		String addr2 = address.substring(address.lastIndexOf("지")+3);
		
		/////////////////////////////////////////// vo => {}(JSONObject)
		JSONObject obj = new JSONObject();
		obj.put("fno", vo.getFno());
		obj.put("name", vo.getName());
		obj.put("score", vo.getScore());
		obj.put("addr1", addr1.trim());
		obj.put("addr2", addr2.trim());
		obj.put("tel", vo.getTel());
		obj.put("type", vo.getType());
		obj.put("time", vo.getTime());
		String menu = vo.getMenu();
		if(!menu.equals("no")) { // 메뉴가 no가 아니라면
			menu = menu.substring(0,menu.lastIndexOf("원"));
		}
		obj.put("menu", menu);
		obj.put("price", vo.getPrice());
		obj.put("parking", vo.getParking());
		obj.put("poster", vo.getPoster());
		
		return obj.toJSONString();
	}
	
	//검색/////////////////////////////////////////////////////////////////////
	@GetMapping(value="food/food_find_vue.do", produces = "text/plain;charset=utf-8")
	public String food_find_vue(String page, String address) {
		if(page==null)
			page="1";
		if(address == null)
			address="역삼";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap<>();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		map.put("address", address);
		List<FoodVO> list = dao.foodLocationFindData(map);
		int totalpage = dao.foodFindTotalPage(address);
		
		final int BLOCK=3;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage = totalpage;
		
		// 데이터 전송 : Json
		int i=0;
		JSONArray arr = new JSONArray();
		for(FoodVO vo:list) {
			JSONObject obj = new JSONObject();
			obj.put("fno", vo.getFno());
			obj.put("name", vo.getName());
			obj.put("score", vo.getScore());
			String poster = vo.getPoster();
			poster = poster.substring(0,poster.indexOf("^"));
			poster = poster.replace("#", "&");
			obj.put("poster", poster);
			
			if(i == 0) {
				obj.put("curpage", curpage);
				obj.put("totalpage", totalpage);
				obj.put("startPage", startPage);
				obj.put("endPage", endPage);
			}
			arr.add(obj);
			i++;
			
		}
		return arr.toJSONString();
	}
	// 검색페이지 지도
	@GetMapping(value="food/food_find_gu_vue.do",  produces = "text/plain;charset=utf-8")
	public String food_find_fu_vue(String page, int gu) {
		String[] guList = { "전체", "강서구", "양천구", "구로구", "마포구", "영등포구", "금천구",
				"은평구", "서대문구", "동작구", "관악구", "종로구", "중구", "용산구", "서초구", "강북구",
				"성북구", "도봉구", "동대문구", "성동구", "강남구", "노원구", "중랑구", "광진구", "송파구",
				"강동구" };
		
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap<>();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		map.put("address", guList[gu]);
		List<FoodVO> list = dao.foodLocationFindData(map);
		int totalpage = dao.foodFindTotalPage(guList[gu]);
		
		final int BLOCK=3;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage = totalpage;
		
		// 데이터 전송 : Json
		int i=0;
		JSONArray arr = new JSONArray();
		for(FoodVO vo:list) {
			JSONObject obj = new JSONObject();
			obj.put("fno", vo.getFno());
			obj.put("name", vo.getName());
			obj.put("score", vo.getScore());
			String poster = vo.getPoster();
			poster = poster.substring(0,poster.indexOf("^"));
			poster = poster.replace("#", "&");
			obj.put("poster", poster);
			
			if(i == 0) {
				obj.put("curpage", curpage);
				obj.put("totalpage", totalpage);
				obj.put("startPage", startPage);
				obj.put("endPage", endPage);
			}
			arr.add(obj);
			i++;
			
		}
		return arr.toJSONString();
	}
/////////////////////////////////////////////////////////////////////
}
