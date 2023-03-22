package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecommandController {
	@GetMapping("food/recommand.do")
	public String food_recommand() {
		return "recommand/recommand";
	}
}
