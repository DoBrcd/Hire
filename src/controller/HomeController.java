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
    public static final String pageName = "/views/home.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if(isAuthenticated(req, resp))
        {
            EmployeeServiceInterface service = new EmployeeServiceImp();

            redirectToView(req, resp, pageName, "Home");
        }
    }
}
