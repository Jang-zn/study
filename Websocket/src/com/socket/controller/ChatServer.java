package com.socket.controller;

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
		
	}
	@OnClose
	public void close(Session session, CloseReason reason) {
		
	}
}
