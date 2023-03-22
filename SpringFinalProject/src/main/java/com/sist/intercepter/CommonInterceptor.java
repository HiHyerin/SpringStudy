package com.sist.intercepter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
 *                                  인테셉트(preHandle()) => 자동 로그인 , ID저장
 *   사용자 요청  ====> DispatcherServlet ======> @Controller =====> ViewResolver ======> JSP  | 인터셉트(afterCompletion)
 *     .do                                     -----------   | 인터셉트 (postHandle())
 *                                                |
 *                                              @GetMapping/@PostMapping/@RequestMapping => 메소드를 찾아서 처리
 */
public class CommonInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Cookie[] cookies=request.getCookies();
		if(cookies != null) {
			for(int i=0;i<cookies.length;i++) {
				String key = cookies[i].getName();
				if(key.equals("id")) {
					String id = cookies[i].getValue();
					request.setAttribute("id", id);
					request.setAttribute("ck", true);
					
					break;
				}
			}
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}