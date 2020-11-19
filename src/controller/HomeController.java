package controller;


import service.DBManager;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession maSession=req.getSession();
		 String id=(String)maSession.getAttribute("id");
		 if(id==null) {
			 resp.sendRedirect(req.getContextPath());
			 return;
		}
		//EntityManager em = DBManager.getEntityManager();
		
        req.getRequestDispatcher("home.jsp").include(req, resp);
	}
}
