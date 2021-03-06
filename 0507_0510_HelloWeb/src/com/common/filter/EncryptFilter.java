package com.common.filter;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet Filter implementation class EncryptFilter
 */
@WebFilter(urlPatterns={"/login","/signup","/updatePassword", "/updatePasswordEnd"})
//Servlet에서 name = "" 적용해주고, 여기서 servletNames={""} 주면 name값으로도 적용 가능
public class EncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncryptFilter() {
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
			EncryptWrapper enc = new EncryptWrapper((HttpServletRequest)request);
			
		// pass the request along the filter chain
		//chain.doFilter(request, response);
			chain.doFilter(enc, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
