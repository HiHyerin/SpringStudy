package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;
// Model역할
// 화면전환 = 리턴형이 jsp나 .do
@Controller
@RequestMapping("board/")
public class BoardController {
	@Autowired // 주소값 채워와라
	private BoardDAO dao;

	@RequestMapping("list.do")
	 public String board_list(String page, Model model) { // Model = 전송객체 => request전송(request.getparameter 대신)
		   
      if(page==null)
         page="1";
      int curpage=Integer.parseInt(page);
      Map map=new HashMap();
      int rowSize=10;
      int start =(rowSize*curpage)-(rowSize-1);
      int end =(rowSize*curpage);
      map.put("start", start); //#{start}
      map.put("end", end); //#{end}
      List<BoardVO> list=dao.boardListData(map);
      int totalpage=dao.boardTotalPage();
      model.addAttribute("curpage",curpage);
      model.addAttribute("totalpage",totalpage);
      model.addAttribute("list",list);// request.setAttribute("list",list);
      
      return "board/list";
   }


	   @RequestMapping("insert.do")
	   public String board_insert()
	   {
	      return "board/insert";
	   }
	   @RequestMapping("insert_ok.do")
	   public String board_insert_ok(BoardVO vo) 
	   {
	      dao.boardInsert(vo);
	      return "redirect:list.do";
	   }

//	<a href="detail.do?no=${vo.no}">${vo.subject }</a> no 변수명이 같아야함
	   @RequestMapping("detail.do")
	   public String board_detail(int no,Model model) // (전송객체) ->보내줄게 있을때 모델을 사용한다??
	   {
	      BoardVO vo=dao.boardDetailData(no);
	      model.addAttribute("vo",vo);
	      return "board/detail";
	   }
	   
//	   detail.jsp에서 가져옴 <a href="update.do?no=${vo.no }" class="btn btn-xs btn-danger">수정</a>
	   @RequestMapping("update.do") // if(uri.equals("update.do")) => 조건문 대신
	   public String board_update(int no, Model model) { // model은 전송할 값이 있을 때(addattribute)
		   
		   BoardVO vo = dao.boardUpdatelData(no);
		   String s = vo.getSubject();
		   s = s.replace("\"", ""); // 제목 처음에 따옴표있을때
		   vo.setSubject(s);
		   model.addAttribute("vo",vo);
		   return "board/update";
		   
	   }
	   
	   @RequestMapping("delete.do")
	   public String board_delete(int no, Model model) {
		   model.addAttribute("no",no);
		   return "board/delete";
	   }
	   
	   @RequestMapping("find.do")
	   public String board_find(String fs, String ss, Model model) {
		   Map map = new HashMap<>();
		   map.put("fs", fs);
		   map.put("ss", ss);
		   List<BoardVO> list = dao.boardFindData(map);
		   int count = dao.boardFindCount(map);
		   //데이터를 jsp로 전송
		   model.addAttribute("list",list);
		   model.addAttribute("count",count);
		   
		   return "board/find";
	   }
	   



}
