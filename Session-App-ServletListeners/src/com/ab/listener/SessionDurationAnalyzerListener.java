package com.ab.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionDurationAnalyzerListener implements HttpSessionListener {
	
	private Long startTime;
	private Long endTime;
	private ServletContext sc;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		startTime = System.currentTimeMillis();
		
		//get access to session
		sc = se.getSession().getServletContext();
		System.out.println("Session started at: " + new Date());
		sc.log("Session started at: " + new Date());
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		endTime = System.currentTimeMillis();
		sc = se.getSession().getServletContext();
		System.out.println("Session end at: " + new Date());
		System.out.println("Sesion duration: " +(endTime - startTime));
		sc.log("Session started at: " + new Date());
		sc.log("Sesion duration: " +(endTime - startTime));
	}

}
