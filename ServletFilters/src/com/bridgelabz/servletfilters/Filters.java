package com.bridgelabz.servletfilters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
//@WebFilter("/url")
public class Filters implements Filter{
	FilterConfig filterConfig;
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig=filterConfig;
	}  
    
	public void doFilter(ServletRequest request, ServletResponse response,  
	        FilterChain chain) throws IOException, ServletException {  
	          
	    PrintWriter out=response.getWriter();  
	          
	    String password=request.getParameter("password");  
	    String username=request.getParameter("username");
	    if(password.equals(filterConfig.getInitParameter("password"))&&username.equals(filterConfig.getInitParameter("username"))){  
	    chain.doFilter(request, response);//sends request to next resource  
	    }  
	    else{  
	    out.print("<html><body bgcolor=\"pink\"><h2 align=\"center\">Username or Password Mismatch</h2></body></html>"); 
	    }  
	}  
	public void destroy() {}  

}
