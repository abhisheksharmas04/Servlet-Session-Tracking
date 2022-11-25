package com.ab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		
		// generate form2 dynamically based on the merrital status
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<h1 style='color: red; text-align: center'> Submit Marrital Details: </h1><br>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("<table bgcolor='pink' align='center'>");
			pw.println("<tr><td>Spouse Name::</td><td><input type='text' name='f2t1'/></td></tr>");
			pw.println("<tr><td>No of Kids::</td><td><input type='text' name='f2t2'/></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='Submit'/></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hname' value='"+pname+"'/></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hfname' value='"+pfname+"'/></td></tr>");
			pw.println("<tr><td><input type='hidden' name='haddress' value='"+paddress+"'/></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hms' value='"+ms+"'/></td></tr>");
			pw.println("<table/>");
			pw.println("<form/>");
		}else {
			pw.println("<h1 style='color: red; text-align: center'> Submit Bachelor Details: </h1><br>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("<table bgcolor='pink' align='center'>");
			pw.println("<tr><td>When do you want to marry::</td><td><input type='text' name='f2t1'/></td></tr>");
			pw.println("<tr><td>Why do you want to marry::</td><td><input type='text' name='f2t2'/></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='Submit'/></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hname' value='"+pname+"'/></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hfname' value='"+pfname+"'/></td></tr>");
			pw.println("<tr><td><input type='hidden' name='haddress' value='"+paddress+"'/></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hms' value='"+ms+"'/></td></tr>");
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
 PROS::
 	(1). Basic HTML knowladge is sufficient to work with this technique.
 	(2). This technique works with all webserver and applicaitons
 	(3). Does not allocate memory on server machine file system
 
 CONS::
 	(1). Allows only String values as the hidden box value
 	(2). Hidden box values can be seen through browser view source options
 	(3). Imporve the network traffic because the hidden box values travel over the network across the multiple request
 	(4). It is not Industry Standrad
 	(6). If more forms are there in chaining than we need to add more hidden boxes in each form
 */
