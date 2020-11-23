package controller;

import model.Customer;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client/create")
public class CreateCustomerController extends BaseController {
	public static final String pageName = "/client/create.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			redirectToView(req, resp, pageName);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			Customer newClient = new Customer();
			String name = req.getParameter("name");
			String firstName = req.getParameter("firstName");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			String address = req.getParameter("address");

			newClient.setName(name);
			newClient.setFirstName(firstName);
			newClient.setPhone(phone);
			newClient.setEmail(email);
			newClient.setAddress(address);

			CustomerServiceInterface clientService = new CustomerServiceImp();
			int result = clientService.createNewCustomer(newClient);

			switch (result) {
				case -1:
					System.out.println("Already exist");
					break;
				default:
					resp.sendRedirect(req.getContextPath() + "/client/sheet?id=" + newClient.getId());
					return;
			}

			redirectToView(req, resp, pageName);
		}
	}
}
