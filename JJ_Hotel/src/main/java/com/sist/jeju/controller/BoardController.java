package com.sist.jeju.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.jeju.dao.BoardDAO;
import com.sist.jeju.entity.BoardEntity;

@Controller
@RequestMapping("board/")
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("board_list")
	public String board_list(String page, Model model) {
		if(page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		int rowSize = 10;
		int start = (curpage*rowSize)-rowSize; // 0부터 시작
		List<BoardEntity> list = dao.boardListData(start);
		
		for(BoardEntity vo:list) {
			String s = vo.getRegdate();
			String[] ss = s.split(" ");
			vo.setRegdate(ss[0]);
		}
		
		int totalpage = dao.boardTotalPage();
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		model.addAttribute("main_content", "board/board_list");
		return "main";
	}
	
	@GetMapping("board_detail")
	public String board_detail(int no, Model model) {
		BoardEntity vo = dao.findByNo(no);
		//조회수 증가///////////////////////
		vo.setHit(vo.getHit()+1);
		dao.save(vo); // update
		///////////////////////////
		vo = dao.findByNo(no);
		model.addAttribute("vo", vo);
		model.addAttribute("main_content", "board/board_detail");
		
		return "main";
	}
	
	@GetMapping("board_update")
	public String board_update(int no, Model model) {
		BoardEntity vo = dao.findByNo(no);
		model.addAttribute("vo", vo);
		model.addAttribute("main_content", "board/board_update");
		return "main";
	}
	
	@GetMapping("board_delete")
	public String board_delete(int no, Model model) {
		model.addAttribute("no", no);
		model.addAttribute("main_content", "board/board_delete");
		return "main";
	}
	
	@GetMapping("board_insert")
	public String board_insert(Model model) {
		model.addAttribute("main_content", "board/board_insert");
		return "main";
	}
	
	@PostMapping("board_insert_ok")
	public String board_insert_ok(BoardEntity vo) {
		dao.save(vo);
		return "redirect:../board/board_list";
	}
	
}