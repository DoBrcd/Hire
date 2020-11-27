package com.hire.controller;

import com.hire.model.*;
import com.hire.service.VehicleServiceInterface;
import com.hire.service.impl.VehicleServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vehicle/create")
public class CreateVehicleController extends BaseController {

	private static final String pageName = "/views/vehicle/create.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (isAuthenticated(req, resp)) {
			if(!employeeService.canManageVehicle(getEmployee(req)))
				redirectToHome(req, resp);
			else
				redirectToView(req, resp, pageName, "Create Vehicle");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (isAuthenticated(req, resp)) {
			if(!employeeService.canManageVehicle(getEmployee(req)))
				redirectToHome(req, resp);
			else
			{
				String vehicleType = req.getParameter("vehicleType");
				String model = req.getParameter("com/hire/model");
				String brand = req.getParameter("brand");
				StateVehicle state = StateVehicle.valueOf(req.getParameter("state"));

				float price = Float.parseFloat(req.getParameter("price"));
				int maxSpeed = Integer.parseInt(req.getParameter("maxSpeed"));
				Vehicle v = null;

				VehicleServiceInterface vehicleservice = new VehicleServiceImp();
				Vehicle newvehicle = null;
				switch (vehicleType) {
					case "Car":
						// code block
						Car c = new Car();
						int powercar = Integer.parseInt(req.getParameter("powercar"));
						int kmCar = Integer.parseInt(req.getParameter("kmCar"));
						int sitsnumber = Integer.parseInt(req.getParameter("sitsnumber"));
						c.setPower(powercar);
						c.setKm(kmCar);
						c.setSitsNumber(sitsnumber);
						c.setBrand(brand);
						c.setHirePrice(price);
						c.setIsHiring(StateHiring.Free);

						c.setMaxSpeed(maxSpeed);
						c.setModel(model);

						newvehicle = vehicleservice.add(c);

						break;
					case "Motorbike":
						// code block
						Motorbike m = new Motorbike();
						int powerMotor = Integer.parseInt(req.getParameter("powerMotor"));
						int kmMotor = Integer.parseInt(req.getParameter("kmMotor"));
						m.setPower(powerMotor);
						m.setKm(kmMotor);
						m.setIsHiring(StateHiring.Free);

						m.setBrand(brand);
						m.setHirePrice(price);
						m.setMaxSpeed(maxSpeed);
						m.setModel(model);
						newvehicle = vehicleservice.add(m);

						break;
					case "Airplane":
						// code block
						Airplane a = new Airplane();
						int nbMotors = Integer.parseInt(req.getParameter("nbMotors"));
						a.setNbMotor(nbMotors);
						a.setIsHiring(StateHiring.Free);

						a.setBrand(brand);
						a.setHirePrice(price);
						a.setMaxSpeed(maxSpeed);
						a.setModel(model);

						newvehicle = vehicleservice.add(a);

						break;

				}

				if (newvehicle != null) {
					req.setAttribute("msg", "mission accomplished");
					req.setAttribute("flag", "true");

				} else {
					req.setAttribute("msg", "mission faild");
					req.setAttribute("flag", "false");

				}
				redirectToView(req, resp, pageName, "Create Vehicle");
			}
		}
	}
}
