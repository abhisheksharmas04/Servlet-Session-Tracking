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
		
		// read form1 data
		String pname = request.getParameter("pname");
		String pfname = request.getParameter("pfname");
		String paddress = request.getParameter("paddress");
		String ms = request.getParameter("ms");
		
		if(ms == null)
			ms = "single";
		
		// create In-Memory Cookies having form1/request-1 data and add them to response
		Cookie ck1 = new Cookie("cname",pname);
		Cookie ck2 = new Cookie("cfname",pfname);
		Cookie ck3 = new Cookie("caddress",paddress);
		Cookie ck4 = new Cookie("cms",ms);
		
		// add these cookies to response object
		response.addCookie(ck1);response.addCookie(ck2);
		response.addCookie(ck3);response.addCookie(ck4);
		
		// generate form2 dynamically based on the merrital status
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<h1 style='color: red; text-align: center'> Submit Marrital Details: </h1><br>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("<table bgcolor='pink' align='center'>");
			pw.println("<tr><td>Spouse Name::</td><td><input type='text' name='f2t1'/></td></tr>");
			pw.println("<tr><td>No of Kids::</td><td><input type='text' name='f2t2'/></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='Submit'/></td></tr>");
			pw.println("<table/>");
			pw.println("<form/>");
		}else {
			pw.println("<h1 style='color: red; text-align: center'> Submit Bachelor Details: </h1><br>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("<table bgcolor='pink' align='center'>");
			pw.println("<tr><td>When do you want to marry::</td><td><input type='text' name='f2t1'/></td></tr>");
			pw.println("<tr><td>Why do you want to marry::</td><td><input type='text' name='f2t2'/></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='Submit'/></td></tr>");
			pw.println("<table/>");
			pw.println("<form/>");
		}
		
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
/*
Advantages of Cookies based session tracking:
	(1) Http cookies allocate memory at clinet side and they don't give burden to server.
	(2) Persistance cookies can be taken having expiry time
	(3) Http cookies can work with all java based web server and application server
	(4) Http cookies can work with all server side web technologies.
	(5) Http cookies data cannot be view using view source option.
	
Diadvantages of Cookies:
	(1) Http cookies hold only text/String values ie they cannot hold java objects as values.
	(2) Http cookies data can view using browser settings i.e no data secracy.
	(3) using browser settings we can delete the cookies in the middle of the session. This will kill the session tracking.
	(4) Cookies can be restricted using browser settings, this also fails session tracking
	(5) the borwser is expected to support 20 cookies for each web server 300 cookies total,and may limit cookie size to 4kb each.
	(6) We must use http based http servlet in order to work with cookies. In generaci servlet may not work.
 */
