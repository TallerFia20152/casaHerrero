package edu.usmp.fia.taller.common.action;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


//@WebFilter("/*")
//@WebFilter("*.jsp")
public class SessionFilter implements Filter {


	protected static final Logger log = LogManager.getLogger(SessionFilter.class);
	
    public SessionFilter() {
    	log.info("SessionFilter()");
    }

	public void destroy() {
		log.info("destroy()");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		log.info("INIT doFilter(request, response, chain)");
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.sendRedirect(request.getServletContext().getContextPath() + "/index");
		*/
		//chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		log.info("init(fConfig)");
	}
	
	
	


}
