package dao;

import model.Customer;
import model.Vehicle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
				System.out.println("Exception occured while reading user data: " + exception.getMessage());
				return null;
			}

		} else {
			System.out.println("DB server down.....");
		}
		return null;

	}
	
	/**
	 * Update a customer in database
	 * @param A customer instance with the updated data
	 */
	@Override
	public void update(Customer customer) {
		if(em != null) {
			try {
				Customer entityCustomer = em.find(Customer.class, customer.getId());
				em.getTransaction().begin();
				entityCustomer.setName(customer.getName());
				entityCustomer.setFirstName(customer.getFirstName());
				entityCustomer.setEmail(customer.getEmail());
				entityCustomer.setPhone(customer.getPhone());
				entityCustomer.setAddress(customer.getAddress());
				em.getTransaction().commit();
			}catch(Exception exception) {
				System.out.println("Exception occured while reading user data: " + exception.getMessage());
			}
		} else {
			System.out.println("DB server down.....");
		}
	}
	
	/**
	 * remove a customer from database
	 * @param The Id of the customer to remove
	 */
	@Override
	public void remove(int customerId) {
		if(em != null) {
			try {
				Customer customer = em.find(Customer.class, customerId);
				em.getTransaction().begin();
				em.remove(customer);
				em.getTransaction().commit();
			}catch(Exception exception) {
				System.out.println("Exception occured while reading user dara: " + exception.getMessage());
			}
		}else {
			System.out.println("DB server down.....");
		}
	}

	@Override
	public List<Customer> getAllCustomersByCriteria(String reqSearch) {
		if (em != null) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
			Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
			Predicate predicateForName = criteriaBuilder.like(customerRoot.get("name"),"%"+reqSearch+"%");
			Predicate predicateForMail = criteriaBuilder.like(customerRoot.get("email"),"%"+ reqSearch+"%");

			Predicate predicate = criteriaBuilder.or(predicateForName, predicateForMail);
			
			try {
				criteriaQuery.where(predicate);
				Query query =  em.createQuery(criteriaQuery);
				List<Customer> customers = (List<Customer>) query.getResultList();
				return customers;
			} catch (Exception exception) {
				System.out.println("Exception occured while reading user data: " + exception.getMessage());
				return null;
			}

		} else {
			System.out.println("DB server down.....");
		}
		return null;
	}
}
