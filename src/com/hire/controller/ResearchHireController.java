package com.hire.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hire.model.Hire;
import com.hire.service.HireServiceInterface;
import com.hire.service.VehicleServiceInterface;
import com.hire.service.impl.HireService;
import com.hire.service.impl.VehicleServiceImp;

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

		if (isAuthenticated(req, resp)) {
			HireServiceInterface hService = new HireService();
			VehicleServiceInterface vService = new VehicleServiceImp();
			List<String> models = vService.getAllModels();
			List<String> brands = vService.getAllBrand();

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


		if (isAuthenticated(req, resp)) {
			 HireServiceInterface hService = new HireService();
			VehicleServiceInterface vService = new VehicleServiceImp();
			List<String> models = vService.getAllModels();
			List<String> brands = vService.getAllBrand();

			String vehicleType = req.getParameter("vehicleType");
			String brand = req.getParameter("brand");
			String model = req.getParameter("model");
			String reqResearch = req.getParameter("reqResearch");
			
			req.setAttribute("models", models);
			req.setAttribute("brands", brands);
			int codeResearche=0;
			int codeModel=0;
			int codeBrand=0;
			int codeType=0;
			
			if( !reqResearch.equals("")) {
				 codeResearche=1;
			}
			if(! vehicleType.equals("not-selected")) {
				codeType=1;		
						}
			if( !brand.equals("not-selected")) {
				codeBrand=1;
				
			}
			if( !model.equals("not-selected")) {
				codeModel=1;
			}
			int code=(codeModel* 1)+(codeBrand* 2)+(codeType*4)+(codeResearche* 8);
			
		 System.out.println(code);
		 System.out.println(codeModel+"  "+codeBrand +" "+codeType +"   "+codeResearche);
				List<Hire> Hires = hService.getAll(code, model,  brand,  vehicleType,  reqResearch);
				req.setAttribute("Hires", Hires);
				req.setAttribute("msg", "msg");
			
			redirectToView(req, resp, pageName, "Research Vehicle");
		}

	
		

	}
}
