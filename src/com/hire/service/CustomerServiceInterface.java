package com.hire.service;

import com.hire.model.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerServiceInterface {

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
	 * @param customer A customer instance with the updated data
	 */
	public void update(Customer customer);
	
	/**
	 * remove a customer from database
	 * @param customerId The Id of the customer to remove
	 */
	public void remove(int customerId);

	/**
	 * lister toutes les clients par critère
	 * @param name String name
	 * @return List de toutes les clients correpondant au crit�re
	 */
	public List<Customer> getAllCustomersByCriteria(String name);

	/**
	 * List the 10 customers that have hired the most
	 * @return A list of maximum 10 pairs of customers and the number of hiring. The list is ordered DESC.
	 */
	public List<Map.Entry<Customer, Long>> getBestHiringCustomer();

	/**
	 * List the 10 customers that have payed the most
	 * @return A list of maximum 10 pairs of customers and the total amount of money they spent. The list is ordered DESC.
	 */
	public List<Map.Entry<Customer, Double>> getBestBuyerCustomer();
}
