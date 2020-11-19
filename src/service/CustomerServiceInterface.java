package service;
import model.Customer;
import java.util.ArrayList;

public interface CustomerServiceInterface {
	public ArrayList<Customer> getAllCustomers();
=======

import java.util.List;

import model.Customer;

public interface CustomerServiceInterface {

	public int createNew(Customer newClient);
	
	public List<Customer>  getAll();
	
	public Customer get(int id);
}
