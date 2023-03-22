package com.sist.web;
// vo => mapper => dao => controller => jsp(javascript : rest -> 타 프로그램과 연동)

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.EmpDAO;
import com.sist.vo.EmpVO;

@RestController
public class EmpRestController {
	@Autowired
	private EmpDAO dao;

	@GetMapping(value="emp/list.do", produces = "text/plain;charset=utf-8")
	public String emp_list() {
		List<EmpVO> list = dao.empListData(); // => JSON으로 변환 [] (JsonArray)
		// EmpVO {} (JSONObject)
		JSONArray arr = new JSONArray();
		for(EmpVO vo:list) {
			JSONObject obj = new JSONObject();
			obj.put("empno", vo.getEmpno());
			obj.put("ename", vo.getEname());
			obj.put("job", vo.getJob());
			obj.put("hiredate", vo.getDbday());
			obj.put("sal",vo.getSal());
			obj.put("dname", vo.getDvo().getDname()); // join
			obj.put("loc", vo.getDvo().getLoc()); // join
			arr.add(obj);
		}
		return arr.toJSONString();
	}

}
