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
	
}
