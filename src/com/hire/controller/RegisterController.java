package com.hire.controller;

import com.hire.model.*;
import com.hire.service.EmployeeServiceInterface;
import com.hire.service.Encrypt;
import com.hire.service.impl.EmployeeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends BaseController {
	/**
	 * Enum which list all available position for an employee
	 */
	public enum Position {
		Employee, GeneralManager, TechnicalManager, CustomerManager, CommercialManager
	}

	public static final String pageName = "/views/register.jsp";

	/**
	 * Array containing all employee's positions
	 */
	private static final Position[] positionsList = { Position.Employee, Position.GeneralManager,
			Position.TechnicalManager, Position.CustomerManager, Position.CommercialManager };

	/**
	 * Returns the array of all the possible employee's positions
	 * @return Array of all possible employee' positions
	 */
	public static Position[] getPositionsList() {
		return positionsList;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			if(!employeeService.canManageEmployee(getEmployee(req)))
				redirectToHome(req, resp);
			else
				redirectToView(req, resp, pageName, "Register New Employee");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (isAuthenticated(req, resp)) {
			if(!employeeService.canManageEmployee(getEmployee(req)))
				redirectToHome(req, resp);
			else
			{
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				String confirmPassword = req.getParameter("confirmPassword");

				if (password.equals(confirmPassword)) {

					password = Encrypt.encrypt(password, "ENSSAT-Lannion");

					if (username != null && password != null && username.trim().length() > 0
							&& password.trim().length() > 0) {
						EmployeeServiceInterface employeService = new EmployeeServiceImp();
						Employee newEmployee;
						switch (req.getParameter("position")) {
							case "Employee":
								newEmployee = new Employee(username, password);
								break;
							case "GeneralManager":
								newEmployee = new GeneralManager(username, password);
								break;
							case "TechnicalManager":
								newEmployee = new TechnicalManager(username, password);
								break;
							case "CommercialManager":
								newEmployee = new CommercialManager(username, password);
								break;
							case "CustomerManager":
								newEmployee = new CustomerManager(username, password);
								break;
							default:
								newEmployee = new Employee(username, password);
								break;
						}
						employeService.registration(newEmployee);
					} else {
						req.setAttribute("msg", "Please enter username and password...");
					}
				} else {
					req.setAttribute("msg", "Password and Confirm does not correspond");
				}

				redirectToView(req, resp, pageName, "Register New Employee");
			}
		}
	}
}
