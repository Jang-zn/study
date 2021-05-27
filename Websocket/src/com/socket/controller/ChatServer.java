package com.socket.controller;

import java.util.*;

import javax.websocket.*;
import javax.websocket.server.*;

import com.google.gson.*;
import com.socket.model.vo.*;

@ServerEndpoint(
		value = "/chat",
		encoders = {MessageEncoder.class},  
		decoders = {MessageDecoder.class}
		)
//encode(나갈때(json으로)) / decode(들어올때 class로) 로직(클래스) 설정해놓으면 
//알아서 들어오고 나가는 msg들을 Gson / Json 처리나 뭐 파싱하는 그걸 다 해줌
public class ChatServer {
	@OnOpen
	public void open(Session session, EndpointConfig config) {
		System.out.println("접속");
		System.out.println(session.getId());
	}
	@OnMessage
	public void message(Session session, Message curMsg) {
		//
		
		
		//접속한 모든 세션 가져오기 -> session.getOpenSessions();
		// List Set Map 등으로 관리함 -> 이후에 Spring 가서 또 쓸거니까 잘 해야됨
		
		Set<Session> clients = session.getOpenSessions(); //접속한 세션 다가져옴
//		String[] curMsg = msg.split(","); //받은 메세지 파싱 (0 보낸사람 1 받는사람 2 메세지)
//		//client 정보 저장 : session.getUserProperties()불러와서 .put() 해준다.
//		session.getUserProperties().put("msg", msg.split(","));
//		for(Session s : clients) {
//			String[] clientData=(String[])s.getUserProperties().get("msg");
//			try {
//				if(clientData!=null&&(clientData[0].equals(curMsg[1])||clientData[0].equals(curMsg[0]))) {  
//					// 보낸사람과 받는사람 구분값이 같으면 (1:1대화)
//					s.getBasicRemote().sendText(msg); //stream 처리라서 Exception 처리 필요
//				}else if(clientData!=null&&curMsg[1].equals("")){
//					// 받는사람이 없으면 (전체대화)
//					s.getBasicRemote().sendText(msg);
//				}
//			}catch(Exception e) {
//				
//			}
//		}
		
		
		//Gson으로 처리하기
		//Message curMsg = new Gson().fromJson(msg, Message.class);  decode / encode 하면 뭐 할거 없음
		session.getUserProperties().put("msg", curMsg);

//		for(Session s : clients) {
//			Message clientData=(Message)s.getUserProperties().get("msg");
//			try {
//				if(clientData!=null&&(clientData.getSender().equals(curMsg.getReceiver())||clientData.getSender().equals(curMsg.getSender()))) {  
//					// 보낸사람과 받는사람 구분값이 같으면 (1:1대화)
//					s.getBasicRemote().sendText(msg); //stream 처리라서 Exception 처리 필요
//				}else if(clientData!=null&&curMsg.getReceiver().equals("")){
//					// 받는사람이 없으면 (전체대화)
//					s.getBasicRemote().sendText(msg);
//				}
//			}catch(Exception e) {
//				
//			}
//		}
		
		
		//encode / decode 설정 후에는 sendObject로 보내준다.
		for(Session s : clients) {
			Message clientData=(Message)s.getUserProperties().get("msg");
			try {
				if(clientData!=null&&(clientData.getSender().equals(curMsg.getReceiver())||clientData.getSender().equals(curMsg.getSender()))) {  
					// 보낸사람과 받는사람 구분값이 같으면 (1:1대화)
					s.getBasicRemote().sendObject(curMsg); //stream 처리라서 Exception 처리 필요
				}else if(clientData!=null&&curMsg.getReceiver().equals("")){
					// 받는사람이 없으면 (전체대화)
					s.getBasicRemote().sendObject(curMsg);
				}
			}catch(Exception e) {
				
			}
		}
		
		
		
		
	}
	@OnClose
	public void close(Session session, CloseReason reason) {
		
	}
}
