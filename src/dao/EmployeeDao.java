package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Hibernate;

import model.Employee;
import service.DBManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDao implements EmployeeDaoInterface {
	
	private EntityManager em=DBManager.getEntityManager();
	 @Override
	 public boolean login(String username, String password) {
	 
	  if (em != null) {
	   try {
		   Query query = em.createQuery("select p from Employee p where p.identifiant=1");
		    Employee employee = (Employee) query.getSingleResult();
		    if (employee == null) {
		      System.out.println("Personne non trouvée");
		    } else {
		    	if (password.equals(employee.getPassword())) {
		    	     System.out.println("employee: " + employee.toString());
		    	     return true;
		    	    }
		    }
	   } catch (Exception exception) {
	    System.out.println("Exception occred while reading user data: "
	      + exception.getMessage());
	    return false;
	   }

	  } else {
	   System.out.println("DB server down.....");
	  }
	  return false;
	 }

	 @Override
	 public String register(Employee user) {
	  String msg = "Registration unsuccessful, try again.....";
	 return "jjjjjjjjjj";
	 }


}
