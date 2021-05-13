package com.common.listener.controller;

import javax.servlet.*;



public class ContextListener implements ServletContextListener, ServletContextAttributeListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("server off");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("server on");
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("context attribute added");
		System.out.println(scae.getName());
		System.out.println(scae.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("context attribute removed");
		System.out.println(scae.getName());
		System.out.println(scae.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("context attribute replaced");
		System.out.println(scae.getName());
		System.out.println(scae.getValue());
	}
	
	
	
}
