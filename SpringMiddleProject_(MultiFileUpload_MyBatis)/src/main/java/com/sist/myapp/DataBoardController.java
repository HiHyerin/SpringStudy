package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;

@Controller // 브라우저와 연결
public class DataBoardController {
	// 오라클 연결 => dao
	@Autowired
	private DataBoardDAO dao;
	
	// 1.목록출력
	@GetMapping("databoard/list.do")
	public String databoard_list(String page, Model model) { // Model이 request를 대체
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		Map map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		List<DataBoardVO> list = dao.dataBoardListData(map);
		
		int totalpage = dao.databoardTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		return "databoard/list"; // forward => request, model을 jsp로 전송
	}
	
	@GetMapping("databoard/insert.do")
	public String databoard_insert() { // 입력폼만 받기 때문에 매개변수 x
		return "databoard/insert";
	}
	
	@PostMapping("databoard/insert_ok.do")
	public String databoard_insert_ok(DataBoardVO vo) {
		
		List<MultipartFile> list = vo.getFiles();
		if(list==null) { //업로드 안된상태
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		}else { // 업로드가 된상태
			String fn = "";
			String fs = "";
			for(MultipartFile mf:list) {
				String of = mf.getOriginalFilename();
				fn+=of+","; // 데이터베이스 첨부
				File file = new File("c:\\download\\"+of);//업로드
				fs+=mf.getSize()+",";
				try {
					mf.transferTo(file);
				}catch(Exception e) {}
			}
			vo.setFilename(fn.substring(0,fn.lastIndexOf(","))); // 마지막에 있는 "," 지우기 위해 쓴것
			vo.setFilesize(fs.substring(0,fs.lastIndexOf(",")));
			vo.setFilecount(list.size());
		}
		dao.databoardInsert(vo);
		return "redirect:list.do"; // list.do메소드를 다시 호출하는 것 
		//	sendRedirect => request를 초기화 => 화면 이동
		// return databoard/list를 쓰면 빈 화면만 나온다
//		(public String databoard_list(String page, Model model) { // Model이 request를 대체
//			
//			return "databoard/list";
//		} 를 해야 데이터가 나오는데 list.do를 씀으로서 이 메소드를 다시 호출
	}
	
	// redirectAttributes => redirect => 데이터 전송
	
	@GetMapping("databoard/detail.do")
	public String databoard_detail(int no, Model model) {
		
		DataBoardVO vo = dao.databoardDetailData(no);
		if(vo.getFilecount()>0) {
		String[] fn = vo.getFilename().split(",");
		String[] fs = vo.getFilesize().split(",");
		List<String> nList = Arrays.asList(fn);
		List<String> sList = Arrays.asList(fs);
		
		model.addAttribute("nList", nList);
		model.addAttribute("sList", sList);
		}
		model.addAttribute("vo", vo);
		return "databoard/detail";
	}
	
	//download.do?fn=${fn }
	// @controller => 리턴형 (String(화면이동), void(자체처리))
	@GetMapping("databoard/download.do")
	public void databoard_download(String fn, HttpServletResponse response) {
		try {
			File file = new File("c:\\download\\"+fn);
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fn, "UTF-8")); // 다운로드 창 팝업 띄우기
			response.setContentLength((int)file.length()); // 다운로드 크기만큼 생기는 진행바..?
			
			//실제 다운로드
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			int i=0;
			byte[] buffer = new byte[1024];
			
			while((i=bis.read(buffer, 0, 1024))!= -1) {
				bos.write(buffer,0,i);
			}
			bis.close();
			bos.close();
			
		} catch (Exception e) {}
	}
	
	//<a href="update.do?no=${vo.no }"
	@GetMapping("databoard/update.do")
	public String databoard_update(int no, Model model) {
		DataBoardVO vo = dao.databoardUpdateData(no);
		model.addAttribute("vo", vo);
		return "databoard/update";
	}


	// 실제수정 update_ok.do
	@PostMapping("databoard/update_ok.do")
	public String databoard_update_ok(DataBoardVO vo, RedirectAttributes ra) { // redirect일 때에는 Model model 대신 사용
		dao.databoardUpdate(vo);
		ra.addAttribute("no", vo.getNo()); // ?no=
		return "redirect:detail.do";
	}
	
	// <form method = "post" action="find.do">
	@PostMapping("databoard/find.do")
	public String databoard_find(String[] fs, String ss, Model model) {
		System.out.println("fs:"+Arrays.toString(fs));
		Map map = new HashMap();
		map.put("fsArr", fs);
		
		map.put("ss", ss);
		//dao 연동 = 검색데이터 읽기
		List<DataBoardVO> list = dao.databoardFindData(map);
		int count = dao.FindCount(map);
		model.addAttribute("count", count);
		model.addAttribute("list",list);
		return "databoard/find";
	}
	
	
		
}
