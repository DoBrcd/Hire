package com.hire.controller;


import com.hire.model.Customer;
import com.hire.model.Hire;
import com.hire.model.StatePayement;
import com.hire.model.Vehicle;
import com.hire.service.HireServiceInterface;
import com.hire.service.impl.CustomerServiceImp;
import com.hire.service.impl.HireService;
import com.hire.service.impl.VehicleServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@WebServlet("/create")
public class CreateHireLocationController extends BaseController {
	private String pageName;
	private String pageTitle;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			if(!employeeService.canManageHiring(getEmployee(req)))
				redirectToHome(req, resp);
			else
			{
				String dateBegin = req.getParameter("dateDebut");
				String dateEnd = req.getParameter("dateFin");
				if( dateBegin == null || dateEnd == null) {
					pageName="/views/hire/selectDate.jsp";
					pageTitle="Selectionner une date";
				}else {
					pageName = "/views/hire/create.jsp";
					pageTitle = "Créer une location";
					boolean reduction = false;
					LocalDate  dateBeginFormat = LocalDate.parse(dateBegin);
					LocalDate  dateEndFormat = LocalDate.parse(dateEnd);
					reduction = ChronoUnit.DAYS.between(dateBeginFormat, dateEndFormat) >= 7;
					CustomerServiceImp customerService = new CustomerServiceImp();
					List<Customer> customers = customerService.getAllCustomers();
					VehicleServiceImp vehicleService = new VehicleServiceImp();
					List<Vehicle> vehicles = vehicleService.getFreevehicle(dateBegin, dateEnd);
					req.setAttribute("customers", customers);
					req.setAttribute("vehicles", vehicles);
					req.setAttribute("reduction", reduction);
					req.setAttribute("dateBegin", dateBegin);
					req.setAttribute("dateEnd", dateEnd);
				}
				redirectToView(req, resp, pageName, pageTitle);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(isAuthenticated(req, resp)) {
			if(!employeeService.canManageHiring(getEmployee(req)))
				redirectToHome(req, resp);
			else
			{
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date dateBegin = null;
				Date dateEnd = null;
				try {
					dateBegin = df.parse(req.getParameter("dateBegin"));
					dateEnd = df.parse(req.getParameter("dateEnd"));
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				String reduction = req.getParameter("reduction");
				boolean result;
				if(reduction != null && reduction.equals("null")) {
					result = false;
				} else if(reduction != null && reduction.equals("yes")) {
					result = true;
				} else {
					result = false;
				}
				int km = Integer.parseInt(req.getParameter("km"));
				int idVehicle = Integer.parseInt(req.getParameter("vehicle"));
				int idCustomer = Integer.parseInt(req.getParameter("customer"));

				CustomerServiceImp customerService = new CustomerServiceImp();
				Customer customer = customerService.getById(idCustomer);
				VehicleServiceImp vehicleService = new VehicleServiceImp();
				Vehicle vehicle = vehicleService.getById(idVehicle);

				HireServiceInterface hireService = new HireService();

				float prix = hireService.getPayement(km, vehicle.getHirePrice(), result);

				Hire hire = new Hire();

				hire.setClient(customer);
				hire.setVehicle(vehicle);
				hire.setDateBegining(dateBegin);
				hire.setDateEnding(dateEnd);
				hire.setKmExpected(km);
				hire.setPriceExpected(prix);
				hire.setReduction(result);
				hire.setPayement(StatePayement.NotPaid);

				hireService.create(hire);
				resp.sendRedirect(req.getContextPath() + "/research");
			}
		}
	}
}
