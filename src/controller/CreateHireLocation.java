package controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import model.Customer;
import model.Vehicle;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;
import service.VehicleServiceImp;

@WebServlet("/create")
public class CreateHireLocation extends BaseController {
	private String pageName;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			String dateBegin = req.getParameter("dateDebut");
			String dateEnd = req.getParameter("dateFin");
			if( dateBegin == null || dateEnd == null) {
				pageName="/hire/selectDate.jsp";
			}else {
				pageName = "/hire/create.jsp";
				CustomerServiceImp customerService = new CustomerServiceImp();
				List<Customer> customers = customerService.getAllCustomers();
				VehicleServiceImp vehicleService = new VehicleServiceImp();
				List<Vehicle> vehicles = vehicleService.getFreevehicle(dateBegin, dateEnd);
				req.setAttribute("customers", customers);
				req.setAttribute("vehicles", vehicles);				
			}
			redirectToView(req, resp, pageName);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
	}
}
