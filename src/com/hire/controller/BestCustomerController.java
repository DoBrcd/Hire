package com.hire.controller;

import com.hire.service.CustomerServiceInterface;
import com.hire.service.impl.CustomerServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stats")
public class BestCustomerController extends BaseController {

	private static final String pageName = "/views/stats/stats.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			CustomerServiceInterface service = new CustomerServiceImp();

			req.setAttribute("bestHiring", service.getBestHiringCustomer());
			req.setAttribute("bestBuyer", service.getBestBuyerCustomer());

			redirectToView(req, resp, pageName);
		}
	}
}
