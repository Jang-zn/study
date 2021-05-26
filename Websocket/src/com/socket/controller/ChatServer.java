package com.socket.controller;

import java.util.*;

import javax.websocket.*;
import javax.websocket.server.*;

@ServerEndpoint("/chat")
public class ChatServer {
	@OnOpen
	public void open(Session session, EndpointConfig config) {
		System.out.println("접속");
		System.out.println(session.getId());
	}
	@OnMessage
	public void message(Session session, String msg) {
		//접속한 모든 세션 가져오기 -> session.getOpenSessions();
		// List Set Map 등으로 관리함 -> 이후에 Spring 가서 또 쓸거니까 잘 해야됨
		
		Set<Session> clients = session.getOpenSessions(); //접속한 세션 다가져옴
		String[] curMsg = msg.split(","); //받은 메세지 파싱 (0 보낸사람 1 받는사람 2 메세지)
		//client 정보 저장 : session.getUserProperties()불러와서 .put() 해준다.
		session.getUserProperties().put("msg", msg.split(","));
		
		for(Session s : clients) {
			String[] clientData=(String[])s.getUserProperties().get("msg");
			try {
				if(clientData!=null&&(clientData[0].equals(curMsg[1])||clientData[0].equals(curMsg[0]))) {  
					// 보낸사람과 받는사람 구분값이 같으면 (1:1대화)
					s.getBasicRemote().sendText(msg); //stream 처리라서 Exception 처리 필요
				}else if(clientData!=null&&curMsg[1].equals("")){
					// 받는사람이 없으면 (전체대화)
					s.getBasicRemote().sendText(msg);
				}
			}catch(Exception e) {
				
			}
		}
	}
	@OnClose
	public void close(Session session, CloseReason reason) {
		
	}
}
