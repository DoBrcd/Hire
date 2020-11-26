package com.hire.controller;

import com.hire.model.Airplane;
import com.hire.model.Car;
import com.hire.model.Motorbike;
import com.hire.model.Vehicle;
import com.hire.service.VehicleServiceInterface;
import com.hire.service.impl.VehicleServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/vehicle/research")
public class ResearchVehicleController extends BaseController {

	private static final long serialVersionUID = 1L;

	private final String pageName = "/vehicle/research.jsp";


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 VehicleServiceInterface vService = new VehicleServiceImp();
		 List<String> models = vService.getAllModels();
		 List<String> brands = vService.getAllBrand();
		if (isAuthenticated(req, resp)) {

			List<Vehicle> vehicles = vService.getAll();
			req.setAttribute("models", models);
			req.setAttribute("brands", brands);
			req.setAttribute("vehicles", vehicles);
			redirectToView(req, resp, pageName, "Research Vehicle");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (isAuthenticated(req, resp)) {
			 VehicleServiceInterface vService = new VehicleServiceImp();
			 List<String> models = vService.getAllModels();
			 List<String> brands = vService.getAllBrand();
			
			String vehicleType = req.getParameter("vehicleType");
			String brand = req.getParameter("brand");
			String model = req.getParameter("com/hire/model");
			
			switch (vehicleType) {
			case "Car":
				List<Car> vehiclesCar = vService.getAllCarByCriteria(model,brand);
				req.setAttribute("models", models);
				req.setAttribute("brands", brands);
				req.setAttribute("vehicles", vehiclesCar);
				req.setAttribute("msg", "msg");
				
				break;
			case "Motorbike":
				List<Motorbike> vehiclesMotorbike = vService.getAllMotorbikeByCriteria(model,brand);
				req.setAttribute("models", models);
				req.setAttribute("brands", brands);
				req.setAttribute("vehicles", vehiclesMotorbike);
				req.setAttribute("msg", "msg");
			
				break;
			case "Aireplane":
				List<Airplane> vehiclesAireplane = vService.getAllAirplaneByCriteria(model,brand);
				req.setAttribute("models", models);
				req.setAttribute("brands", brands);
				req.setAttribute("vehicles", vehiclesAireplane);
				req.setAttribute("msg", "msg");
				redirectToView(req, resp, pageName);
				break;
			default:
		
				List<Vehicle> vehicles = vService.getAllByCriteria(model,brand);
				req.setAttribute("models", models);
				req.setAttribute("brands", brands);
				req.setAttribute("vehicles", vehicles);
				req.setAttribute("msg", "msg");
				
			}
			redirectToView(req, resp, pageName, "Research Vehicle");
			
		}

	}
}
