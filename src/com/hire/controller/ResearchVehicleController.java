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

	private final String pageName = "/views/vehicle/research.jsp";

	/**
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
	 *
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
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (isAuthenticated(req, resp)) {
			VehicleServiceInterface vService = new VehicleServiceImp();
			List<String> models = vService.getAllModels();
			List<String> brands = vService.getAllBrand();

			String vehicleType = req.getParameter("vehicleType");
			String brand = req.getParameter("brand");
			String model = req.getParameter("model");
		

			if ((vehicleType.equals("not-selected"))
					&& (brand.equals("not-selected") && model.equals("not-selected"))) {
				
				List<Vehicle> vehiclesParType = vService.getAllParType(vehicleType);
				List<Vehicle> vehicles = vService.getAllByCriteria(model, brand);

				req.setAttribute("vehicles", vehicles);
				req.setAttribute("msg", "msg");
			} else {
				if ((!vehicleType.equals("not-selected"))
						&& (brand.equals("not-selected") && model.equals("not-selected"))) {

					List<Vehicle> vehiclesParType = vService.getAllParType(vehicleType);
					req.setAttribute("vehicles", vehiclesParType);

					req.setAttribute("msg", "msg");
				} else {
					switch (vehicleType) {
					case "Car":
						List<Car> vehiclesCar = vService.getAllCarByCriteria(model, brand);

						req.setAttribute("vehicles", vehiclesCar);
						req.setAttribute("msg", "msg");

						break;
					case "Motorbike":
						List<Motorbike> vehiclesMotorbike = vService.getAllMotorbikeByCriteria(model, brand);

						req.setAttribute("vehicles", vehiclesMotorbike);
						req.setAttribute("msg", "msg");

						break;
					case "Airplane":
						List<Airplane> vehiclesAirplane = vService.getAllAirplaneByCriteria(model, brand);

						req.setAttribute("vehicles", vehiclesAirplane);
						req.setAttribute("msg", "msg");

						break;
					default:
						List<Vehicle> vehicles = vService.getAllByCriteria(model, brand);
						req.setAttribute("models", models);

						req.setAttribute("vehicles", vehicles);
						req.setAttribute("msg", "msg");

					}

				}
			}
			req.setAttribute("models", models);
			req.setAttribute("brands", brands);
			redirectToView(req, resp, pageName, "Research Vehicle");
		}

	}
}
