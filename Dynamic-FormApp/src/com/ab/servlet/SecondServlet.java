package com.ab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		// read form1 data
		String pname = request.getParameter("pname");
		String pfname = request.getParameter("pfname");
		String paddress = request.getParameter("paddress");
		String ms = request.getParameter("ms");
		
		// read form2/request2 data
		String f2Val1 = request.getParameter("f2t1");
		String f2Val2 = request.getParameter("f2t2");
		
		// generate dynamic web page from both form1 and form2 data
		pw.println("<h1 style='color: red; text-align: center'> Form1/ Request1 Data </h1>");
		pw.println("<p style='color: green; text-align: center'>" + pname +" " + pfname + " " + paddress + " " + ms + "</p> <br>");
		
		pw.println("<h1 style='color: red; text-align: center'> Form2/ Request1 Data </h1>");
		pw.println("<p style='color: blue; text-align: center'>" + f2Val1 +" " + f2Val2);
		
		pw.print("<br><br><a href='form.html'> Home </a> ");
		
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
