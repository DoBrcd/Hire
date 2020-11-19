package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EmployeeServiceImp;
import service.EmployeeServiceInterface;

@WebServlet("/")
public class AuthentificationController extends HttpServlet {
	final String pageName = "/login.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession maSession = req.getSession();
		String id = (String) maSession.getAttribute("id");
		if (id != null) {
			resp.sendRedirect(req.getContextPath() + "/home");
			return;
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (username.trim().length() >= 0 && username != null && password.trim().length() >= 0 && password != null) {
			EmployeeServiceInterface employeService = new EmployeeServiceImp();
			boolean flag = employeService.login(username, password);
			if (flag) {
				HttpSession maSession = req.getSession();
				maSession.setAttribute("id", username);
				String position = employeService.getPosition(username);
				maSession.setAttribute("position", position);
				resp.sendRedirect(req.getContextPath() + "/home");
			} else {
				req.setAttribute("msg", "Wrong Username or Password, Try again!!!");
			}
		} else {
			req.setAttribute("msg", "Please enter username and password...");
		}
		req.getRequestDispatcher(pageName).include(req, resp);
	}
}
