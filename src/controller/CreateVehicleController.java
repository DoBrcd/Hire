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
public class CreateVehicleController extends BaseController {
	
	/**
	 * 
	 */
	private final String pageName="/vehicle/create.jsp";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doGet(req, resp);

		
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
		
		super.doPost(req, resp);

        String vehicleType = req.getParameter("vehicleType");
        String model = req.getParameter("model");
        String brand = req.getParameter("brand");
        String state = req.getParameter("state");
        float price = Float.parseFloat(req.getParameter("price"));
        int maxSpeed =Integer.parseInt(req.getParameter("maxSpeed"));
        Vehicle v = null;
        
        VehicleServiceInterface vehicleservice=new VehicleServiceImp();
        Vehicle newvehicle=null;
        switch(vehicleType) {
        case "Car":
          // code block
        	Car c=new Car();
            int powercar =Integer.parseInt(req.getParameter("powercar"));
            int kmCar =Integer.parseInt(req.getParameter("kmCar"));
            int sitsnumber =Integer.parseInt(req.getParameter("sitsnumber"));
            c.setPower(powercar);
            c.setKm(kmCar);
            c.setSitsNumber(sitsnumber);
            
            c.setBrand(brand);
            c.setHirePrice(price);
            c.setMaxSpeed(maxSpeed);
            c.setState(state);
            c.setModel(model);
           	c.setState(state);
           	
           	 newvehicle=vehicleservice.add(c);
     
         
          break;
        case "Motorbike":
          // code block
        	Motorbike m=new Motorbike();
            int powerMotor =Integer.parseInt(req.getParameter("powerMotor"));
            int kmMotor =Integer.parseInt(req.getParameter("kmMotor"));
            m.setPower(powerMotor);
            m.setKm(kmMotor);
            
            m.setBrand(brand);
            m.setHirePrice(price);
            m.setMaxSpeed(maxSpeed);
            m.setState(state);
            m.setModel(model);
           	m.setState(state);
           	
           	 newvehicle=vehicleservice.add(m);
           
          break;
        case "Aireplane":
            // code block
        	Airplane a=new Airplane();
            int nbMotors =Integer.parseInt(req.getParameter("nbMotors"));
            a.setNbMotor(nbMotors);
            
            a.setBrand(brand);
            a.setHirePrice(price);
            a.setMaxSpeed(maxSpeed);
            a.setState(state);
            a.setModel(model);
           	a.setState(state);
           	
           	 newvehicle=vehicleservice.add(a);
          
            break;

      }
        
    
   
       
        
    
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