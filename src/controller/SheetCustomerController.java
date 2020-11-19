package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;

@WebServlet("/client/sheet")
public class SheetCustomerController extends BaseController {
	final String pageName = "/client/sheet.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		CustomerServiceInterface customerService = new CustomerServiceImp();
		Customer client = customerService.get(Integer.parseInt(req.getParameter("id")));

		req.setAttribute("name", client.getName());
		req.setAttribute("firstName", client.getFirstName());
		req.setAttribute("phone", client.getPhone());
		req.setAttribute("email", client.getEmail());
		req.setAttribute("address", client.getAddress());
		
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
