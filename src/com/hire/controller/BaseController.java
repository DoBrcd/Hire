package com.hire.controller;

import com.hire.model.Employee;
import com.hire.service.EmployeeServiceInterface;
import com.hire.service.impl.EmployeeServiceImp;

import model.Employee;
import service.EmployeeServiceImp;
import service.EmployeeServiceInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Base class used to centralized some methods shared by all application's controllers
 */
public class BaseController extends HttpServlet {
	protected EmployeeServiceInterface employeeService;

	public BaseController()
	{
		employeeService = new EmployeeServiceImp();
	}

	/**
	 * Tells if a user is currently authenticated or not
	 * @param request The current HttpServletRequest
	 * @return True if a user is authenticated, else false
	 */
	protected boolean isAuthenticated(HttpServletRequest request)
	{
		return  (request.getSession().getAttribute("id") != null);
	}

	/**
	 * Tells if a user is currently connected or not and send a redirection to login page
	 *
	 * @param request The current HttpServletRequest
	 * @param response The response that will be sent. Used to redirect user when they are not authenticated
	 *
	 * @return True if user was authenticated, else false. When false, response is set to redirect to login page
	 *
	 * @throws IOException Exception could be thrown by redirection
	 */
	protected boolean isAuthenticated(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		boolean isAuthenticated = isAuthenticated(request);

		if(!isAuthenticated)
			response.sendRedirect(request.getContextPath() + "/");

		return isAuthenticated;
	}

	/**
	 * Sends a given view to user
	 * @param req The current HttpServletRequest to be sent to JSP
	 * @param resp The response that will be sent to user, which is dispatch to JSP
	 * @param viewName The view name as the path to the corresponding JSP file
	 * @param title The title of the view (default is "Hire")
	 */
	protected void redirectToView(HttpServletRequest req, HttpServletResponse resp, final String viewName, final String title)
	{
		req.setAttribute("title", title);
		if(isAuthenticated(req))
        {
            EmployeeServiceInterface service = new EmployeeServiceImp();

            final Employee employee = (Employee) req.getSession().getAttribute("employee");

            boolean canUserCreate = service.canManage(employee);

            req.setAttribute("userCanAccessStats", service.canAccessStats(employee));
            req.setAttribute("userCanCreate", canUserCreate);

            if(canUserCreate)
            {
                req.setAttribute("userCanCreateVehicle", service.canManageVehicle(employee));
                req.setAttribute("userCanCreateCustomer", service.canManageCustomer(employee));
                req.setAttribute("userCanCreateHiring", service.canManageHiring(employee));
                req.setAttribute("userCanCreateEmployee", service.canManageEmployee(employee));
            }
        }
		RequestDispatcher rd = getServletContext().getRequestDispatcher(viewName);

		try
		{
			rd.forward(req, resp);
		}
		catch(ServletException | IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends a given view to user
	 * @param req The current HttpServletRequest to be sent to JSP
	 * @param resp The response that will be sent to user, which is dispatch to JSP
	 * @param viewName The view name as the path to the corresponding JSP file
	 */
	protected void redirectToView(HttpServletRequest req, HttpServletResponse resp, final String viewName)
	{
		redirectToView(req, resp, viewName, "Hire");
	}

	/**
	 * Redirects user to the home page
	 * @param req The current HttpServletRequest to be sent to JSP
	 * @param resp The response that will be sent to user, which is dispatch to JSP
	 */
	protected void redirectToHome(HttpServletRequest req, HttpServletResponse resp)
	{
		redirectToView(req, resp, "/home");
	}

	protected Employee getEmployee(HttpServletRequest req)
	{
		Employee e = null;

		if(isAuthenticated(req))
			e = (Employee) req.getSession().getAttribute("employee");

		return e;
	}
}
