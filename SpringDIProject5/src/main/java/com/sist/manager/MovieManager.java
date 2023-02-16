package com.sist.manager;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.*;


import com.sist.vo.MovieVO;
/*
 	일일 박스오피스 
 	실시간 예매율
 	좌석점유율순위
 	온라인상영관 일일
 */
@Component("mm")
public class MovieManager {
	
//	public static void main(String[] args) {
//		MovieManager m = new MovieManager();
//		List<MovieVO> list = m.movieListData(1);
//		for(MovieVO vo:list) {
//			System.out.println(vo.getRank()+" "+vo.getTitle()+" "+vo.getGenre()+" "+vo.getDirector());
//		}
//	}
	// https://www.kobis.or.kr/kobis/business/main/main.do
	private String[] strUrl = {"","searchMainDailyBoxOffice.do","searchMainRealTicket.do","searchMainDailySeatTicket.do","searchMainOnlineDailyBoxOffice.do"};
	public List<MovieVO> movieListData(int no){
		List<MovieVO> list = new ArrayList<MovieVO>();
//		try {
//			URL url = new URL("https://www.kobis.or.kr/kobis/business/main/"+strUrl[no]);
//			HttpURLConnection conn =(HttpURLConnection)url.openConnection();
//			if(conn!=null) { // 연결이 되었다면
//				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				while(true) {
//					String data = br.readLine();
//					if(data == null) break;
//					System.out.println(data);
//					}
//				}
//			
//		}catch (Exception e) {}
		try {
			Document doc = Jsoup.connect("https://www.kobis.or.kr/kobis/business/main/"+strUrl[no]).get();
			String data = doc.toString();
			data = data.substring(data.indexOf("["),data.lastIndexOf("]")+1);
			//										--------------------- 미만이기 때문에 ]포함하려면 +1 해야함
			data = data.replace("<", "");
			data = data.replace(">", "");
			//System.out.println(data);
			//			System.out.println(doc.toString());
			JSONParser jp = new JSONParser();
			JSONArray arr = (JSONArray)jp.parse(data);
			/*
			 	JSONArray => [] (arraylist)
			 	JSONObject => {} (객체)
			 	영화 한개에 대한 정보 : [{},{},{},{},{}...]  {} = vo
			 	["a","v","c","d"...] => String
			 	[{},{},{}...] => JSONObject
			 */
			for(int i=0;i<arr.size();i++) {
				JSONObject obj = (JSONObject)arr.get(i); // 배열 안에 들어간 값을 하나씩 가져오는것
				MovieVO vo = new MovieVO();
				String rank = String.valueOf((long)obj.get("rank"));
				vo.setRank(Integer.parseInt(rank));
				vo.setTitle((String)obj.get("movieNm"));
				vo.setDirector((String)obj.get("director"));
				vo.setGenre((String)obj.get("genre"));
				list.add(vo);
			}
					
		} catch (Exception e) {e.printStackTrace();}
		return list;
	}
}
