package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmployeeServiceImp;
import service.EmployeeServiceInterface;

@WebServlet("/")
public class AuthentificationController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pageName="/login.jsp";
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
     
        System.out.println(username + " :: " + password);
        String page = "login.jsp";
        if(username.trim().length() >= 0 && username != null &&
          password.trim().length() >= 0 && password != null) {
         EmployeeServiceInterface employeService = new EmployeeServiceImp();
         boolean flag = employeService.login(username, password);
         if(flag) {
          System.out.println("Login success!!!");
          req.setAttribute("username", username);
          req.setAttribute("msg", "Login Success.....");
          page = "home.jsp";
         } else {
          req.setAttribute("msg", "Wrong Username or Password, Try again!!!");
         }
        } else {
         req.setAttribute("msg", "Please enter username and password...");
        }
        req.getRequestDispatcher(page).include(req, resp);
       }
	}
	
	

