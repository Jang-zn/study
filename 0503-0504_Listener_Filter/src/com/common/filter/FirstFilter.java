package com.common.filter;

import java.io.*;

import javax.servlet.*;

//필터 등록방법
//1. web.xml(배포서술자, DD) 등록
//2. Annotation


//필터 인터페이스 구현
public class FirstFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		System.out.println("filter 실행");
		//다음 필터 / 서블릿 실행
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		filter.doFilter(request, response);
		
	}
	
	
	
}
