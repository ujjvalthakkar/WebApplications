/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.ujjval.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ujjva
 */
public class inputFilter implements Filter {

	private static final boolean debug = true;
 
	private FilterConfig filterConfig = null;

	public inputFilter() {
	}

	private void doBeforeProcessing(ServletRequest request, ServletResponse response)
			throws IOException, ServletException {
		if (debug) {
			log("inputFilter:DoBeforeProcessing");
		}
	}

	private void doAfterProcessing(ServletRequest request, ServletResponse response)
			throws IOException, ServletException {
		if (debug) {
			log("inputFilter:DoAfterProcessing");
		}
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		RequestWrapper newRequest = new RequestWrapper(servletRequest);
		chain.doFilter(newRequest, response);
	}

	public void destroy() {
	}

	/**
	 * Init method for this filter
	 */
	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
		if (filterConfig != null) {
			if (debug) {
				log("inputFilter:Initializing filter");
			}
		}
	}

	public void log(String msg) {
		filterConfig.getServletContext().log(msg);
	}

}
