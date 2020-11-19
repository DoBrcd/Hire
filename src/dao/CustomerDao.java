package dao;

import model.Customer;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import service.DBManager;

public class CustomerDao implements CustomerDaoInterface {
	private EntityManager em=DBManager.getEntityManager();
	
	public ArrayList<Customer> getAllCustomers(){
		if(em != null) {
			try {
				Query query = em.createQuery("select p from Customer p");
				ArrayList<Customer> customers = (ArrayList<Customer>) query.getResultList();
				return customers;
			}catch (Exception exception) {
			    System.out.println("Exception occred while reading user data: "
			  	      + exception.getMessage());
			  	return null;
	  	   }

		} else {
			System.out.println("DB server down.....");
		}
		return null;
		
	}
=======
import java.util.List;

import javax.persistence.EntityManager;

import model.Customer;
import service.DBManager;

public class CustomerDao implements CustomerDaoInterface {
	EntityManager em = DBManager.getEntityManager();
	@Override
	public int createNew(Customer newClient) {
		try {
			em.getTransaction().begin();
			em.persist(newClient);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			return -1;
		}
		return newClient.getId();
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer get(int id) {
		return em.find(Customer.class, id);
	}

}
