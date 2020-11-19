package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;
import service.DBManager;

@WebServlet("/client/create")
public class CreateCustomerController extends HttpServlet {
	final String pageName = "/client/create.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		int result = clientService.createNew(newClient);

		switch (result) {
			case -1:
				System.out.println("Already exist");
				break;
			default:
				resp.sendRedirect(req.getContextPath() + "/client/sheet?id=" + newClient.getId());
				return;
		}
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
