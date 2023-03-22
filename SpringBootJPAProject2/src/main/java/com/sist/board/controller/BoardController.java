package com.sist.board.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.board.dao.BoardDAO;
import com.sist.board.entity.BoardEntity;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;

	@GetMapping("/list")
	public String board_list(String page, Model model) {
		if(page==null)
			page = "1";
		int curpage = Integer.parseInt(page);
		int start = (curpage*10)-10;
		List<BoardEntity> list = dao.boardListData(start);
		int totalpage = dao.boardTotalPage();
		model.addAttribute("list",list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		return "board/list";
	}

	@GetMapping("/insert")
	public String board_insert() {
		return "board/insert";
	}

	@PostMapping("/insert_ok")
	public String board_insert_ok(BoardEntity vo) {
		dao.save(vo);
		return "redirect:/list";
	}
	
	@GetMapping("/detail")
	public String board_detail(int no, Model model) {
		BoardEntity vo = dao.findByNo(no);
		///////////////////////////
		vo.setHit(vo.getHit()+1);
		dao.save(vo);
		///////////////////////////	 조회수 증가	
		vo = dao.findByNo(no);
		model.addAttribute("vo", vo);
		return "board/detail";
	}
	
	@GetMapping("/update")
	public String board_update(int no, Model model) {
		BoardEntity vo = dao.findByNo(no);
		model.addAttribute("vo", vo);
		return "board/update";
	}
	
	@PostMapping("/update_ok")
	public String board_update_ok(BoardEntity vo, Model model) {
		BoardEntity dbvo = dao.findByNo(vo.getNo());
		String result = "";
		if(dbvo.getPwd().equals(vo.getPwd())) {
			result="yes";
			dao.save(vo);
		}else {
			result="no";
		}
		model.addAttribute("no", vo.getNo());
		model.addAttribute("result", result);
		return "board/update_ok";
	}
	
	@GetMapping("/delete")
	public String board_delete(int no, Model model) {
		model.addAttribute("no", no);
		return "board/delete";
	}
	
	@PostMapping("/delete_ok")
	public String board_delete_ok(int no, String pwd, Model model) {
		BoardEntity vo = dao.findByNo(no);
		String result="no";
		if(vo.getPwd().equals(pwd)) {
			result="yes";
			dao.delete(vo);
		}
		model.addAttribute("result", result);
		return "board/delete_ok";
	}
}
