package com.ab.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestProcessinAnalyzerListener implements ServletRequestListener {
	
	private Long startTime;
	private Long endTime;
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		startTime = System.currentTimeMillis();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		endTime = System.currentTimeMillis();
		
		// http Servelt Request object
		HttpServletRequest req = (HttpServletRequest)sre.getServletRequest();
		
		System.out.println(req.getRequestURI() + " has taken " + (endTime - startTime) + " ms to process the request");
		
		// get servlet contex object
		ServletContext ctx = req.getServletContext();
		ctx.log(req.getRequestURI() + " has taken " + (endTime - startTime) + " ms to process the request");
	}

}
