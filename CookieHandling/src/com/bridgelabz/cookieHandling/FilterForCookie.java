package com.bridgelabz.cookieHandling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterForCookie implements Filter {
	FilterConfig filterConfig;
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig=config;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,  
	        FilterChain chain) throws IOException, ServletException {  
	          
	    PrintWriter out=response.getWriter();  
	          
	    String password=request.getParameter("password");  
	    String username=request.getParameter("username");
	    if(password.equals(filterConfig.getInitParameter("password"))&&username.equals
	    		(filterConfig.getInitParameter("username"))){  
	    chain.doFilter(request, response);//sends request to next resource  
	    }  
	    else{  
	    out.print("<html><body bgcolor=\"pink\"><h2 align=\"center\">Sorry Username or Password Mismatch</h2></body></html>"); 
	    }  
	}  
	
	@Override
	public void destroy() {
		
	}
}
