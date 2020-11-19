package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.CustomerManager;

@WebServlet("/client/search")
public class SearchCustomerController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageName="/client/research.jsp";
		CustomerManager manager = new CustomerManager();
		ArrayList<Customer> customers = manager.getAllClients();
		System.out.println(customers);
		req.setAttribute("customers", customers);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
	  try {
	    rd.forward(req, resp);
	  } catch (ServletException e) {
	    e.printStackTrace();
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
	}
}
