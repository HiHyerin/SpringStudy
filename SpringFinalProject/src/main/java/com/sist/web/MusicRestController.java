package com.sist.web;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.*;
import com.sist.vo.*;

@RestController
public class MusicRestController {
	@Autowired
	private MusicDAO dao;
	
	@GetMapping(value="music/list.do", produces = "text/plain;charset=utf-8")
	public String music_list() {
		List<MusicVO> list = dao.musicAllData();
		JSONArray arr = new JSONArray();
		for(MusicVO vo:list) {
			JSONObject obj = new JSONObject();
			obj.put("no", vo.getNo());
			obj.put("title", vo.getTitle());
			obj.put("singer", vo.getSinger());
			obj.put("album", vo.getAlbum());
			obj.put("poster", vo.getPoster());
			arr.add(obj);
		}
		return arr.toJSONString();
	}
	
	@GetMapping(value="music/detail.do", produces = "text/plain;charset=utf-8")
	public String music_detail(int no) {
		MusicVO vo = dao.musicDetailData(no);
		JSONObject obj = new JSONObject();
		obj.put("title", vo.getTitle());
		obj.put("key", vo.getKey());
		return obj.toJSONString();
	}
}
