package dao;

import java.util.List;

import model.Customer;

public interface CustomerDaoInterface {
	public int createNew(Customer newClient);
	
	public List<Customer>  getAll();
	
	public Customer get(int id);
}
