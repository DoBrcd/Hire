package dao;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public interface CustomerDaoInterface {
	/**
	 * createNewCustomer
	 * @param newClient
	 * @return id, -1 if error
	 */
	public int createNewCustomer(Customer newClient);
	
	public List<Customer>  getAll();
	
	public Customer getById(int id);
	
	public ArrayList<Customer> getAllCustomers();
}
