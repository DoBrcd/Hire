package dao;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import service.DBManager;

public class CustomerDao implements CustomerDaoInterface {
	private EntityManager em = DBManager.getEntityManager();

	/**
	 * createNewCustomer
	 * 
	 * @param newClient
	 * @return id, -1 if error
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

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * getById
	 * 
	 * @param id
	 * @return Customer
	 */
	@Override
	public Customer getById(int id) {
		return em.find(Customer.class, id);
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {
		if (em != null) {
			try {
				Query query = em.createQuery("select p from Customer p");
				ArrayList<Customer> customers = (ArrayList<Customer>) query.getResultList();
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
