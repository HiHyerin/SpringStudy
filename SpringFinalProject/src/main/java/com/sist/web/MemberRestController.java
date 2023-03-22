package com.sist.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;
@RestController
public class MemberRestController {
   @Autowired
   private BCryptPasswordEncoder encoder; // 비밀번호 암호화
	
	@Autowired
   private MemberDAO dao;

   @GetMapping(value="member/login_vue.do",produces = "text/html;charset=UTF-8")
   public String member_login(String id,String pwd,boolean ck, HttpSession session, HttpServletResponse response)
   {
	   String res="";
	   int count = dao.memberIdCheck(id);
	   if(count == 0) {
		   res = "NOID";
	   }else {
		   MemberVO vo = dao.memberLogin(id, pwd);
		   if(encoder.matches(pwd, vo.getPwd())) { // 복호화
			   res="OK";
			   session.setAttribute("id", id);
			   session.setAttribute("name", vo.getName());
			   session.setAttribute("admin", vo.getAdmin());
			   // checkbox => true => Cookie에 저장
			   if(ck == true) {
				   Cookie cookie = new Cookie("id", id);
				   cookie.setPath("/");
				   cookie.setMaxAge(60*60*24);
				   response.addCookie(cookie);
			   }
		   }else {
			   res="NOPWD";
		   }
	   }
	   return res;
   }

   @GetMapping("member/logout_vue.do")
   public String member_logout(HttpSession session) {
	   session.invalidate();
	   return "";
   }
   
   @GetMapping("member/idcheck_vue.do")
   public String member_idcheck(String id) {
	   int count = dao.memberIdCheck(id);
	   String res = count==0?"yes":"no";
	   return res;
   }
   
   @GetMapping("member/insert_vue.do")
   public String member_insert(MemberVO vo) {
	   String res = "no";
	   try {
		res="yes";
		String pwd=encoder.encode(vo.getPwd()); // 암호화
		vo.setPwd(pwd);
		dao.memberInsert(vo);
	} catch (Exception e) {
		res="no";
	}
	   return res;
   }
}