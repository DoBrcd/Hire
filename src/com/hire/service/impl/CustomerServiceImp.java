package com.hire.service.impl;

import com.hire.dao.CustomerDaoInterface;
import com.hire.dao.impl.CustomerDao;
import com.hire.model.Customer;
import com.hire.service.CustomerServiceInterface;

import java.util.List;
import java.util.Map;

public class CustomerServiceImp implements CustomerServiceInterface
{
	private CustomerDaoInterface dao = new CustomerDao();

	@Override
	public int createNewCustomer(Customer newClient){
		return dao.createNewCustomer(newClient);
	}

	@Override
	public Customer getById(int id) {
		return dao.getById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}

	public void update(Customer customer) {
		dao.update(customer);
	}

	public void remove(int customerId) {
		dao.remove(customerId);
	}

	@Override
	public List<Customer> getAllCustomersByCriteria(String name) {
		return dao.getAllCustomersByCriteria(name);
	}

	@Override
	public List<Map.Entry<Customer, Long>> getBestHiringCustomer()
	{
		return dao.getBestHiringCustomer();
	}

	@Override
	public List<Map.Entry<Customer, Double>> getBestBuyerCustomer()
	{
		return dao.getBestBuyerCustomer();
	}
}
