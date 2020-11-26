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

@WebServlet("/vehicle/delete")
public class DeleteVehicleController extends BaseController {
	private static final long serialVersionUID = 1L;
	public static final String pageName = "/views/vehicle/delete.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (isAuthenticated(req, resp)) {
			if(!employeeService.canManageVehicle(getEmployee(req)))
				redirectToHome(req, resp);
			else
			{
				int id = Integer.parseInt(req.getParameter("id"));

				VehicleServiceInterface vService = new VehicleServiceImp();
				Vehicle v = vService.getById(id);

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

				redirectToView(req, resp, pageName, "Delete Vehicle");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (isAuthenticated(req, resp)) {
			if(!employeeService.canManageVehicle(getEmployee(req)))
				redirectToHome(req, resp);
			else
			{
				VehicleServiceInterface vService = new VehicleServiceImp();
				int id=Integer.parseInt(req.getParameter("id"));

				boolean flag = vService.delete(id);

				resp.sendRedirect(req.getContextPath() + "/vehicle/research");
			}
		}
	}
}
