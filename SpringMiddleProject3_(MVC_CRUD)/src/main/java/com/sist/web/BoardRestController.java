package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
@RestController  // 데이터  전송 (javascript, json) => 수정, 삭제 (script보내야 할 떄 restController사용)
// vue, ajax, react 연결할 때 사용
/*
 	@Controller : 화면 변경(return => 화면 (forward, redirect))
 	@restController : 데이터 전송(json, javascript, ajax)
 	@Repository : 데이터 베이스 연결
 	@Component :일반클래스 => Jsoup, Manager...(Open API)
 	@Service : DAO 여러개를 통합해서 사용
 */
public class BoardRestController {
	@Autowired
	private BoardDAO dao; // 싱글턴
	
	// <form method="post" action="update_ok.do">
	@RequestMapping(value="board/update_ok.do", produces ="text/html;charset=UTF-8") // 화면 이동하는 애x 
	//											------------------------------------ Json => text/plain
	public String board_update_ok(BoardVO vo) {
		String result="";
		boolean bCheck = dao.boardUpdate(vo);
		if(bCheck==true) {
			result = "<script>"
					+"location.href=\"detail.do?no="+vo.getNo()+"\""
					+"</script>";
		}else {
			result = "<script>"
					+"alert(\"비밀번호가 틀립니다!!\");"
					+"history.back();"
					+"</script>";
		}
		
		return result;
	}
	
	@RequestMapping(value="board/delete_ok.do", produces = "text/html;charset=UTF-8")
	public String board_delete(int no, String pwd) {
		String result = ""; // 매퍼로 고
		boolean bCheck = dao.boardDelete(no, pwd);
		if(bCheck==true) {
			result = "<script>"
					+"location.href=\"list.do\""
					+"</script>";
		}else {
			result = "<script>"
					+"alert(\"비밀번호가 틀립니다!!\");"
					+"history.back();"
					+"</script>";
		}
		return result;
	}
}
