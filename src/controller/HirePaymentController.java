package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hire;
import model.Vehicle;
import service.HireServiceImp;
import service.VehicleServiceImp;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/return")
public class HirePaymentController extends BaseController {
	String viewName = "/hire/payement.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			redirectToView(req, resp, viewName);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int idHire = Integer.parseInt(req.getParameter("idHire"));
		int km = Integer.parseInt(req.getParameter("km"));
		HireServiceImp hireService = new HireServiceImp();
		Hire hire = hireService.getById(idHire);
		Vehicle vehicle = hire.getVehicle();
		float prix = hireService.getPayement(km, vehicle.getHirePrice(), hire.getReduction());
		hire.setKmExpected(km);
		hire.setPriceExpected(prix);
		hireService.update(hire);
	}
}
