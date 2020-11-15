package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends javax.servlet.http.HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello World</title></head>");
		out.println("<body>");
		out.println("<h1>Hello World !</h1>");
		out.println("</body></html>");
	}
}
