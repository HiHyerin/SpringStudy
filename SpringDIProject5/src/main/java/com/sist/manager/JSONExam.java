package com.sist.manager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONExam {
// JSON : 자바스크립트 객체 표현법(JavaScript Object Notation)
/*
 	JSONArray => [] (arraylist)
 	JSONObject => {} (객체)
 	영화 한개에 대한 정보 : [{},{},{},{},{}...]  {} = vo
 	["a","v","c","d"...] => String
 	[{},{},{}...] => JSONObject
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json = "[{\"name\":\"홍길동1\", \"sex\":\"남자\", \"age\":\"25\", \"address\":\"서울\", \"tel\":\"1111-1111\"},"
					+ "{\"name\":\"홍길동2\", \"sex\":\"남자\", \"age\":\"25\", \"address\":\"서울\", \"tel\":\"2222-2222\"},"
					+ "{\"name\":\"홍길동3\", \"sex\":\"남자\", \"age\":\"25\", \"address\":\"서울\", \"tel\":\"2222-2222\"}]";
//		try {
//				JSONParser jp = new JSONParser(); 
//				JSONObject obj = (JSONObject)jp.parse(json);
//				System.out.println("이름:"+obj.get("name"));
//				System.out.println("성별:"+obj.get("sex"));
//				System.out.println("나이:"+obj.get("age"));
//				System.out.println("주소:"+obj.get("address"));
//				System.out.println("전화:"+obj.get("tel"));
//		} catch (Exception e) {e.printStackTrace();}
		/*
		 	데이터 종류
		 	정형화 : 정형화 : 필요한 데이터만 모아서 관리(데이터 구분) => 
		 	반정형화
		 	비정형화
		 */
		
		try {
			JSONParser jp = new JSONParser();
			JSONArray arr = (JSONArray)jp.parse(json); // arraylist
			System.out.println(arr.toJSONString());
			for(int i=0;i<arr.size();i++){
				JSONObject obj = (JSONObject)arr.get(i); // vo
//				System.out.println(obj.toJSONString());
				System.out.println("이름:"+obj.get("name"));
				System.out.println("성별:"+obj.get("sex"));
				System.out.println("나이:"+obj.get("age"));
				System.out.println("주소:"+obj.get("address"));
				System.out.println("전화번호:"+obj.get("tel"));
				System.out.println("===========================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
