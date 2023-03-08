package com.sist.web;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;
import com.sist.openapi.*;

@Controller
public class NewsFController {
	@GetMapping("news/find.do")
	public String news_find() {
		return "news/find";
	}
}
