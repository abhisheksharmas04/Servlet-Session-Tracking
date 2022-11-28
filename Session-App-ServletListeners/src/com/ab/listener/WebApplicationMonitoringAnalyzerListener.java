package com.ab.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class WebApplicationMonitoringAnalyzerListener implements ServletContextListener {
	
	private Long startTime;
	private Long endTime;
	private ServletContext sc;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		startTime = System.currentTimeMillis();
		
		// get access to the servlet context
		sc = sce.getServletContext();
		
		// Write log messages:
		System.out.println("web application is deployed or restarted at: " + new Date());
		sc.log("web application is deployed or restarted at: " + new Date());
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		endTime = System.currentTimeMillis();
		
		System.out.println("web application is stoped/undeployed: " + new Date());
		System.out.println("web application running duraing:: " +(startTime-endTime));
		
		sc.log("web application is stoped/undeployed: " + new Date());
		sc.log("web application running duraing:: " +(startTime-endTime));
	}

}
