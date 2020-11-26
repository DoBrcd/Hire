package com.hire.controller;

import com.hire.model.Employee;
import com.hire.service.EmployeeServiceInterface;
import com.hire.service.Encrypt;
import com.hire.service.impl.EmployeeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/")
public class AuthentificationController extends BaseController
{
    public static final String pageName = "/views/login.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if(isAuthenticated(req))
            resp.sendRedirect(req.getContextPath() + "/home");
        else
        {
            redirectToView(req, resp, pageName);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        password = Encrypt.encrypt(password, "ENSSAT-Lannion");
        boolean succeeded = false;

        if(username != null && password != null && username.trim().length() > 0 && password.trim().length() > 0)
        {
            EmployeeServiceInterface employeeService = new EmployeeServiceImp();
            Employee employee = employeeService.login(username, password);
            if(employee != null)
            {
                HttpSession maSession = req.getSession();
                maSession.setAttribute("employee", employee);
                maSession.setAttribute("id", username);
                String position = employeeService.getPosition(username);
                maSession.setAttribute("position", position);

                succeeded = true;
            }
            else
            {
                req.setAttribute("msg", "Wrong Username or Password, Try again!!!");
            }
        }
        else
        {
            req.setAttribute("msg", "Please enter username and password...");
        }

        if(succeeded)
            resp.sendRedirect(req.getContextPath() + "/home");
        else
            redirectToView(req, resp, pageName);
    }
}
