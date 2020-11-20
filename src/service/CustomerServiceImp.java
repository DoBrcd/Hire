package service;

import java.util.List;

import dao.CustomerDao;
import model.Customer;
import dao.CustomerDaoInterface;

public class CustomerServiceImp implements CustomerServiceInterface{
	private CustomerDaoInterface dao = new CustomerDao();
	
	/**
	 * Create a new Customer sheet and store it in database
	 * @param newClient Customer we need to store in database
	 * @return Customer id if Customer was well store, else -1
	 */
	@Override
	public int createNewCustomer(Customer newClient){
		return dao.createNewCustomer(newClient);
	}

	/**
	 * Return a Customer stored in database based on id
	 * @param id The id of the customer we look for
	 * @return Customer if we find it, else null
	 */
	@Override
	public Customer getById(int id) {
		return dao.getById(id);
	}
	/**
	 * return a list of customers
	 * @return List of customers
	 */
	@Override
	public List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}
}
