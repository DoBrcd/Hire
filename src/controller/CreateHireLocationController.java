package controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import model.Customer;
import model.Hire;
import model.StatePayement;
import model.Vehicle;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;
import service.HireService;
import service.VehicleServiceImp;

@WebServlet("/create")
public class CreateHireLocationController extends BaseController {
	private String pageName;
	private String pageTitle;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
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
				System.out.println(reduction);
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(isAuthenticated(req, resp)) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date dateBegin = null;
			Date dateEnd = null;
			try {
				dateBegin = df.parse(req.getParameter("dateBegin"));
				dateEnd = df.parse(req.getParameter("dateEnd"));			
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println("baise ta mere java "  + req.getParameter("reduction"));
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
			
			float prix = vehicle.getHirePrice();
			int selectKm = km;
			km -= 50;
			if(km > 0 && km <= 50) {
				prix += km * 0.5;
			}else if(km > 51 && km <= 150) {
				prix += 50 * 0.5;
				km -= 50;
				prix += km * 0.3;
			}else if(km > 151 && km <= 250) {
				prix += 50 * 0.5;
				km -= 50;
				prix += 100 * 0.3;
				km -= 100;
				prix += km * 0.2;
			}else {
				prix += 50 * 0.5;
				km -= 50;
				prix += 100 * 0.3;
				km -= 100;
				prix += 100 * 0.2;
				km -= 100;
				prix += km * 0.10;
			}
			
			if(result) {
				prix = (float) (prix * 0.9);
			}
			
			Hire hire = new Hire();
			hire.setClient(customer);
			hire.setVehicle(vehicle);
			hire.setDateBegining(dateBegin);
			hire.setDateEnding(dateEnd);
			hire.setKmExpected(selectKm);
			hire.setPriceExpected(prix);
			hire.setReduction(result);
			hire.setPayement(StatePayement.NotPaid);
			
			HireService hireService = new HireService();
			hireService.create(hire);
			resp.sendRedirect(req.getContextPath() + "/research");
		}

		
	}
}
