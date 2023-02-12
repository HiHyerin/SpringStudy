package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_main(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg", "hello Spring!");
		return "main/main";
	}
	
	@RequestMapping("main/sub.do")
	public String main_sub(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:main.do";
	}
}
