package service;
import model.Customer;
import java.util.ArrayList;

import java.util.List;

public interface CustomerServiceInterface {

	/**
	 * createNewCustomer
	 * @param newClient
	 * @return id, -1 if error
	 */
	public int createNewCustomer(Customer newClient);
	
	public List<Customer>  getAll();
	
	/**
	 * getById
	 * @param id
	 * @return Customer
	 */
	public Customer getById(int id);
	
	public ArrayList<Customer> getAllCustomers();
}
