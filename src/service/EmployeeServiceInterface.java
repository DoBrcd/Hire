package service;

import java.util.List;

import model.Employee;

public interface EmployeeServiceInterface {
	public Employee login(String username, String password);


	 public int registration(Employee e);
	 public String getPosition(String s);
	 
	 public List<Employee> getAll();
	 public Employee getByid(int id);
	 public Employee update(Employee v);
	 public boolean delete(Employee v);

	/**
	 * Tells if a given employee can create a vehicle
	 * @param employee as an Employee object
	 * @return True if the user is allowed to create a vehicle, else false
	 */
	public boolean canCreateVehicle(Employee employee);

	/**
	 * Tells if a given employee can create a customer
	 * @param employee as an Employee object
	 * @return True if the user is allowed to create a customer, else false
	 */
	public boolean canCreateCustomer(Employee employee);

	/**
	 * Tells if a given employee can create a hiring
	 * @param employee as an Employee object
	 * @return True if the user is allowed to create an hiring, else false
	 */
	public boolean canCreateHiring(Employee employee);

	/**
	 * Tells if a given employee can access to statistics
	 * @param employee as an Employee object
	 * @return True if the user is allowed to access statistics, else false
	 */
	public boolean canAccessStats(Employee employee);

	/**
	 * Tells if a given employee can access to create employee
	 * @param employee as an Employee object
	 * @return True if the user is allowed to access create employee, else false
	 */
	public Object canCreateEmployee(Employee employee);

	/**
	 * Tells if a given employee can do a creation, whatever it is
	 * @param employee as an Employee object
	 * @return True if the user is allowed to do a creation, else false
	 */
	boolean canCreate(Employee employee);

}
