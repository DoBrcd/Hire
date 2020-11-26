package com.hire.dao;

import com.hire.model.Employee;

import java.util.List;

public interface EmployeeDaoInterface {
	
	 public Employee login(String username, String password);
	 public int register(Employee user);
	 public String getPosition(String s);
	 public List<Employee> getAll();
	 public Employee getByid(int id);
	 public Employee update(Employee v);
	 public boolean delete(Employee v);

}
