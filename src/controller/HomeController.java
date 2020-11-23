package controller;

import service.EmployeeServiceImp;
import service.EmployeeServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

            final String position = (String) req.getSession().getAttribute("position");

            boolean canUserCreate = service.canCreate(position);

            req.setAttribute("userCanAccessStats", service.canAccessStats(position));
            req.setAttribute("userCanCreate", canUserCreate);

            if(canUserCreate)
            {
                req.setAttribute("userCanCreateVehicle", service.canCreateVehicle(position));
                req.setAttribute("userCanCreateCustomer", service.canCreateCustomer(position));
                req.setAttribute("userCanCreateHiring", service.canCreateHiring(position));
            }

            req.getRequestDispatcher(pageName).include(req, resp);
        }
    }
}
