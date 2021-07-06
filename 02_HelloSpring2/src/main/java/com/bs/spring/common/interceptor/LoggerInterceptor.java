package com.bs.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
//버전업되면서 인터페이스인데도 메소드 강제되진 않음
@Slf4j
public class LoggerInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.debug("interceptor : prehandler");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
		//return false면 가로채고 걍 가만있음 true라서 요청 반환되는거임
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//리턴값 없고 modelAndView에 request data / view data 담겨있어서 check 가능
		log.debug("interceptor : postHandler");
		log.debug("전환될 화면 : {}", modelAndView.getViewName());
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		log.debug("interceptor : afterCompletion");
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
