package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;
import service.VehicleServiceImp;
import service.VehicleServiceInterface;

@WebServlet("/vehicle/research")
public class ResearchVehicleController extends BaseController {

	private static final long serialVersionUID = 1L;

	private final String pageName = "/vehicle/research.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD

		super.doGet(req, resp);
		
		VehicleServiceInterface vService = new VehicleServiceImp();
		List<Vehicle> vehicles = vService.getAll();
		req.setAttribute("vehicles", vehicles);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
=======
		if (isAuthenticated(req, resp)) {
			VehicleServiceInterface vService = new VehicleServiceImp();
			List<Vehicle> data = vService.getAll();
			req.setAttribute("data", data);
			redirectToView(req, resp, pageName);
>>>>>>> d0218c3d39916064aa58b81a68d1fa40bfed1a5d
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
