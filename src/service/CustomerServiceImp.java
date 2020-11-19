package service;

import java.util.ArrayList;

import dao.CustomerDao;
import model.Customer;

public class CustomerServiceImp implements CustomerServiceInterface {
	private CustomerDao customerDao = new CustomerDao();
	@Override
	public ArrayList<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}
	
=======
import java.util.List;

import javax.persistence.EntityManager;

import dao.CustomerDao;
import dao.CustomerDaoInterface;
import model.Customer;

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
}
