package service;

import model.Employee;

public interface EmployeeServiceInterface {
	 public boolean login(String username, String password);

	 public String registration(Employee e);
	 public String getPosition(String s);
	 public Employee createEmployee(Employee e);

}
