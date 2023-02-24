package com.sist.myapp;
import java.io.File;
import java.util.*;

import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.*;

@RestController
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dao; //setterDI
	
	@PostMapping("databoard/delete.do") // 파일삭제하고 글 삭제
	public String databoard_delete(int no, String pwd) {
		String result="";
		try {
			DataBoardVO vo = dao.databoardFileinfoData(no);
			if(vo.getFilecount()>0) {
				String[] fn = vo.getFilename().split(",");
				for(String f:fn) {
					File file = new File("c:\\download\\"+f);
					file.delete();
				}
			}
		}catch (Exception e) {}
		boolean bCheck = dao.databoardDelete(no, pwd);
		if(bCheck == true)
			result = "yes";
		else
			result = "no";
		return result;
	}
	
	
	//url:'pwd_check.do',
		@PostMapping("databoard/pwd_check.do")
		public String pwd_check(int no, String pwd) {
			String result ="";
			boolean bCheck = dao.pwdCheck(no, pwd);
			if(bCheck == true)
				result = "yes";
			else
				result="no";
			return result;
		}
	
}
