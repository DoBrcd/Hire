package dao;

import model.Customer;

import java.util.List;

public interface CustomerDaoInterface {
	
	/**
	 * Create a new Customer sheet and store it in database
	 * @param newClient Customer we need to store in database
	 * @return Customer id if Customer was well store, else -1
	 */
	public int createNewCustomer(Customer newClient);
	
	/**
	 * Return a Customer stored in database based on id
	 * @param id The id of the customer we look for
	 * @return Customer if we find it, else null
	 */
	public Customer getById(int id);
	
	/**
	 * get all customers from the database
	 * @return List of customers
	 */
	public List<Customer> getAllCustomers();
	
	/**
	 * Update a customer in database
	 * @param A customer instance with the updated data
	 */
	public void update(Customer customer);
	
	/**
	 * remove a customer from database
	 * @param The Id of the customer to remove
	 */
	public void remove(int customerId);
	
	/**
	 * return a list of customers by criteria
	 * @return List of customers by criteria
	 */
	public List<Customer> getAllCustomersByCriteria(String name);
}
