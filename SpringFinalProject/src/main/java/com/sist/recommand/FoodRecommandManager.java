package com.sist.recommand;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
/*
 	{...item:[{},{},{},,,]}
 */
@Component
public class FoodRecommandManager {

	public List<String> jsonParser(String json){
		List<String> list = new ArrayList<>();
		try {
			JSONParser jp = new JSONParser();
			JSONObject root = (JSONObject)jp.parse(json);
			JSONArray arr = (JSONArray) root.get("items");
			for (Object element : arr) {
				JSONObject obj = (JSONObject)element;
				String desc = (String) obj.get("description");
				list.add(desc);
			} // 값 가져옴 -> 나머지는 레스트컨트롤러에서 처리
		} catch (Exception e) {}
		return list;
	}
}
