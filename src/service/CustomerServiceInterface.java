package service;

import java.util.List;

import model.Customer;

public interface CustomerServiceInterface {

	public int createNew(Customer newClient);
	
	public List<Customer>  getAll();
	
	public Customer get(int id);
}
