package service;

import java.util.List;

import model.Employee;

public interface EmployeeServiceInterface {
	 public boolean login(String username, String password);

	 public String registration(Employee e);
	 public String getPosition(String s);
	 public Employee createEmployee(Employee e);
	 
	 public List<Employee> getAll();
	 public Employee getByid(Long id);
	 public Employee update(Employee v);
	 public boolean delete(Employee v);

}
