package controller;

import service.EmployeeServiceImp;
import service.EmployeeServiceInterface;
import service.Encrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/")
public class AuthentificationController extends BaseController
{
    public static final String pageName = "/login.jsp";

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
        //password = Encrypt.encrypt(password, "ENSSAT-Lannion");
        System.out.println(password);

        if(username != null && password != null && username.trim().length() > 0 && password.trim().length() > 0)
        {
            EmployeeServiceInterface employeService = new EmployeeServiceImp();
            boolean flag = employeService.login(username, password);
            if(flag)
            {
                HttpSession maSession = req.getSession();
                maSession.setAttribute("id", username);
                String position = employeService.getPosition(username);
                maSession.setAttribute("position", position);
                resp.sendRedirect(req.getContextPath() + "/home");
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
        req.getRequestDispatcher(pageName).include(req, resp);
    }
}
