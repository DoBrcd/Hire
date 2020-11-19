package dao;

import model.Employee;

public interface EmployeeDaoInterface {
	
	 public boolean login(String username, String password);

	 public String register(Employee user);
	 public String getPosition(String s);
	 public Employee CreateEmployee(Employee e);

}
