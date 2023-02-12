package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
@Controller
public class EmpController {
	@Autowired // empdao() dao = new empdao();
	private EmpDAO dao; //╫л╠шео фпео
	
	@RequestMapping("emp/list.do")
	public String emp_list(HttpServletRequest request, HttpServletResponse response) {
		List<EmpVO> list = dao.empListData();
		request.setAttribute("list", list);
		return "emp/list";
	}
}
