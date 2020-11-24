package controller;

import service.EmployeeServiceImp;
import service.EmployeeServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

import java.io.IOException;

@WebServlet("/home")
public class HomeController extends BaseController
{
    public static final String pageName = "home.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if(isAuthenticated(req, resp))
        {
            EmployeeServiceInterface service = new EmployeeServiceImp();

            final Employee user = (Employee) req.getSession().getAttribute("employee");

            boolean canUserCreate = service.canCreate(user);

            req.setAttribute("userCanAccessStats", service.canAccessStats(user));
            req.setAttribute("userCanCreate", canUserCreate);

            if(canUserCreate)
            {
                req.setAttribute("userCanCreateVehicle", service.canCreateVehicle(user));
                req.setAttribute("userCanCreateCustomer", service.canCreateCustomer(user));
                req.setAttribute("userCanCreateHiring", service.canCreateHiring(user));
                req.setAttribute("userCanCreateEmployee", service.canCreateEmployee(user));
            }

            req.getRequestDispatcher(pageName).include(req, resp);
        }
    }
}
