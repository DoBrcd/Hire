package controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/customer/delete")
public class DeleteCustomerController extends BaseController {
	public static final String pageName = "/customer/delete.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			CustomerServiceInterface customerService = new CustomerServiceImp();
			Customer customer = customerService.getById(Integer.parseInt(req.getParameter("id")));

			req.setAttribute("customer",customer);

			redirectToView(req, resp, pageName);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			CustomerServiceInterface customerService = new CustomerServiceImp();
			customerService.remove(Integer.parseInt(req.getParameter("id")));
			resp.sendRedirect(req.getContextPath());
		}
	}
}
