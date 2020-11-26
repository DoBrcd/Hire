package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Airplane;
import model.Car;
import model.Motorbike;
import model.Vehicle;
import service.VehicleServiceImp;
import service.VehicleServiceInterface;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/vehicle/delete")
public class DeleteVehicleController extends BaseController {
	private static final long serialVersionUID = 1L;
	public static final String pageName = "/vehicle/delete.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (isAuthenticated(req, resp)) {
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (isAuthenticated(req, resp)) {
			VehicleServiceInterface vService = new VehicleServiceImp();
			int id=Integer.parseInt(req.getParameter("id"));
			
			boolean flag = vService.delete(id);

		
			resp.sendRedirect(req.getContextPath() + "/vehicle/research");
		}
	}
}
