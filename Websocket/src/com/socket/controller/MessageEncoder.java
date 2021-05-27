package com.socket.controller;

import javax.websocket.*;
import javax.websocket.Encoder.*;

import com.google.gson.*;
import com.socket.model.vo.*;

public class MessageEncoder implements Text<Message> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(Message arg0) throws EncodeException {
 
		return new Gson().toJson(arg0);
	}
	
}
