package com.sist.web;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.sist.dao.*;

@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping(value="board/list_vue.do", produces = "text/plain;charset=utf-8")
	public String board_list(int page) {
		Map map = new HashMap<>();
		map.put("start", (page*10)-9);
		map.put("end", page*10);
		List<BoardVO> list = dao.boardListData(map);
		int totalpage = dao.boardTotalPage();
		
		//json 변환
		JSONArray arr = new JSONArray();
		int i = 0;
		for(BoardVO vo:list) {
			JSONObject obj = new JSONObject();
			obj.put("no", vo.getNo());
			obj.put("subject", vo.getSubject());
			obj.put("name", vo.getName());
			obj.put("dbday", vo.getDbday());
			obj.put("hit", vo.getHit());
			if(i==0) {
				obj.put("curpage", page);
				obj.put("totalpage", totalpage);
			}
			arr.add(obj);
			i++;
		}
		return arr.toJSONString();
	}
	
	@GetMapping("board/insert_vue.do")
	public String board_insert(BoardVO vo) {
		dao.boardInsert(vo);
		return "";
	}
	
	@GetMapping(value="board/detail_vue.do", produces ="text/plain;charset=utf-8" )
	public String board_detail(int no) {
		BoardVO vo = dao.boardDetailData(no);
		JSONObject obj = new JSONObject();
		obj.put("no", vo.getNo());
		obj.put("subject", vo.getSubject());
		obj.put("name", vo.getName());
		obj.put("dbday", vo.getDbday());
		obj.put("hit", vo.getHit());
		obj.put("content", vo.getContent());
		return obj.toJSONString();
	}
	
	@GetMapping(value="board/update_vue.do", produces ="text/plain;charset=utf-8" )
	public String board_update(int no) {
		BoardVO vo = dao.boardDetailData(no);
		JSONObject obj = new JSONObject();
		obj.put("no", vo.getNo());
		obj.put("subject", vo.getSubject());
		obj.put("name", vo.getName());
		obj.put("content", vo.getContent());
		return obj.toJSONString();
	}
	
	@GetMapping("board/update_ok_vue.do")
	public String board_update_od(BoardVO vo) {
		String res=dao.boardUpdate(vo);
		return res;
	}
	
	@GetMapping("board/delete_vue.do")
	public String board_delete_ok(int no, String pwd) {
		String res = dao.boardDelete(no, pwd);
		return res;
	}
	
}
