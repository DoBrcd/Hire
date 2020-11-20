package service;

import java.util.ArrayList;
import java.util.List;

import dao.CustomerDao;
import model.Customer;
import dao.CustomerDaoInterface;

public class CustomerServiceImp implements CustomerServiceInterface{
	private CustomerDaoInterface dao = new CustomerDao();
	
	/**
	 * createNewCustomer
	 * @param newClient
	 * @return id, -1 if error
	 */
	@Override
	public int createNewCustomer(Customer newClient){
		return dao.createNewCustomer(newClient);
	}

	@Override
	public List<Customer> getAll() {
		return dao.getAll();
	}

	/**
	 * getById
	 * @param id
	 * @return Customer
	 */
	@Override
	public Customer getById(int id) {
		return dao.getById(id);
	}
	
	public ArrayList<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}
}
