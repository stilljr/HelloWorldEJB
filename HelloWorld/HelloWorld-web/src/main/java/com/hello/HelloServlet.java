package com.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.HelloSessionBean;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	HelloSessionBean helloSessionBean;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entering HelloServlet doGet Method...");
	
		// Set the response message's MIME type
		response.setContentType("text/html;charset=UTF-8");
		// Allocate a output writer to write the response message into the network socket
		PrintWriter out = response.getWriter();
		Date date = new Date();
 
		// Write the response message, in an HTML page
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html><head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("<title>Hello, World</title></head>");
			out.println("<body>");
			out.println("<h1 align = \"center\">Hello World EJB !</h1>\n");  // says Hello
			out.println("<hr>");
			out.println("<h1 align = \"center\">Current Date & Time is:</h1>\n");
			out.println("<h2 align = \"center\">" + date + "</h2>\n");
			out.println("<hr>");	    
			// Echo client's request information
			out.println("<p align = \"center\">Request URI: " + request.getRequestURI() + "</p>\n");
			out.println("<p align = \"center\">Protocol: " + request.getProtocol() + "</p>\n");
			out.println("<p align = \"center\">PathInfo: " + request.getPathInfo() + "</p>\n");
			out.println("<p align = \"center\">Remote Address: " + request.getRemoteAddr() + "</p>\n");
			out.println("<br />");
			out.println("<h2 align = \"center\">" + helloSessionBean.helloSessionBeanMethod() + "</h2>\n");
			out.println("</body>");
			out.println("</html>");
		} finally {
         out.close();  // Always close the output writer
		}
		System.out.println("Exiting HelloServlet doGet Method...");
	}
}
