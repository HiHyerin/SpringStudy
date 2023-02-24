package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.*;

@Controller // -> 얘는 component라고 쓰면 안됨 반드시 controller이나 restcontroller
public class EmpController {
	@Autowired
	private EmpDAO dao;
	
	// ok.do, <form method=post>, ajax=type:post 일 경우에만 postmapping>
	@GetMapping("emp/list.do")
	public String emp_list(Model model) {
		List<String> list = dao.empNameListData();
		model.addAttribute("list", list);
		return "emp/list";
	}
	
	@PostMapping("emp/info.do")
	public String emp_info(Model model, String[] names) {
		Map map = new HashMap();
		map.put("names", names); // emp-mappers랑 이름이 같아야한다.
		List<EmpVO> list= dao.empInfoData(map);
		model.addAttribute("list", list);
		return "emp/info";
	}
}
