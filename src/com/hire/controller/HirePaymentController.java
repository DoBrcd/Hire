package com.hire.controller;

import com.hire.model.Hire;
import com.hire.model.StatePayement;
import com.hire.model.Vehicle;
import com.hire.service.impl.HireService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/return")
public class HirePaymentController extends BaseController {
	String viewName = "/views/hire/payement.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			if(!employeeService.canManageHiring(getEmployee(req))) {
				redirectToHome(req, resp);
			}
			else
			{
				String idHire  = req.getParameter("id");
				req.setAttribute("idHire", idHire);
				redirectToView(req, resp, viewName, "Paiement location");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(isAuthenticated(req, resp))
		{
			if(!employeeService.canManageHiring(getEmployee(req))) {
				redirectToHome(req, resp);
			}
			else
			{
				int idHire = Integer.parseInt(req.getParameter("idHire"));
				int km = Integer.parseInt(req.getParameter("km"));
				System.out.println(idHire);
				System.out.println(km);
				HireService hireService = new HireService();
				Hire hire = hireService.getById(idHire);
				Vehicle vehicle = hire.getVehicle();
				float prix = hireService.getPayement(km, vehicle.getHirePrice(), hire.getReduction());
				hire.setKmExpected(km);
				hire.setPriceExpected(prix);
				hire.setPayement(StatePayement.Paid);
				hireService.update(hire);
				resp.sendRedirect("/Hire/research");
			}
		}
	}
}
