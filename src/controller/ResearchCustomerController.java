package controller;

import model.Customer;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/client/search")
public class ResearchCustomerController extends BaseController {

	public static final String pageName = "/client/research.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (isAuthenticated(req, resp)) {
			CustomerServiceInterface customerService = new CustomerServiceImp();
			List<Customer> customers = customerService.getAllCustomers();
			req.setAttribute("customers", customers);

			redirectToView(req, resp, pageName, "Research Customer");
		}
	}
}
