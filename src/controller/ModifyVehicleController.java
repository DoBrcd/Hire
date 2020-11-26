package controller;

import model.*;
import service.VehicleServiceImp;
import service.VehicleServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vehicle/modify")
public class ModifyVehicleController extends BaseController {
	private final String pageName = "/views/vehicle/modify.jsp";
	private static final long serialVersionUID = 1L;

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

				redirectToView(req, resp, pageName, "Modify Vehicle");
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
				int id = Integer.parseInt(req.getParameter("id"));

				String vehicleType = req.getParameter("vehicleType");
				String model = req.getParameter("model");
				String brand = req.getParameter("brand");
				String state = req.getParameter("state");
				float price = Float.parseFloat(req.getParameter("price"));
				int maxSpeed = Integer.parseInt(req.getParameter("maxSpeed"));

				VehicleServiceInterface vehicleservice = new VehicleServiceImp();
				Vehicle v = vehicleservice.getById(id);

				v.setId(id);
				v.setBrand(brand);
				v.setHirePrice(price);
				v.setMaxSpeed(maxSpeed);
				v.setState(StateVehicle.valueOf(state));
				v.setModel(model);

				switch (vehicleType) {
					case "Car":
						Car c = (Car) v;
						int powercar = Integer.parseInt(req.getParameter("powercar"));
						int kmCar = Integer.parseInt(req.getParameter("kmCar"));
						int sitsnumber = Integer.parseInt(req.getParameter("sitsnumber"));
						c.setPower(powercar);
						c.setKm(kmCar);
						c.setSitsNumber(sitsnumber);
						v = vehicleservice.update(c);
						break;
					case "Motorbike":
						Motorbike m = (Motorbike) v;
						int powerMotor = Integer.parseInt(req.getParameter("powerMotor"));
						int kmMotor = Integer.parseInt(req.getParameter("kmMotor"));
						m.setPower(powerMotor);
						m.setKm(kmMotor);
						v = vehicleservice.update(m);
						break;
					case "Airplane":
						Airplane a = (Airplane) v;
						int nbMotors = Integer.parseInt(req.getParameter("nbMotors"));
						a.setNbMotor(nbMotors);
						v = vehicleservice.update(a);
						break;
				}

				resp.sendRedirect(req.getContextPath() + "/vehicle/sheet?id=" + id);
			}
		}
	}
}
