package com.icss.oa.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/*")
public class DomainFilter implements Filter {
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
//		…Ë÷√‘ –ÌøÁ”Ú«Î«Û
		HttpServletResponse rep = (HttpServletResponse) response;		
		rep.setHeader("Access-Control-Allow-Origin", "*");
			
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
