package model;


import java.util.ArrayList;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.internal.build.AllowSysOut;

import service.DBManager;

@Entity
@DiscriminatorValue("CustomerManager")
public class CustomerManager extends Employee implements I_CustomerManager {
	private EntityManager em=DBManager.getEntityManager();
	@Override
	public void createClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClient() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Customer> getAllClients() {
		 
		  if (em != null) {
		   try {	     
			   Query query = em.createQuery("SELECT * FROM Customer");
			    ArrayList<Customer> customers = (ArrayList<Customer>) query.getResultList();
			    if (customers == null) {
			      System.out.println("Aucun clients n'existes");
			    }
			    System.out.println("coucou");
			    System.out.println(customers);
			    return customers;
		   } catch (Exception exception) {
		    System.out.println("Exception occred while reading user data: "
		      + exception.getMessage());
		    return null;
		   }

		  } else {
		   System.out.println("DB server down.....");
		   return null;
		  }
	}

}
