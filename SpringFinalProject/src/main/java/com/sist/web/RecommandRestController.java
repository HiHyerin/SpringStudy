package com.sist.web;

/*
 상황
	출/퇴근길 휴식 일/공부 집 카페 휴가/여행 드라이브 산책 운동 하우스파티 시상식 집중 거리 클럽 고백 해변 공연 라운지 애도
감성
	기분전환 외로움 슬픔 힘찬 이별 지침/힘듦 설렘 오후 위로 밤 새벽 저녁 아침 사랑 스트레스/짜증 그리움 추억 우울 행복 불안 분노 기쁨 축하
스타일
	밝은 신나는 편안한 따뜻한 그루브한 부드러운 로맨틱한 웅장한 매혹적인 영화음악 잔잔한 몽환적인 댄서블한 달콤한 시원한 애절한 어두운 연주음악 발렌타인데이 화이트데이
날씨/계절
	봄 여름 가을 겨울 맑은날 추운날 흐린날 비오는날 더운날 안개낀날 눈오는날
 */
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.FoodDAO;
import com.sist.recommand.FoodRecommandManager;
import com.sist.recommand.NaverRecommandData;
import com.sist.vo.FoodVO;
@RestController
public class RecommandRestController {
	@Autowired
	private NaverRecommandData nrd;
	@Autowired
	private FoodRecommandManager mgr;
	@Autowired
	private FoodDAO dao;

	@GetMapping(value="food/recommand_change.do",  produces = "text/plain;charset=utf-8")
	public String recommand_change(int no) {
		String[] strArr = null;
		if(no==1) {
			strArr = new String[] {"퇴근길",  "휴식",  "공부",  "카페", "휴가",  "여행",  "드라이브",  "산책",  "운동",  "고백"};
		}else if(no==2) {
			strArr = new String[] {"기분전환",  "외로움",  "슬픔",  "힘찬",  "이별",  "지침",  "설렘",  "위로",  "스트레스",  "짜증",  "그리움",  "추억",  "행복",  "불안",  "분노",  "기쁨",  "축하"};
		}else if(no==3) {
			strArr = new String[] {"밝은",  "신나는",  "편안한", "달콤한", "시원한", "애절한"};
		}else if(no==4) {
			strArr = new String[] {"봄", "여름", "가을", "겨울", "맑은날", "추운날", "흐린날", "비오는날", "더운날",  "눈오는날"};
		}

		JSONArray arr = new JSONArray();
		for(String s:strArr) {
			arr.add(s);
		}
		return arr.toJSONString();
	}

	@GetMapping(value="food/recommand_result.do",  produces = "text/plain;charset=utf-8")
	public String recommand_result(String ss) {
		String json = nrd.newsData(ss);
		List<String> list = mgr.jsonParser(json);
		/*
		 * for(String s:list) { System.out.println(s); }
		 */
		List<String> nList = dao.foodGetNameData();
		Pattern[] p = new Pattern[nList.size()];
		int[] count = new int[nList.size()];
		for(int i=0;i<p.length;i++) {
			p[i] = Pattern.compile(nList.get(i)); // 찾는 문자열
		}

		// 정규식
		Matcher[] m = new Matcher[nList.size()];
		for(String s:list) { //s = 블로그내용
			for(int i=0;i<m.length;i++) {
				m[i] = p[i].matcher(s); // 블로그 내용중에 p[i]가 있는지
				if(m[i].find()) { // 블로그중에 맛집명이 존재한다면
					String data = m[i].group(); // 찾은 문자열을 가지고 오기
					count[i]++;
				}
			}
		}

		List<FoodVO> fList = new ArrayList<>();
		for(int i=0;i<nList.size();i++) {
			String name = nList.get(i);
			if(count[i]>2) {
				System.out.println(name+":"+count[i]);
				FoodVO vo = dao.foodInfoData(name);
				String poster = vo.getPoster();
				poster = poster.substring(0,poster.indexOf("^"));
				poster = poster.replace("#", "&");
				vo.setPoster(poster);
				fList.add(vo);
			}
		}

		// jsonarray로 변환
		JSONArray arr = new JSONArray();
		int i = 0;
		for(FoodVO vo:fList) {
			JSONObject obj = new JSONObject();
			obj.put("fno", vo.getFno());
			obj.put("name", vo.getName());
			obj.put("score", vo.getScore());
			obj.put("poster", vo.getPoster());
			if(i==0) {
				obj.put("count", fList.size());
			}

			arr.add(obj);
			i++;

		}
		return arr.toJSONString();
	}

	@GetMapping(value="food/food_location_detail_vue.do", produces = "text/plain;charset=utf-8")
	public String food_detail_vue(int fno) {
		FoodVO vo = dao.foodLocationDetailData(fno);
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
		JSONArray arr1 = new JSONArray();
		if(!menu.equals("no")) { // 메뉴가 no가 아니라면
			String[] s = menu.split("원");
			for(String ss:s) {
				arr1.add(ss);
			}
		}
		JSONArray arr2 = new JSONArray();
		String poster = vo.getPoster();
		StringTokenizer st = new StringTokenizer(poster, "^");
		while(st.hasMoreTokens()){
			arr2.add(st.nextToken());
		}
		obj.put("menu", arr1);
		obj.put("price", vo.getPrice());
		obj.put("parking", vo.getParking());
		obj.put("poster", arr2);

		return obj.toJSONString();
	}
}
