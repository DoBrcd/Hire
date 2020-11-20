package dao;

import model.Customer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import service.DBManager;

public class CustomerDao implements CustomerDaoInterface {
	private EntityManager em = DBManager.getEntityManager();

	/**
	 * Create a new Customer sheet and store it in database
	 * @param newClient Customer we need to store in database
	 * @return Customer id if Customer was well store, else -1
	 */
	@Override
	public int createNewCustomer(Customer newClient) {
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

	/**
	 * Return a Customer stored in database based on id
	 * @param id The id of the customer we look for
	 * @return Customer if we find it, else null
	 */
	@Override
	public Customer getById(int id) {
		return em.find(Customer.class, id);
	}

	/**
	 * get all customers from the database
	 * @param 
	 * @return List of customers
	 */
	@Override
	public List<Customer> getAllCustomers() {
		if (em != null) {
			try {
				Query query = em.createQuery("select p from Customer p");
				List<Customer> customers = (List<Customer>) query.getResultList();
				return customers;
			} catch (Exception exception) {
				System.out.println("Exception occred while reading user data: " + exception.getMessage());
				return null;
			}

		} else {
			System.out.println("DB server down.....");
		}
		return null;

	}

}
