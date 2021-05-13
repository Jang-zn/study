package com.common.filter;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;

/**
 * Servlet Filter implementation class AdminCheckFilter
 */
@WebFilter("/admin/*")
public class AdminCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		if(userId!=null&&userId.equals("admin")) {
			chain.doFilter(request, response);
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			//jsp나 별도 에러페이지 있으면 디스패쳐로 넘겨줘도 됨
			out.write("<html>"
					+ "<body>"
					+"<h1 style='color:red'>잘못된 경로로 접근함</h1>"
					+ "</body>"
					+ "</html>");
		}

		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
