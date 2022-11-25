package com.ab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		// Create in memory cookie
		Cookie ck1 = new Cookie("TS","hyd");
		response.addCookie(ck1);
		
		// create persistance cookie
		Cookie ck2 = new Cookie("TN","Chennai");
		ck2.setMaxAge(120);
		response.addCookie(ck2);
		
		pw.println("<h1> Cookies are created and added to resposne obb successfully </h1>");
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
