package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Airplane;
import model.Car;
import model.Motorbike;
import model.Vehicle;
import service.VehicleServiceImp;
import service.VehicleServiceInterface;

@WebServlet("/vehicle/create")
public class CreateVehicleController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession maSession=req.getSession();
		 String id=(String)maSession.getAttribute("id");
		 String pageName="/login.jsp";
		 if(id!=null) {
			pageName="/createVehicle.jsp"; 
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
		
		

        String vehicleType = req.getParameter("vehicleType");
        String model = req.getParameter("model");
        String brand = req.getParameter("brand");
        String state = req.getParameter("state");
        float price = Float.parseFloat(req.getParameter("price"));
        int maxSpeed =Integer.parseInt(req.getParameter("maxSpeed"));
        Vehicle v;
        switch(vehicleType) {
        case "Car":
          // code block
        	v=new Car();
        	
          break;
        case "Motorbike":
          // code block
        	v=new Motorbike();
          break;
        case "Aireplane":
            // code block
        	v=new Airplane();
            break;
        default:
          // code block
        	v=new Vehicle();
      }
        v.setBrand(brand);
        v.setHirePrice(price);
        v.setMaxSpeed(maxSpeed);
        v.setState(state);
        v.setModel(model);
       	v.setState(state);
        VehicleServiceInterface vehicleservice=new VehicleServiceImp();
        Vehicle newvehicle=vehicleservice.add(v);
        
    
     if(newvehicle !=null) {
    	req.setAttribute("msg", "mission accomplished");
    	req.setAttribute("flag", "true");
    	 
     }else {
    	 req.setAttribute("msg", "mission faild");
     	req.setAttribute("flag", "false");
     
     }
     
     String pageName="/createVehicle.jsp"; 
     
	  RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
	  try {
	    rd.forward(req, resp);
	  } catch (ServletException e) {
	    e.printStackTrace();
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
       
	}
	}