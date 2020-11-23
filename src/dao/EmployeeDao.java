package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.CommercialManager;
import model.Employee;
import model.Vehicle;
import service.DBManager;


public class EmployeeDao implements EmployeeDaoInterface {
	
	private EntityManager em=DBManager.getEntityManager();
	 @Override
	 public boolean login(String username, String password) {
	 
	  if (em != null) {
	   try {	     
		   Query query = em.createQuery("select p from Employee p where p.identifiant=:identifiant").setParameter("identifiant", username);
		    Employee employee = (Employee) query.getSingleResult();
		    if (employee == null) {
		      System.out.println("Personne non trouvée");
		    } else {
		    	if (password.equals(employee.getPassword())) {
		    	     System.out.println("employee: " + employee.toString()+" "+employee.getDecriminatorValue());
		    	     
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

	@Override
	public String getPosition(String username) {
		{
			String position="Employee";
			 
			  if (em != null) {
			   try {	     
				   Query query = em.createQuery("select p from Employee p where p.identifiant=:identifiant").setParameter("identifiant", username);
				    Employee employee = (Employee) query.getSingleResult();
				    if (employee == null) {
				      System.out.println("Personne non trouvée");
				    } else {
				    	
				    	    position=employee.getDecriminatorValue();
				    	     
				    	     return position;
				    	    }
				    
			   } catch (Exception exception) {
			    System.out.println("Exception occred while reading user data: "
			      + exception.getMessage());
			    return position;
			   }

			  } else {
			   System.out.println("DB server down.....");
			  }
			  return position;
			 }
	


}

	@Override
	public Employee CreateEmployee(Employee e) {

	    EntityTransaction transac = em.getTransaction();
	    transac.begin();
	    em.merge(e);
	    transac.commit();
		return e;
	}

	@Override
	public List<Employee> getAll() {
		  List<Employee> employees = em.createQuery("Select v From Employee v",
				  Employee.class).getResultList();
		  return employees;
	}

	@Override
	public Employee getByid(Long id) {
		return em.find(Employee.class, id);
	}

	@Override
	public Employee update(Employee v) {
		 em.getTransaction().begin();
	     em.merge(v);
	     em.getTransaction().commit();
	  	 return v;
	}

	@Override
	public boolean delete(Employee v) {
		try {
			  em.getTransaction().begin();
			  em.remove(v);
			  em.getTransaction().commit();
			  return true;
				
			}catch(Exception e) {
				return false;
			}
	}
}