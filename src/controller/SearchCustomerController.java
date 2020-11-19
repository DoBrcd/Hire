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
import service.CustomerServiceImp;
import service.CustomerServiceInterface;

@WebServlet("/client/search")
public class SearchCustomerController extends BaseController {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageName="/client/research.jsp";
		CustomerServiceInterface customerService = new CustomerServiceImp();
		ArrayList<Customer> customers = customerService.getAllCustomers();
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
