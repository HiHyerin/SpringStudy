package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
	@RequestMapping("movie/list.do")
	public String movie_list(HttpServletRequest request, HttpServletResponse response) {
		return "movie/list";
	}
}
