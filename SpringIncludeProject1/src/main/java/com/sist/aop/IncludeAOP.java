package com.sist.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.FooterDAO;
import com.sist.vo.DataBoardVO;
import com.sist.vo.NoticeVO;

// DispatcherServlet => 연결하는 클래스(@Controller, @RestController) -> 요청한 매개변수를 주입

@Aspect
@Component // 메모리 할당
public class IncludeAOP {
	@Autowired
	private FooterDAO dao;

	@After("execution(* com.sist.web.*Controller.*(..))") // 어느시점에 호출할것인가 @after:맨 마지막에 호출
	public void footerData() {
		// 현재 사용중인 request객체를 얻어온다 : AOP, Intercepter, Task
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<NoticeVO> nList = dao.noticeDataTop5();
		List<DataBoardVO> dList = dao.databoardDataTop5();
		request.setAttribute("dList", dList);
		request.setAttribute("nList", nList);
	}
}
