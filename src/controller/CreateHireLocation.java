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
import model.Vehicle;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;
import service.HireService;
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
			redirectToView(req, resp, pageName);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
		float prix = Float.parseFloat(req.getParameter("prix"));
		int idVehicle = Integer.parseInt(req.getParameter("vehicle"));
		int idCustomer = Integer.parseInt(req.getParameter("customer"));
		
		CustomerServiceImp customerService = new CustomerServiceImp();
		Customer customer = customerService.getById(idCustomer);
		VehicleServiceImp vehicleService = new VehicleServiceImp();
		Vehicle vehicle = vehicleService.getById(idVehicle);
		Hire hire = new Hire();
		hire.setClient(customer);
		hire.setVehicle(vehicle);
		hire.setDateBegining(dateBegin);
		hire.setDateEnding(dateEnd);
		hire.setKmExpected(km);
		hire.setPriceExpected(prix);
		hire.setReduction(result);
		
		HireService hireService = new HireService();
		hireService.create(hire);
		resp.sendRedirect(req.getContextPath() + "/research");
		
	}
}
