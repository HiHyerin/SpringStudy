package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import com.sist.vo.*;

@Controller
@RequestMapping("member/") // 경로명이 길면 쓴다
public class MemberFController {
	@Autowired
	private MemberDAO dao;
	
	@GetMapping("join.do")
	public String member_join() {
		
		return "member/join";
	}
}
