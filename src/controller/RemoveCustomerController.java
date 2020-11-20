package controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;

@WebServlet("/client/remove")
public class RemoveCustomerController extends BaseController {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int customerId = Integer.parseInt(req.getParameter("id"));
		CustomerServiceInterface customerService = new CustomerServiceImp();
		customerService.remove(customerId);
		resp.sendRedirect(req.getContextPath() + "/client/search");

	}
}
