package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.Vehicle;
import service.CustomerServiceImp;
import service.CustomerServiceInterface;
import service.VehicleServiceImp;

@WebServlet("/create")
public class CreateHireLocation extends BaseController {
	private String pageName = "/hire/create.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		
		VehicleServiceImp vehicleService = new VehicleServiceImp();
		List<Vehicle> vehicles = vehicleService.getAll();
		req.setAttribute("vehicles", vehicles);
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
