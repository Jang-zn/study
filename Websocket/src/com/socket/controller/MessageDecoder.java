package com.socket.controller;

import javax.websocket.*;
import javax.websocket.Decoder.*;

import com.google.gson.*;
import com.socket.model.vo.*;

public class MessageDecoder implements Text<Message> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message decode(String arg0) throws DecodeException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(arg0,Message.class);
	}

	@Override
	public boolean willDecode(String arg0) {
		// TODO Auto-generated method stub
		return true;  //이거 true로 해줘야 처리됨
	}

}
