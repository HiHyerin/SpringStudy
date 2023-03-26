package com.sist.web.news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import com.sist.web.entity.*;
@Component
public class NewsManager {
//	public static void main(String[] args) {
//	NaverNewsManager n = new NaverNewsManager();
//	n.newsData("레시피");
//}
	public List<NewsVO> newsListData(String ss) {
		List<NewsVO> list = new ArrayList<>();
		String json = newsData(ss);
		try {
			JSONParser jp = new JSONParser();
			JSONObject root = (JSONObject) jp.parse(json);
			JSONArray arr = (JSONArray) root.get("items");
			for (Object element : arr) {
				JSONObject obj = (JSONObject) element;
				NewsVO vo = new NewsVO();
				vo.setTitle(obj.get("title").toString());
				vo.setDescription(obj.get("description").toString());
				vo.setLink(obj.get("link").toString());
				String day = obj.get("pubDate").toString();
				String newsday = new SimpleDateFormat("yyyy-MM-dd").format(new Date(day));
				vo.setPubDate(newsday);
				list.add(vo);
			}
		} catch (Exception e) {
		}

		return list;
	}

	public String newsData(String ss) {

		String clientId = "c57ZOrbsypObG2wy7P2P"; // 애플리케이션 클라이언트 아이디값"
		String clientSecret = "3U_nuIT_Z5"; // 애플리케이션 클라이언트 시크릿값"

		String text = null;
		try {
			text = URLEncoder.encode(ss, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		String apiURL = "https://openapi.naver.com/v1/search/news.json?display=100&query=" + text; // json 결과
		// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
		// // xml 결과

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);

		// System.out.println(responseBody);
		return responseBody;
	}

	private String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}
}
