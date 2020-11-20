package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Customer;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;
import service.EmployeeServiceImp;
import service.EmployeeServiceInterface;

@WebServlet("/client/modify")
public class ModifyCustomerController extends BaseController {
	final String pageName = "/client/modify.jsp"; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		CustomerServiceInterface customerService = new CustomerServiceImp();
		Customer customer = customerService.getById(Integer.parseInt(req.getParameter("id")));

		req.setAttribute("customer",customer);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(req.getParameter("id")));
		customer.setName(req.getParameter("name"));
		customer.setFirstName(req.getParameter("firstName"));
		customer.setAddress(req.getParameter("address"));
		customer.setEmail(req.getParameter("email"));
		customer.setPhone(req.getParameter("phone"));
		resp.sendRedirect(req.getContextPath() + "/client/sheet?id=" + customer.getId());
		
		CustomerServiceInterface customerService = new CustomerServiceImp();
		customerService.update(customer);

	}
}
