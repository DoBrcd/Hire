package com.hire.controller;


import com.hire.service.CustomerServiceInterface;
import com.hire.service.impl.CustomerServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client/remove")
public class RemoveCustomerController extends BaseController {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			int customerId = Integer.parseInt(req.getParameter("id"));
			CustomerServiceInterface customerService = new CustomerServiceImp();
			customerService.remove(customerId);
			resp.sendRedirect(req.getContextPath() + "/client/search");
		}
	}
}
