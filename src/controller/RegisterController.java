package controller;

import service.EmployeeServiceImp;
import service.EmployeeServiceInterface;
import service.Encrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends BaseController {
	public enum Position {
		Employee, GeneralManager, TechnicalManager, CustomerManager, CommercialManager
	}

	public static final String pageName = "/register.jsp";
	private static final Position[] positionsList = { Position.Employee, Position.GeneralManager,
			Position.TechnicalManager, Position.CustomerManager, Position.CommercialManager };

	public static Position[] getPositionsList() {
		return positionsList;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isAuthenticated(req))
			resp.sendRedirect(req.getContextPath() + "/");
		else {
			redirectToView(req, resp, pageName);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");

		if (password.equals(confirmPassword)) {

			password = Encrypt.encrypt(password, "ENSSAT-Lannion");

			if (username != null && password != null && username.trim().length() > 0 && password.trim().length() > 0) {
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
		req.getRequestDispatcher(pageName).include(req, resp);
	}
}
