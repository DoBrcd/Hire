package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Airplane;
import model.Car;
import model.Motorbike;
import model.Hire;
import service.HireService;
import service.HireService;
import service.HireServiceInterface;
import service.VehicleServiceImp;
import service.VehicleServiceInterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/research")
public class ResearchHireController extends BaseController {

	private static final long serialVersionUID = 1L;

	private final String pageName = "/hire/research.jsp";


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HireServiceInterface hService = new HireService();
		 VehicleServiceInterface vService = new VehicleServiceImp();
		 List<String> models = vService.getAllModels();
		 List<String> brands = vService.getAllBrand();
		if (isAuthenticated(req, resp)) {

			List<Hire> Hires = hService.getAll();
			req.setAttribute("models", models);
			req.setAttribute("brands", brands);
			req.setAttribute("Hires", Hires);
			redirectToView(req, resp, pageName, "Research Hire");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			redirectToView(req, resp, pageName, "Research Hire");
			
		

	}
}
