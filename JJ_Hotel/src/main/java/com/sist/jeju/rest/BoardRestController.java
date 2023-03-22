package com.sist.jeju.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.jeju.dao.BoardDAO;
import com.sist.jeju.entity.BoardEntity;

import java.util.*;

@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@PostMapping("/board/board_update_ok")
	public String board_update_ok(BoardEntity vo, Model model) {
		BoardEntity dbvo = dao.findByNo(vo.getNo());
		String res="no";
		if(dbvo.getPwd().equals(vo.getPwd())) {
			dao.save(vo);
			res="<script>"
					+ "location.href=\"/board/board_detail?no="+vo.getNo()+"\";"
					+ "</script>";
		}else {
			res="<script>"
					+ "alert(\"비밀번호가 틀립니다!!\");"
					+ "history.back();"
					+ "</script>";
		}
		
		return res;
	}
	
	
	@PostMapping("/board/board_delete_ok")
	public String board_delete_ok(int no, String pwd, Model model) {
		BoardEntity dbvo = dao.findByNo(no);
		String res="no";
		if(dbvo.getPwd().equals(pwd)) {
			dao.delete(dbvo);
			res="<script>"
					+ "location.href=\"/board/board_list\";"
					+ "</script>";
		}else {
			res="<script>"
					+ "alert(\"비밀번호가 틀립니다!!\");"
					+ "history.back();"
					+ "</script>";
		}
		
		return res;
	}
}
