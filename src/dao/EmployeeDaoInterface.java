package dao;

import java.util.List;

import model.Employee;
import model.Vehicle;

public interface EmployeeDaoInterface {
	
	 public Employee login(String username, String password);
	 public int register(Employee user);
	 public String getPosition(String s);
	 public List<Employee> getAll();
	 public Employee getByid(int id);
	 public Employee update(Employee v);
	 public boolean delete(Employee v);

}
