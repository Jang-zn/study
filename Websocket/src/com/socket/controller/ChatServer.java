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
		Set<Session> clients = session.getOpenSessions();
		
		//client 정보 저장 : session.getUserProperties()불러와서 .put() 해준다.
		session.getUserProperties().put("msg", clients);
		
		
		for(Session s : clients) {
			try {
			s.getBasicRemote().sendText(msg); //stream 처리라서 Exception 처리 필요
			}catch(Exception e) {
				
			}
		}
	}
	@OnClose
	public void close(Session session, CloseReason reason) {
		
	}
}
