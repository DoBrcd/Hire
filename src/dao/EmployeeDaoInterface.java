package dao;

import model.Employee;

public interface EmployeeDaoInterface {
	
	 public boolean login(String username, String password);

	 public String register(Employee user);

}
