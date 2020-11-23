package dao;

import java.util.List;

import model.Employee;
import model.Vehicle;

public interface EmployeeDaoInterface {
	
	 public boolean login(String username, String password);
	 public String register(Employee user);
	 public String getPosition(String s);
	 public Employee CreateEmployee(Employee e);
	 public List<Employee> getAll();
	 public Employee getByid(Long id);
	 public Employee update(Employee v);
	 public boolean delete(Employee v);

}
