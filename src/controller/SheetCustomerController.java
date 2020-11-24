package controller;

import model.Customer;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/sheet")
public class SheetCustomerController extends BaseController {
	public static final String pageName = "/customer/sheet.jsp";

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
}
