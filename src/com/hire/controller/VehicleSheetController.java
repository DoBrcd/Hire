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

@WebServlet("/vehicle/sheet")
public class VehicleSheetController extends BaseController {
	public static final String pageName = "/views/vehicle/sheet.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			VehicleServiceInterface vService = new VehicleServiceImp();
			Vehicle v = vService.getById(Integer.parseInt(req.getParameter("id")));

			
			if (v instanceof Car) {
				Car c = (Car) v;
				req.setAttribute("typeVehicle", "Car");
				req.setAttribute("vehicle", c);

			}

			if (v instanceof Motorbike) {
				Motorbike m = (Motorbike) v;
				req.setAttribute("typeVehicle", "Motorbike");
				req.setAttribute("vehicle", m);

			}

			if (v instanceof Airplane) {
				Airplane a = (Airplane) v;
				req.setAttribute("typeVehicle", "Airplane");
				req.setAttribute("vehicle", a);

			}
			redirectToView(req, resp, pageName, "Vehicle Sheet #" + v.getId());
		}
	}
}
