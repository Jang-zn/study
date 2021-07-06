package com.bs.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bs.spring.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoInterceptor implements HandlerInterceptor{

@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
	HttpSession session = request.getSession();
	if((Member)session.getAttribute("login")==null) {
		request.setAttribute("msg", "로그인이 필요한 서비스입니다");
		request.setAttribute("loc", "/");
		modelAndView.setViewName("common/msg");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}else {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
	
	

	
}
