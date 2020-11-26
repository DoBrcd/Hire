package com.hire.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hire.model.Hire;
import com.hire.model.StatePayement;
import com.hire.model.Vehicle;
import com.hire.service.impl.HireService;

import java.io.IOException;

@WebServlet("/return")
public class HirePaymentController extends BaseController {
	String viewName = "/views/hire/payement.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			if(!employeeService.canManageHiring(getEmployee(req))) {
				redirectToHome(req, resp);
			}else
			{
				System.out.println("coucou1111");
				String idHire  = req.getParameter("id");
				req.setAttribute("idHire", idHire);
				System.out.println(idHire);
				redirectToView(req, resp, viewName, "Paiement location");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
