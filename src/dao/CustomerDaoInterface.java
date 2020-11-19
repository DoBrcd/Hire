package dao;

import model.Customer;

import java.util.ArrayList;

public interface CustomerDaoInterface {
	public ArrayList<Customer> getAllCustomers();
=======
import java.util.List;

import model.Customer;

public interface CustomerDaoInterface {
	public int createNew(Customer newClient);
	
	public List<Customer>  getAll();
	
	public Customer get(int id);
}
