package com.ab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		// read form1/req1 data
		String pname = request.getParameter("pname");
		String pfname = request.getParameter("pfname");
		String paddress = request.getParameter("paddress");
		String ms = request.getParameter("ms");

		if (ms == null)
			ms = "single";

		// Create or locate httpSession object
		HttpSession session = request.getSession(true);

		// Keep form1/request1 data in http session object as session attributes

		session.setAttribute("pname", pname);
		session.setAttribute("pfname", pfname);
		session.setAttribute("paddress", paddress);

		// generate form2 dynamically based on the merrital status
		if (ms.equalsIgnoreCase("married")) {
			pw.println("<h1 style='color: red; text-align: center'> Submit Marrital Details: </h1><br>");
			//pw.println("<form action='secondurl' method='post'>");
			pw.println("<form action='"+response.encodeUrl("secondurl'")+"' method='post'>");
			pw.println("<table bgcolor='pink' align='center'>");
			pw.println("<tr><td>Spouse Name::</td><td><input type='text' name='f2t1'/></td></tr>");
			pw.println("<tr><td>No of Kids::</td><td><input type='text' name='f2t2'/></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='Submit'/></td></tr>");
			pw.println("<table/>");
			pw.println("<form/>");
		} else {
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
 Advantages:
 	(1) same as HttpSession with cokies but this technique can work even though cookies are restricted or block.
 	(2) the extra burden to programmer is we need to rewrite every url that is going to browser and and comming back to web app.
 	
 Conclusion on Session Tracking:
 	
 */
