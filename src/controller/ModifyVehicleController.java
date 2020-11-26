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

@WebServlet("/vehicle/modify")
public class ModifyVehicleController extends BaseController {
	private final String pageName = "/vehicle/modify.jsp";
	private static final long serialVersionUID = 1L;

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

			redirectToView(req, resp, pageName);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (isAuthenticated(req, resp)) {
			int id = Integer.parseInt(req.getParameter("id"));

			String vehicleType = req.getParameter("vehicleType");
			String model = req.getParameter("model");
			String brand = req.getParameter("brand");
			String state = req.getParameter("state");
			float price = Float.parseFloat(req.getParameter("price"));
			int maxSpeed = Integer.parseInt(req.getParameter("maxSpeed"));

			VehicleServiceInterface vehicleservice = new VehicleServiceImp();
			
			switch (vehicleType) {
			case "Car":
				// code block
				Vehicle vehicleCar = new Car();
				vehicleCar.setId(id);
				vehicleCar.setBrand(brand);
				vehicleCar.setHirePrice(price);
				vehicleCar.setMaxSpeed(maxSpeed);
				vehicleCar.setModel(model);
				Car c = (Car) vehicleCar;
				int powercar = Integer.parseInt(req.getParameter("powercar"));
				int kmCar = Integer.parseInt(req.getParameter("kmCar"));
				int sitsnumber = Integer.parseInt(req.getParameter("sitsnumber"));
				c.setPower(powercar);
				c.setKm(kmCar);
				c.setSitsNumber(sitsnumber);
				vehicleCar = vehicleservice.update(c);
				break;
			case "Motorbike":
				// code block
				Vehicle vehicleMotorbike = new Motorbike();
				vehicleMotorbike.setId(id);
				vehicleMotorbike.setBrand(brand);
				vehicleMotorbike.setHirePrice(price);
				vehicleMotorbike.setMaxSpeed(maxSpeed);
				vehicleMotorbike.setModel(model);
				Motorbike m = (Motorbike) vehicleMotorbike;
				int powerMotor = Integer.parseInt(req.getParameter("powerMotor"));
				int kmMotor = Integer.parseInt(req.getParameter("kmMotor"));
				m.setPower(powerMotor);
				m.setKm(kmMotor);
				vehicleMotorbike = vehicleservice.update(m);
				break;
			case "Airplane":
				// code block
				Vehicle vehicleAirplane = new Airplane();
				vehicleAirplane.setId(id);
				vehicleAirplane.setBrand(brand);
				vehicleAirplane.setHirePrice(price);
				vehicleAirplane.setMaxSpeed(maxSpeed);
				vehicleAirplane.setModel(model);
				Airplane a = (Airplane) vehicleAirplane;
				int nbMotors = Integer.parseInt(req.getParameter("nbMotors"));
				a.setNbMotor(nbMotors);
				vehicleMotorbike = vehicleservice.update(a);
				break;
			}

		/*	if (vehicle instanceof Vehicle) {

				req.setAttribute("msg", "mission faild");
				req.setAttribute("flag", "false");

			} else {

				req.setAttribute("msg", "mission accomplished");
				req.setAttribute("flag", "true");

			}*/

			resp.sendRedirect(req.getContextPath() + "/vehicle/sheet?id=" + id);
		}
	}
}
