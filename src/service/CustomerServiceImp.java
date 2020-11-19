package service;

import java.util.ArrayList;
import java.util.List;

import dao.CustomerDao;
import model.Customer;
import dao.CustomerDaoInterface;

public class CustomerServiceImp implements CustomerServiceInterface{
	CustomerDaoInterface dao = new CustomerDao();
	@Override
	public int createNew(Customer newClient) {
		return dao.createNew(newClient);
	}

	@Override
	public List<Customer> getAll() {
		return dao.getAll();
	}

	@Override
	public Customer get(int id) {
		return dao.get(id);
	}
	
	public ArrayList<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}
}
