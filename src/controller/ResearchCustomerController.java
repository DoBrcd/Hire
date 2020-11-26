package controller;

import model.Airplane;
import model.Car;
import model.Customer;
import model.Motorbike;
import model.Vehicle;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;
import service.VehicleServiceImp;
import service.VehicleServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer/research")
public class ResearchCustomerController extends BaseController {

	public static final String pageName = "/views/customer/research.jsp";

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerServiceInterface customerService = new CustomerServiceImp();

		if (isAuthenticated(req, resp)) {
			
			List<Customer> customers = customerService.getAllCustomers();
			req.setAttribute("id", customers);
			req.setAttribute("noms", customers);
			req.setAttribute("customers", customers);

			redirectToView(req, resp, pageName, "Recherche Clients");
		}
	}	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (isAuthenticated(req, resp)) {
			CustomerServiceInterface customerService = new CustomerServiceImp();

			String reqResearch = req.getParameter("reqResearch");
			System.out.println(reqResearch);
			List<Customer> customers = customerService.getAllCustomersByCriteria(reqResearch);
			req.setAttribute("id", customers);
			req.setAttribute("noms", customers);
			req.setAttribute("customers", customers);
			redirectToView(req, resp, pageName, "Recherche Clients");
			
		}

	}
	
}

