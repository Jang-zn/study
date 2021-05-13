package com.common.listener.controller;

import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session Created");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session Destroyed");
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("Session Attribute Added");
		System.out.println(se.getName());
		System.out.println(se.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("Session Attribute Removed");
		System.out.println(se.getName());
		System.out.println(se.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("Session Attribute Replaced");
		System.out.println(se.getName());
		System.out.println(se.getValue());
	}
	
	

}
