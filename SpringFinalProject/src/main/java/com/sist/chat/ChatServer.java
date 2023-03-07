package com.sist.chat;

import java.net.HttpURLConnection;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;
@ServerEndpoint("/site/chat/chat-ws")
public class ChatServer {
  private static List<Session> users=new ArrayList<Session>();
  // 클라이언트가 접속시에 
  @OnOpen
  public void onOpen(Session session)
  {
	  //HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	  //HttpSession se=request.getSession();
	  users.add(session);
	  System.out.println("클라이언트 접속..."+session.getId());
  }
  // 클라이언트 퇴장 
  @OnClose
  public void onClose(Session session)
  {
	  //HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	  //HttpSession se=request.getSession();
	  users.remove(session);
	  System.out.println("클라이언트 퇴장..."+session.getId());
  }
  // 클라이언트가 채팅 문자열 전송시 ....
  @OnMessage
  public void onMessage(String message,Session session) throws Exception
  {
	  System.out.println("수신 메세지:"+message);
	  //HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	  //HttpSession se=request.getSession();
	  //String name=(String)se.getAttribute("name");
	  Iterator<Session> iterator=users.iterator();
	  System.out.println("채팅 인원:"+users.size());
	  while(iterator.hasNext())
	  {
		  iterator.next().getBasicRemote().sendText(message);
	  }
  }
}